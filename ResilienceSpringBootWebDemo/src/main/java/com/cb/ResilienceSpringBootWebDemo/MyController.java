package com.cb.ResilienceSpringBootWebDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MyController {

    @Value("${msg: Did not get data from repo}")
    private  String message;
    @GetMapping("/greet")
    public String sendMessage(){
        return  message;
    }
}
