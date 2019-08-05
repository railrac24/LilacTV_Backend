package com.lilactv.backend.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
data class Answers (
        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "replier_id")
        @JsonProperty
        var replier: User,
        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "question_id")
        @JsonProperty
        var questions: Question,
        @JsonProperty
        var content: String,
        var createDate: LocalDateTime,
        @JsonProperty
        @Id @GeneratedValue var id: Long? = null
) {
    constructor(writer: User, questions: Question, content: String): this(writer, questions, content, LocalDateTime.now())
    fun getFormattedCreateDate(): String {
        return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))
    }

    fun updateContent(title: String, content: String) {
        this.content = content
    }
}