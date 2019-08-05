package com.lilactv.backend.repository

import com.lilactv.backend.model.Question
import com.lilactv.backend.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepo: JpaRepository<Question, Long> {
    fun findAllByWriter(writer: User): MutableList<Question>?
}