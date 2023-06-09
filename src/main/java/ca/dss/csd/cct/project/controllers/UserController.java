package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.Log;
import ca.dss.csd.cct.project.entity.MongoUser;
import ca.dss.csd.cct.project.exceptions.UserException;
import ca.dss.csd.cct.project.services.LogService;
import ca.dss.csd.cct.project.services.LogServiceImpl;
import ca.dss.csd.cct.project.services.MongoUserDetailService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private MongoUserDetailService userService;
    private LogService logService;

    @Autowired
    public UserController(MongoUserDetailService service, LogService logService) {
        this.userService = service;
        this.logService = logService;
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
    public String signUp(@Valid @ModelAttribute("user") MongoUser user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newUserForm";
        }
        try {
            MongoUser saved = userService.saveUser(user);
            logService.logNewUser(user);
        } catch (UserException e) {
            model.addAttribute("error", e.getMessage());
            return "newUserForm";
        }
        return "redirect:/login";
    }


}
