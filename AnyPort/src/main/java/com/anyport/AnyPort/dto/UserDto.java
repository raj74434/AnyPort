package com.anyport.AnyPort.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserDto {



    private String name;
    private String phone;
    private String gender;

    @Override
    public String toString() {
        return "UserDto{" +

                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
