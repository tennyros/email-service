package com.github.tennyros.email.kafka;

import com.github.tennyros.email.dto.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailProducer {

    private final KafkaTemplate<String, EmailRequest> kafkaTemplate;

    public void sendEmailEvent(EmailRequest emailRequest) {
        kafkaTemplate.send("email-topic", emailRequest);
    }
}
