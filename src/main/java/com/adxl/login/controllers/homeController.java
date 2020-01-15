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

    @GetMapping("/home/{code}")
    public String showHome(ModelMap modelMap, @PathVariable String code)
    {
        Optional user = usersRepository.findByCode(code);
        if (!user.isPresent())
            return "redirect:/login";
        modelMap.addAttribute("user",((User)user.get()).getFirstName());
        return "home";
    }
}
