package com.lilactv.backend.controller

import com.lilactv.backend.services.HttpSessionUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.lang.IllegalStateException
import javax.servlet.http.HttpSession

@Controller
class HomeController {
    @Autowired
    lateinit var loginSession: HttpSessionUtils

    @GetMapping("/index")
    fun mainPage(): String {
        return "index"
    }

    @GetMapping("/manual")
    fun manualPage(): String {
        return "manual"
    }

    @GetMapping("/qnaList")
    fun qnaPage(): String {
        return "qnaList"
    }

    @GetMapping("/firmware")
    fun firmwarePage(model: Model, session: HttpSession): String {
        try {
            loginSession.hasLilacTV(session)
        } catch (e: IllegalStateException) {
            model["errorMsg"] = e.message!!
            return "login"
        }
        return "firmware"
    }
}