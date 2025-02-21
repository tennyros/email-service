package com.github.tennyros.email.dto;

public record EmailRequest(
        String to,
        String subject,
        String body
) {
}
