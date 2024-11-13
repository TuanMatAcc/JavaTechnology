package com.example.Ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/about")
    @ResponseBody
    public String getAbout() {
        return "About this site";
    }

    @PostMapping("/contact")
    public String postContact(Model model, @RequestParam("name") String name, @RequestParam("type") String type) {
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        return "display";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
}
