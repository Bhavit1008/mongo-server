package com.backend.server.config;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
 
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Component
@EnableAsync
public class Scheduler {

    @Scheduled(fixedRate = 2000)
    @Async
    public void taskWithFixedRate() throws InterruptedException {
        System.out.println("Task with Fixed Rate, " + (LocalTime.now().getSecond()));
        MILLISECONDS.sleep(4000L);
    }
}