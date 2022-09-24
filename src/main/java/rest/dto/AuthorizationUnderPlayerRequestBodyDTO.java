package rest.dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.NewPlayer;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorizationUnderPlayerRequestBodyDTO {

    @JsonProperty("grant_type")
    private String grant_type;
    private String username;
    private String password;

    public AuthorizationUnderPlayerRequestBodyDTO(RegisterNewPlayerResponseBodyDTO registerNewPlayerResponseBody, String password) {
        this.grant_type = "password";
        this.username = registerNewPlayerResponseBody.getUsername();
        this.password = password;
    }

    public AuthorizationUnderPlayerRequestBodyDTO(NewPlayer newPlayer, String password) {
        this.grant_type = "password";
        this.username = newPlayer.getUsername();
        this.password = password;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public AuthorizationUnderPlayerRequestBodyDTO setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthorizationUnderPlayerRequestBodyDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthorizationUnderPlayerRequestBodyDTO setPassword(String password) {
        this.password = password;
        return this;
    }

}
