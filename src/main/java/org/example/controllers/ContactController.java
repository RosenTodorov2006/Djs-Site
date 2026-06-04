package org.example.controllers;

import jakarta.validation.Valid;
import org.example.models.dtos.ContactMessageDto;
import org.example.services.EmailService;
import org.example.services.impl.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {
    private final EmailService emailService;

    public ContactController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }
    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("contactMessage", new ContactMessageDto());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid @ModelAttribute("contactMessage") ContactMessageDto contactMessage,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "contact";
        }

        try {
            emailService.sendContactEmail(contactMessage);
            redirectAttributes.addFlashAttribute("success", true);
            return "redirect:/contact";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/contact";
        }
    }
}
