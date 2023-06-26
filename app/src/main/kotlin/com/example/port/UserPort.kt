package com.example.port

import com.example.domain.Id
import com.example.domain.User

interface UserPort {
    fun getUserById(userId: Id): User
}