package org.example.services;

import org.example.models.dtos.ContactMessageDto;

public interface EmailService {
    void sendContactEmail(ContactMessageDto contactMessage);

}
