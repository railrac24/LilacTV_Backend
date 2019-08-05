package com.lilactv.backend.services

import com.lilactv.backend.model.User
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import javax.servlet.http.HttpSession

@Service
class HttpSessionUtils {
    private val USER_SESSION_KEY = "session_user"

    fun isLoginUser(session: HttpSession): Boolean {
        if (session.getAttribute(USER_SESSION_KEY) == null)
            throw IllegalStateException("로그인이 필요합니다.")
        return false
    }

    fun getUserFromSession(session: HttpSession): User? {
        isLoginUser(session)
        return session.getAttribute(USER_SESSION_KEY) as User
    }

    fun hasPermission(session: HttpSession, user: User? = null): Boolean {
        isLoginUser(session)
        val loginUser = getUserFromSession(session)
        if (!(session.getAttribute("admin") as Boolean)){
            if (user != null) {
                if (user.id != loginUser!!.id) throw IllegalStateException("권한이 없습니다.")
            } else throw IllegalStateException("권한이 없습니다.")
        }
        return true
    }

    fun hasLilacTV(session: HttpSession): Boolean {
        isLoginUser(session)
        if (!(session.getAttribute("lilactvUser") as Boolean))
            throw IllegalStateException("권한이 없습니다.")
        return true
    }

}