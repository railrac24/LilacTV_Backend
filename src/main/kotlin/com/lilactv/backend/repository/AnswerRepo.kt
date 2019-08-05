package com.lilactv.backend.repository

import com.lilactv.backend.model.Answers
import com.lilactv.backend.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepo: JpaRepository<Answers, Long> {
    fun findAllByReplier(replier: User): MutableList<Answers>?
}