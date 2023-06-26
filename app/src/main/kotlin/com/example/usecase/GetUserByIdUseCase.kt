package com.example.usecase

import com.example.domain.Id
import com.example.domain.User
import com.example.port.UserPort

class GetUserByIdUseCase(
    private val userPort: UserPort
) {
    fun getUserbyId(userId: Id): User {
        return userPort.getUserById(userId)
    }
}