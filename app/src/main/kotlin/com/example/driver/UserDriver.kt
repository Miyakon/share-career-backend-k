package com.example.driver

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

//import org.jetbrains.exposed.sql.`java-time`.datetime

class UserDriver {
    object UserTable : IntIdTable("user") {
        val name = varchar("name", 255)
//        val createdAt = datetime("created_at").default(LocalDateTime.now())
    }

    fun connection(id: Int): ResultRow? {
        Database.connect("jdbc:mysql://127.0.0.1:3306/user", driver = "com.mysql.jdbc.Driver", user = "root", password = "root")

        var user: ResultRow? = null
        transaction {
            // Query the user with the given ID
            user = UserTable.select { UserTable.id eq id }.singleOrNull()
        }

        val name = user?.let { it[UserTable.name] }

        return user
    }

}