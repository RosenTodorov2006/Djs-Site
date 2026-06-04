package org.example.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactMessageDto {

    @NotBlank(message = "Името е задължително.")
    @Size(min = 2, max = 50, message = "Името трябва да е между 2 и 50 символа.")
    private String name;

    @NotBlank(message = "Имейлът е задължителен.")
    @Email(message = "Моля, въведете валиден имейл адрес.")
    private String email;

    @Size(max = 15, message = "Телефонният номер не може да бъде по-дълъг от 15 символа.")
    private String phone;

    @NotBlank(message = "Съобщението е задължително.")
    @Size(min = 10, max = 2000, message = "Съобщението трябва да е между 10 и 2000 символа.")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}