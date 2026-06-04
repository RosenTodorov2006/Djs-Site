package org.example.services.impl;

import org.example.models.dtos.ContactMessageDto;
import org.example.services.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(ContactMessageDto contactMessage) {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("djdtjl@gmail.com");
        mail.setTo("emaildjwork@gmail.com");
        mail.setReplyTo(contactMessage.getEmail());
        mail.setSubject("Ново съобщение от сайта Megapod - " + contactMessage.getName());
        mail.setText("Име: " + contactMessage.getName() + "\n" +
                "Имейл: " + contactMessage.getEmail() + "\n" +
                "Телефон: " + contactMessage.getPhone() + "\n\n" +
                "Съобщение:\n" + contactMessage.getMessage());

        mailSender.send(mail);
    }
}
