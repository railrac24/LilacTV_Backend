package com.lilactv.backend.repository

import com.lilactv.backend.model.Item
import com.lilactv.backend.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepo: JpaRepository<Item, Long> {
    fun findAllByOnline(online: Boolean): MutableList<Item>?
    fun findByMacaddeth0(macaddeth0: String): Item?
    fun findByOwner(owner: User): Item?
}