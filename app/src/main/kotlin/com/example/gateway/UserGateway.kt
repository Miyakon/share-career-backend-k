package com.example.gateway

import com.example.domain.Id
import com.example.domain.User
import com.example.driver.UserDriver
import com.example.port.UserPort

class UserGateway: UserPort {

    private val userDriver = UserDriver()
    override fun getUserById(userId: Id): User {
        val userInfo = userDriver.connection(userId.value)
        User(Id(userInfo), Name(), PublishDate())
    }

}