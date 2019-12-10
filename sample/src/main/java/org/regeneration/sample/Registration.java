package org.regeneration.sample;

import org.regeneration.sample.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Registration {

    //all of the variables brought from the registration json

    public String username;
    public String password;

    public String first_name;
    public String last_name;
    public String phone_num;
    public String email;
    public int amka;

    public Registration(String username, String password, String first_name, String last_name, String phone_num, String email, int amka) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_num = phone_num;
        this.email = email;
        this.amka = amka;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }




}
