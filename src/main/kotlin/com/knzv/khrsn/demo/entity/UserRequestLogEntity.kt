package com.knzv.khrsn.demo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "request_logs")
data class UserRequestLogEntity(
    @Id
    private val id: String? = null,
    private val requestType: String,
    private val requestPath: String,
    private val responseStatusCode: Int,
    private val calledByUser: String
)
