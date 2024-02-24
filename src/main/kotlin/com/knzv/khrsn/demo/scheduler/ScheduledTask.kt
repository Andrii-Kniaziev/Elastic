package com.knzv.khrsn.demo.scheduler

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalTime

@Component
class ScheduledTask {

    @Scheduled(cron = "0 */5 * * * *") // Every five mins
    fun printMessage() {
        val time = LocalTime.now()
        println("Hello, it is:  ${time.hour}:${time.minute}")
    }
}