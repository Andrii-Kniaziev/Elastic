package com.knzv.khrsn.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {
    companion object {
        private const val LOGIN_ERR_MESSAGE = "User or password are incorrect"
    }

    // Simplified method which will return simplified token
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<String> {
        val password = fakeUserStorage[loginRequest.email]
            ?: return ResponseEntity(LOGIN_ERR_MESSAGE, HttpStatus.NOT_FOUND)

        if (password != loginRequest.password) {
            return ResponseEntity(LOGIN_ERR_MESSAGE, HttpStatus.NOT_FOUND)
        }

        return ResponseEntity("Bearer ${loginRequest.email}", HttpStatus.OK)
    }

    private val fakeUserStorage = mapOf (
        "andrii@gmail.com" to "1111",
        "tom@gmail.com" to "2222"
    )

    data class LoginRequest(
        val email: String,
        val password: String
    )
}