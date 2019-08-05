package com.lilactv.backend.repository

import com.lilactv.backend.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}