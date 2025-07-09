package j.project.portfolio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @NotBlank(message = "Name ist erforderlich")
    private String name;

    @NotBlank(message = "E-Mail ist erforderlich")
    @Email(message = "Ungültige E-Mail-Adresse")
    private String email;

    @NotBlank(message = "Telefonnummer ist erforderlich")
    private String phone;

    @NotBlank(message = "Nachricht ist erforderlich")
    @Size(min = 10, message = "Die Nachricht muss mindestens 10 Zeichen lang sein")
    private String message;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
