package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CustomerRepository customerRepository;
    private String user = null;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("userInfo",user);
        return "hoby.html";
    }
    @PostMapping ("/registration")
    public String mainPage11(@RequestParam String name, @RequestParam String password, @RequestParam String password2) {
        if (password.contains(password2)){
            customerRepository.save(new Customer(name, password));
        }
        return "redirect:/";
    }
    @PostMapping ("/login")
    public String mainPage12(@RequestParam String name, @RequestParam String password) {
        System.err.println(name);
        System.err.println(password);
        try {
            Customer el = customerRepository.findByName(name).get(0);
            System.err.println(el);
            System.err.println(el.getPassword());
            if (password.contains(el.getPassword())){
                user = el.getName();
            }
        } catch (Exception e) {
            user = "Такой пользователь не найден!";
        }


        return "redirect:/";
    }
    @GetMapping("/hoby")
    public String mainPage0() {
        return "hoby.html";
    }
    @GetMapping("/logout")
    public String mainPage10() {
        user = null;
        return "redirect:/";
    }
    @GetMapping("/shop")
    public String mainPage1() {
        return "shop.html";
    }
    @GetMapping("/registration")
    public String mainPage2() {
        return "registration.html";
    }
    @GetMapping("/login")
    public String mainPage3() {
        return "login.html";
    }
}
