package com.knzv.khrsn.demo.interceptor

import com.knzv.khrsn.demo.entity.UserRequestLogEntity
import com.knzv.khrsn.demo.repository.UserRequestLogRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class UserRequestLoggingInterceptor(
    private val userRequestLogRepository: UserRequestLogRepository
) : HandlerInterceptor {

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val requestType = request.method
        val requestPath = request.requestURI
        val responseStatusCode = response.status
        val calledByUser = request.getHeader("JWT_TOKEN")?.let {
            it.split(" ")[1]
        } ?: "Login request was made, or JWT_TOKEN header not added to the request accidentally."

        println(
            """
            Request Type: $requestType
            Request Path: $requestPath 
            Response Status Code: $responseStatusCode 
            User: $calledByUser
        """.trimIndent()
        )

        userRequestLogRepository.save(
            UserRequestLogEntity(
                requestType = requestType,
                requestPath = requestPath,
                responseStatusCode = responseStatusCode,
                calledByUser = calledByUser
            )
        )
    }
}