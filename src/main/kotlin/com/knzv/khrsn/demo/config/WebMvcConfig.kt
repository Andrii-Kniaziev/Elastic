package com.knzv.khrsn.demo.config

import com.knzv.khrsn.demo.interceptor.UserRequestLoggingInterceptor
import com.knzv.khrsn.demo.interceptor.RequestHeaderCheckInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig(
    private val requestHeaderCheckInterceptor: RequestHeaderCheckInterceptor,
    private val userRequestLoggingInterceptor: UserRequestLoggingInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(requestHeaderCheckInterceptor)
            .addPathPatterns("/**")

        registry.addInterceptor(userRequestLoggingInterceptor)
            .addPathPatterns("/**")
            .order(Ordered.LOWEST_PRECEDENCE)
    }
}