package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.MongoUser;

import ca.dss.csd.cct.project.services.MongoUserDetailService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private MongoUserDetailService userService;

    @Autowired
    public UserController(MongoUserDetailService service) {
        this.userService = service;
    }


    @PostConstruct
    public void test() {
    }
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/newUserForm")
    public String getNewUserForm(Model model) {
        model.addAttribute("user", new MongoUser());
        return "newUserForm";
    }

    @PostMapping("signup")
    public String signUp(@ModelAttribute MongoUser user, Model model) {
        System.out.println("signup");
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/login";
    }


}
