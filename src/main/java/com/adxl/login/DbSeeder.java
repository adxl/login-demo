package com.adxl.login;

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

        //usersRepository.deleteAll();
        List<User> users=usersRepository.findAll();

        for (User user : users)
            System.out.println(user);
        String s = "hello";
        System.out.println(s.substring(0,1).toUpperCase().concat(s.substring(1)));
    }

}
