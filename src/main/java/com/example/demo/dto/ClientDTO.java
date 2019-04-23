package com.example.demo.dto;

import com.example.demo.domain.Client;
import com.example.demo.util.ConvertUtil;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;

public class ClientDTO extends BaseDTO<Client> {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Length(min = 3, max = 12)
    private String password;
    @Length(min = 1, max = 1)
    private String gender;
    @Max(100)
    @Min(1)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void copyPropsTo(Client target) {
        this.copyProperties(this, target);
    }

    @Override
    public Client convert() {
        Client c = new Client();
        this.copyProperties(this, c);
        return c;
    }
}
