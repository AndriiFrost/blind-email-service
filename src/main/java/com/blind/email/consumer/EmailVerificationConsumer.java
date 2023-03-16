package com.blind.email.consumer;

import com.blind.common.kafka.event.EmailVerificationEvent;
import com.blind.email.email.EmailSender;
import com.blind.email.entity.UserVerificationToken;
import com.blind.email.service.UserVerificationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailVerificationConsumer {

    private final UserVerificationTokenService userVerificationTokenService;
    private final EmailSender emailSender;

    @KafkaListener(
            topics = "${spring.kafka.topic.name.email}",
            groupId = "${spring.kafka.consumer.group-id}")
    private void consume(EmailVerificationEvent emailVerificationEvent) {
        log.info(String.format("Email verification info ===> %s", emailVerificationEvent.toString()));
        UserVerificationToken userVerificationToken = userVerificationTokenService
                .createUserVerificationToken(emailVerificationEvent.getBlindUserId());
        String link = "http://localhost:8085/api/v1/email/confirm?token=" + userVerificationToken.getToken();
        String email = buildEmail(userVerificationToken.getBlindUser().getEmail(), link);
        emailSender.send(userVerificationToken.getBlindUser().getEmail(), email);
    }

    private String buildEmail(String name, String link) {
        return "<div>" +
                "<a href=\"" + link + "\">Activate Now</a>" +
                "</div>";
    }
}
