package model;

import com.github.javafaker.Faker;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class NewPlayer {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password_change")
    private String passwordChange;

    @JsonProperty("password_repeat")
    private String passwordRepeat;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    public NewPlayer() {
        Faker faker = new Faker();
        username = faker.name().username().replace(".", "");
        passwordChange = faker.internet().password(9, 10) + "=";
        passwordRepeat = passwordChange;
//        passwordChange = "amFuZWRvZTEyMw==";
//        passwordRepeat = "amFuZWRvZTEyMw==";
        email = username + "@example.com";
        name = faker.name().firstName();
        surname = faker.name().lastName();
    }

    public String getUsername() {
        return username;
    }

    public NewPlayer setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswordChange() {
        return passwordChange;
    }

    public NewPlayer setPasswordChange(String passwordChange) {
        this.passwordChange = passwordChange;
        return this;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public NewPlayer setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public NewPlayer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public NewPlayer setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public NewPlayer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        return "NewPlayer{" +
                "username='" + username + '\'' +
                ", passwordChange='" + passwordChange + '\'' +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
