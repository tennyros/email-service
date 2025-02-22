package com.github.tennyros.email.controller;

import com.github.tennyros.email.dto.EmailRequest;
import com.github.tennyros.email.kafka.EmailProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailProducer emailProducer;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailProducer.sendEmailEvent(emailRequest);
        return "Email was add in queue!";
    }
}
