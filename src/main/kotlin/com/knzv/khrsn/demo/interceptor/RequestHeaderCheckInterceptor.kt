package com.knzv.khrsn.demo.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class RequestHeaderCheckInterceptor : HandlerInterceptor {

    companion object {
        private const val REQUIRED_X_VERSION = 1
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val versionHeaderValue = request.getHeader("X-VERSION")

        if (versionHeaderValue == null || (versionHeaderValue.toIntOrNull() ?: 0) <= REQUIRED_X_VERSION) {
            response.status = HttpServletResponse.SC_BAD_REQUEST
            response.writer.write("Invalid or missing X-VERSION header.")
            return false
        }

        return true
    }
}