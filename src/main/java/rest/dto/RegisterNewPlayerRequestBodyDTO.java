package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.NewPlayer;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterNewPlayerRequestBodyDTO {


    private String username;
    private String password_change;
    private String password_repeat;
    private String email;
    private String name;
    private String surname;
    //    private String currency_code;

    public RegisterNewPlayerRequestBodyDTO(NewPlayer newPlayer) {
        this.username = newPlayer.getUsername();
        this.password_change = newPlayer.getPasswordChange();
        this.password_repeat = newPlayer.getPasswordRepeat();
        this.email = newPlayer.getEmail();
        this.name = newPlayer.getName();
        this.surname = newPlayer.getSurname();
    }

    public String getUsername() {
        return username;
    }

    public RegisterNewPlayerRequestBodyDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword_change() {
        return password_change;
    }

    public RegisterNewPlayerRequestBodyDTO setPassword_change(String password_change) {
        this.password_change = password_change;
        return this;
    }

    public String getPassword_repeat() {
        return password_repeat;
    }

    public RegisterNewPlayerRequestBodyDTO setPassword_repeat(String password_repeat) {
        this.password_repeat = password_repeat;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterNewPlayerRequestBodyDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterNewPlayerRequestBodyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public RegisterNewPlayerRequestBodyDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }


}
