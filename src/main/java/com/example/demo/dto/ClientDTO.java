package com.example.demo.dto;

import com.example.demo.domain.Client;
import com.example.demo.util.ConvertUtil;
import org.springframework.beans.BeanUtils;

public class ClientDTO extends BaseDTO<Client> {
    private String name;
    private String email;
    private String password;
    private String gender;
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
}
