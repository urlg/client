package com.demo.config.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 定时任务
 */
@Configuration
//@EnableScheduling
//@EnableAsync
@Slf4j
public class DynamicScheduleTask {

    @Async
    @Scheduled(fixedDelay = 20000,initialDelay = 10000)
    public void first() {
        log.error("定时任务开始 : " + LocalDateTime.now().toLocalTime() + "线程 : " + Thread.currentThread().getName());
    }
}
