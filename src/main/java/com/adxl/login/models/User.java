package com.adxl.login.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection="users")
public class User
{
    @Id
    @NotNull
    private String username;

    @NotNull
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    public User(String username, String password, String firstName, String lastName, String email)
    {
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    @Override
    public String toString()
    {
        return "User{"+
                "username='"+username+'\''+
                ", firstName='"+firstName+'\''+
                ", lastName='"+lastName+'\''+
                '}';
    }
}
