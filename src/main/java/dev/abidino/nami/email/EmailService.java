package dev.abidino.nami.email;

import dev.abidino.nami.exception.BadRequestException;
import dev.abidino.nami.exception.ErrorMessageType;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public record EmailService(JavaMailSender javaMailSender, Environment environment) {
    public void sendSimpleMail(EmailDetails details) {
        try {
            String sender = environment.getProperty("spring.mail.username");
            if (Objects.isNull(sender)) {
                throw new BadRequestException(ErrorMessageType.ERROR_MAIL_SEND.getMessage());
            }
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.recipient());
            mailMessage.setText(details.msgBody());
            mailMessage.setSubject(details.subject());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            System.err.println("Error while Sending Mail : " + e.getMessage());
            throw new BadRequestException(ErrorMessageType.ERROR_MAIL_SEND.getMessage());
        }
    }
}