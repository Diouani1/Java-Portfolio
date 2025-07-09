package j.project.portfolio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping({"/", "", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("title", "Home");
        return "master";
    }

    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("title", "Über Mich");
        return "master";
    }


    @GetMapping("/project")
    public String showProjectPage(Model model) {
        model.addAttribute("title", "Projekte");
        return "master";
    }

    @GetMapping("/resume")
    public String showResumePage(Model model) {
        model.addAttribute("title", "Lebenslauf");
        return "master";
    }
}
