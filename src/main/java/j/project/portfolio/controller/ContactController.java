package j.project.portfolio.controller;

import j.project.portfolio.model.ContactForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("title", "Kontakt");
        model.addAttribute("contactForm", new ContactForm());
        return "master";
    }

    @PostMapping("/contact")
    public String submitContactForm(
            @Valid @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult bindingResult,
            Model model) {
        model.addAttribute("title", "Kontakt");

        if (bindingResult.hasErrors()) {
            return "master";
        }

        // ✉️ Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your_email@example.com"); // change to your actual email
        message.setSubject("Neue Nachricht von Portfolio Kontaktformular");
        message.setText(
                "Name: " + contactForm.getName() + "\n" +
                        "E-Mail: " + contactForm.getEmail() + "\n" +
                        "Telefon: " + contactForm.getPhone() + "\n\n" +
                        "Nachricht:\n" + contactForm.getMessage()
        );

        mailSender.send(message);

        model.addAttribute("success", true);
        model.addAttribute("contactForm", new ContactForm()); // reset form
        return "master";
    }
}
