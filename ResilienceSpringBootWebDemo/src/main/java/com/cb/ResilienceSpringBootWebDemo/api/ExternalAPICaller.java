package com.cb.ResilienceSpringBootWebDemo.api;

import org.springframework.stereotype.Component;

@Component
public class ExternalAPICaller {
    public ExternalAPICaller() {
        System.out.println("External API caller");
    }

    public String callApi() {

        return "external API call";
    }
    public String callApiRetry(String message) {
    if(message.equals("error"))
        throw  new RuntimeException("error");
    return "external API call Retry";
    }
    public String callApiSlowRate(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignore) {
        }
        return "external API call SLOW";
    }

    public String callApiWithDelay() {
        String result ="external API call with delay";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignore) {
        }
        return result;
    }
}
