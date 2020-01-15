package com.adxl.login.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection="users")
public class User
{
    @Id
    @NotNull
    @Size(min=4)
    private String username;

    @NotNull
    @Size(min=6)
    private String password;

    private String firstName;

    public User(String username, String password, String firstName)
    {
        this.username=username;
        this.password=password;
        this.firstName=firstName;
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

    @Override
    public String toString()
    {
        return "User{"+
                "username='"+username+'\''+
                ", firstName='"+firstName+'\''+
                '}';
    }
}
