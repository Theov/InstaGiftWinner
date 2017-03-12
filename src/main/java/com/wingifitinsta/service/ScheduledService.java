package com.wingifitinsta.service;

import org.springframework.scheduling.annotation.Scheduled;

@org.springframework.stereotype.Service
public class ScheduledService {

    @Scheduled(cron="*/5 * * * *")
    public void hello(){
        System.out.println("Hello ;)");
    }
}
