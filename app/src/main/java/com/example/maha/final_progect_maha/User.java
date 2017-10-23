package com.example.maha.final_progect_maha;

import java.io.Serializable;

/**
 * Created by Maha on 22/10/2017.
 */

public class User implements Serializable {


    String name,email,BirthDate;
    int password;

    public User(String name, String email, String birthDate, int password) {
        this.name = name;
        this.email = email;
        BirthDate = birthDate;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public int getPassword() {
        return password;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public void setPassword(int password) {
        this.password = password;
    }







}
