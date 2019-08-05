package com.lilactv.backend.model

import javax.persistence.*

@Entity
data class Item (
        var macaddeth0: String,
        var macaddwlan: String,
        var ipadd: String,
        var online: Boolean,
        var tvheadend: Boolean,
        var seqindex: Int?,
        @Id @GeneratedValue var id : Long? = null,
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "owner_id")
        var owner: User?
)