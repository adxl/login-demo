package com.adxl.login.controllers;

import com.adxl.login.models.User;
import com.adxl.login.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner
{
    UsersRepository usersRepository;

    public DbSeeder(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        List<User> users = usersRepository.findAll();
        for (User user : users)
        {
            System.out.println(user.getUsername()+"-"+user.getPassword());

        }
    }
}
