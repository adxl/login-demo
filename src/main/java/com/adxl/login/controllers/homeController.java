package com.adxl.login.controllers;

import com.adxl.login.models.User;
import com.adxl.login.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class homeController
{
    UsersRepository usersRepository;

    public homeController(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }

    @GetMapping("/home/{id}")
    public String showHome(ModelMap modelMap, @PathVariable String id)
    {
        Optional user = usersRepository.findById(id);
        if (!user.isPresent())
            return "redirect:/login";
        System.out.println(((User)user.get()).getFirstName());
        modelMap.addAttribute("user",((User)user.get()).getFirstName());
        return "home";
    }
}
