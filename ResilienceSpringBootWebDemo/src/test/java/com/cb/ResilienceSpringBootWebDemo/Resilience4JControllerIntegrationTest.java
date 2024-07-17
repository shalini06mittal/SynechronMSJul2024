package com.cb.ResilienceSpringBootWebDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.HttpHeaders;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Resilience4JControllerIntegrationTest {

    @Autowired
    TestRestTemplate template;

    @RepeatedTest(10)
    public void test1(RepetitionInfo repetitionInfo) {
        int delay = 1 + (repetitionInfo.getCurrentRepetition() % 2);
        ResponseEntity<String> response = template.
                getForEntity("/api/circuit-breaker/"+delay, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}

