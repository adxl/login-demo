package com.adxl.login.controllers;

import com.adxl.login.models.User;
import com.adxl.login.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class SignupController implements WebMvcConfigurer
{
    public UsersRepository usersRepository;

    public SignupController(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user)
    {
        return "signup";
    }

    @PostMapping("/signup")
    public String checkUserInfos(@Valid User user, BindingResult bindingResult, ModelMap modelMap)
    {
        if (usersRepository.findById(user.getUsername()).isPresent() || bindingResult.hasErrors())
        {
            modelMap.addAttribute("error", "This username is not available");
            return "signup";
        }
        while (usersRepository.findByCode(user.getCode()).isPresent())
        {
            user.refreshCode();
        }
        usersRepository.save(user);
        modelMap.remove("error");
        return "redirect:/login";
    }
}
