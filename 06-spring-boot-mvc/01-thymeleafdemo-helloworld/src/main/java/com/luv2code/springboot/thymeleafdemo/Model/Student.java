package com.luv2code.springboot.thymeleafdemo.Model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;

    private List<String> favoriteSystem;

    public Student(){

    }

    public String getCountry() {
        return country;
    }

    public List<String> getFavoriteSystem() {
        return favoriteSystem;
    }

    public void setFavoriteSystem(List<String> favoriteSystem) {
        this.favoriteSystem = favoriteSystem;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
