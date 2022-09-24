package rest;

import cache.TestCache;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.NewPlayer;
import rest.dto.*;
import utils.PropertyLoader;

import static io.restassured.RestAssured.given;
import static utils.Constants.*;

public class ApiTaskRestClient {

    public String sendGetGuestTokenRequest(int statusCode) {
        System.out.println("Status Code: " + statusCode);

        GuestTokenRequestBodyDTO guestTokenRequestBody = new GuestTokenRequestBodyDTO()
                .setGrant_type("client_credentials").setScope("guest:default");

        Response response = given(RequestSpecifications.basicSpec)
                .auth()
                .preemptive()
                .basic(PropertyLoader.getPropertyValue(PLAYER_PROPERTIES_FILEPATH, "auth_username"),
                        PropertyLoader.getPropertyValue(PLAYER_PROPERTIES_FILEPATH, "auth_password"))
                .body(guestTokenRequestBody)
                .when()
                .log().all()
                .post(AUTHORIZATION_ENDPOINT)
                .then()
                .log().all()
                .statusCode(statusCode)
                .and().extract().response();

        GuestTokenResponseBodyDTO guestTokenResponseBody = response.as(GuestTokenResponseBodyDTO.class);

        return guestTokenResponseBody.getAccess_token();
    }

    public RegisterNewPlayerResponseBodyDTO sendRegisterNewPlayerRequest(NewPlayer newPlayer,
                                                                         String bearerToken, int statusCode) {

        RegisterNewPlayerRequestBodyDTO registerNewPlayerRequestBody = new RegisterNewPlayerRequestBodyDTO(newPlayer);

        Response response = getValidatableResponseForRequestPlayer(bearerToken, registerNewPlayerRequestBody)
                .log().all()
                .statusCode(statusCode)
                .and().extract().response();

        return response.as(RegisterNewPlayerResponseBodyDTO.class);
    }


    public String sendAuthorizationUnderPlayerRequest(String bearerToken, int statusCode) {

        NewPlayer newPlayer = (NewPlayer) TestCache.getFromTestCacheMap("infoAboutRegisteredUser");
        RegisterNewPlayerResponseBodyDTO registerNewPlayerResponseBodyDTO = (RegisterNewPlayerResponseBodyDTO) TestCache.getFromTestCacheMap("registeredUser");
        AuthorizationUnderPlayerRequestBodyDTO authorizationUnderPlayerRequestBody =
                new AuthorizationUnderPlayerRequestBodyDTO(registerNewPlayerResponseBodyDTO, newPlayer.getPasswordChange());

        Response response = given(RequestSpecifications.basicSpec)
                .auth()
                .preemptive()
                .basic(PropertyLoader.getPropertyValue(PLAYER_PROPERTIES_FILEPATH, "auth_username"),
                        PropertyLoader.getPropertyValue(PLAYER_PROPERTIES_FILEPATH, "auth_password"))
                .body(authorizationUnderPlayerRequestBody)
                .log().all()
                .post(AUTHORIZATION_ENDPOINT)
                .then()
                .log().all()
                .statusCode(statusCode)
                .and().extract().response();

        return response.as(AuthorizationUnderPlayerResponseBodyDTO.class).getAccess_token();
    }


    public GetSingleProfileResponseBodyDTO sendGetSinglePlayerProfileRequest(String bearerToken, String playerId, int statusCodeOfResponse) {

        Response response = given(RequestSpecifications.basicSpec)
                .header("Authorization", "Bearer " + bearerToken)
                .log().all()
                .get(PLAYER_ENDPOINT + "/" + playerId)
                .then()
                .log().all()
                .statusCode(statusCodeOfResponse)
                .and().extract().response();
        return response.as(GetSingleProfileResponseBodyDTO.class);
    }

    private ValidatableResponse getValidatableResponseForRequestPlayer(String bearerToken, RegisterNewPlayerRequestBodyDTO registerNewPlayerRequestBody) {
        return given(RequestSpecifications.basicSpec)
                .header("Authorization", "Bearer " + bearerToken)
                .body(registerNewPlayerRequestBody)
                .log().all()
                .post(PLAYER_ENDPOINT)
                .then();
    }
}
