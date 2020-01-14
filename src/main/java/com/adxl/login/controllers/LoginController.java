package com.adxl.login.controllers;

import com.adxl.login.models.User;
import com.adxl.login.repositories.UsersRepository;
import org.omg.CosNaming.BindingIterator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class LoginController implements WebMvcConfigurer
{
    public UsersRepository usersRepository;

    public LoginController(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/home").setViewName("home");
    }

    @GetMapping("/login")
    public String showLoginForm(User user)
    {
        return "login";
    }

    @PostMapping("/login")
    public String checkCredentials(@Valid User user, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors() || !usersRepository.findById(user.getUsername()).isPresent())
            return "login";

        User existingUser=usersRepository.findById(user.getUsername()).get();
        if (user.getPassword().equals(existingUser.getPassword()))
            return "redirect:/home/"+user.getUsername();
        return "login";
    }


}
