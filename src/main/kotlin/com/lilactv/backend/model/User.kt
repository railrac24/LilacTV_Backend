package com.lilactv.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User (
        @JsonProperty
        var name: String,
        @JsonProperty
        var email: String,
        @JsonProperty
        var mobile: String,
        @JsonIgnore
        var password: String,
        @JsonProperty
        @Id @GeneratedValue var id: Long? = null
)