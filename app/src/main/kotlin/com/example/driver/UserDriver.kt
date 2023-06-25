package com.example.driver

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserDriver {
    object User : IntIdTable("user") {
        val name = varchar("name", 255)
    }

    fun connection(id: Int): String? {
        Database.connect("jdbc:mysql://127.0.0.1:3306/user", driver = "com.mysql.jdbc.Driver", user = "root", password = "root")

        var user: ResultRow? = null
        transaction {
            // Query the user with the given ID
            user = User.select { User.id eq id }.singleOrNull()
        }
        return user?.let { it[User.name] }
    }

}