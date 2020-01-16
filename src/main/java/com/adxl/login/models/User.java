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

    private String code;

    public User(String username, String password, String firstName)
    {
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.code=String.valueOf((int) (Math.random()*900000+100000));
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
        return firstName.substring(0,1).toUpperCase().concat(firstName.substring(1));
    }

    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getCode()
    {
        return code;
    }

    public void refreshCode()
    {
        code=String.valueOf((int) (Math.random()*900000+100000));
    }

    @Override
    public String toString()
    {
        return "User{"+
                "username='"+username+'\''+
                ", firstName='"+getFirstName()+'\''+
                ", code='"+code+'\''+
                '}';
    }
}
