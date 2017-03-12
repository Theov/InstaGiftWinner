package com.wingifitinsta.web;

import com.wingifitinsta.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ScheduledService scheduledService;

    @RequestMapping("/")
    public void entryPoint(){
        scheduledService.hello();
    }
}
