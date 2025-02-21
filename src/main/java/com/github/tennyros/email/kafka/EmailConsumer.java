package com.github.tennyros.email.kafka;

import com.github.tennyros.email.dto.EmailRequest;
import com.github.tennyros.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "email-topic", groupId = "email-service")
    public void consumeEmailEvent(EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
    }
}
