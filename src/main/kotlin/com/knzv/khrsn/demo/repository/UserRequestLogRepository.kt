package com.knzv.khrsn.demo.repository

import com.knzv.khrsn.demo.entity.UserRequestLogEntity
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserRequestLogRepository : ElasticsearchRepository<UserRequestLogEntity, Long>
