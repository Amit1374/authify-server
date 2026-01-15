package com.example.authify.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.api.url}")
    private String apiUrl;

    @Value("${mail.from}")
    private String fromEmail;

    private final RestTemplate restTemplate = new RestTemplate();

    // -------------------- INTERNAL GENERIC SENDER --------------------
    private void sendEmail(String to, String subject, String textContent) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", apiKey);

        Map<String, Object> body = Map.of(
                "sender", Map.of("email", fromEmail),
                "to", List.of(Map.of("email", to)),
                "subject", subject,
                "textContent", textContent   // <-- plain text (same as SMTP)
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(apiUrl, entity, String.class);
    }

    // -------------------- SAME METHODS AS BEFORE --------------------

    public void sendWelcomeEmail(String toEmail, String name) {
        String text = "Hello " + name +
                "\n\nThanks for registering with us!" +
                "\n\nRegards,\nAuthify Team";

        sendEmail(toEmail, "Welcome to our Platform", text);
    }

    public void sendResetOtpEmail(String toEmail, String otp) {
        String text = "Your OTP for resetting your password is " + otp +
                ". Use this OTP to reset your password";

        sendEmail(toEmail, "Password Reset OTP", text);
    }

    public void sendOtpEmail(String toEmail, String otp) {
        String text = "Your OTP is " + otp +
                ". Verify your account using this OTP.";

        sendEmail(toEmail, "Account Verification OTP", text);
    }
}

