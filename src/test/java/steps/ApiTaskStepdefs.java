package steps;

import cache.TestCache;
import io.cucumber.java.en.When;
import model.NewPlayer;
import org.assertj.core.api.Assertions;
import rest.ApiTaskRestClient;
import rest.dto.GetSingleProfileResponseBodyDTO;
import rest.dto.RegisterNewPlayerResponseBodyDTO;

public class ApiTaskStepdefs {
    ApiTaskRestClient apiTaskRestClient = new ApiTaskRestClient();


    @When("User send Get guest token request and see {int} code in response")
    public void userSendGetGuestTokenRequestAndSeeCodeInResponse(int statusCode) {
        String accessToken = apiTaskRestClient.sendGetGuestTokenRequest(statusCode);
        TestCache.putInTestCacheMap("token", accessToken);
        System.out.println("Access token : " + accessToken);
    }

    @When("User send register a new player request and see {int} code and a new player in response")
    public void userSendRegisterANewPlayerRequestAndSeeCodeInResponse(int statusCode) {
        String accessToken;
        if (tryToGetFromTestCacheMap("token")) {
            accessToken = (String) TestCache.getFromTestCacheMap("token");
        } else {
            accessToken = apiTaskRestClient.sendGetGuestTokenRequest(statusCode);
        }

        NewPlayer newPlayer = new NewPlayer();
        System.out.println(newPlayer);
        RegisterNewPlayerResponseBodyDTO registerNewPlayerResponseBody = apiTaskRestClient.sendRegisterNewPlayerRequest
                (newPlayer, accessToken, statusCode);

        TestCache.putInTestCacheMap("infoAboutRegisteredUser", newPlayer);
        TestCache.putInTestCacheMap("registeredUser", registerNewPlayerResponseBody);
        TestCache.putInTestCacheMap("playerId", registerNewPlayerResponseBody.getId());

        Assertions.assertThat(registerNewPlayerResponseBody.getUsername()).isEqualTo(newPlayer.getUsername());
        Assertions.assertThat(registerNewPlayerResponseBody.getEmail()).isEqualTo(newPlayer.getEmail());
        Assertions.assertThat(registerNewPlayerResponseBody.getName()).isEqualTo(newPlayer.getName());
        Assertions.assertThat(registerNewPlayerResponseBody.getSurname()).isEqualTo(newPlayer.getSurname());
    }

    @When("User send Authorization under a player request and see {int} for authorization code in response")
    public void userSendAuthorizationUnderAPlayerRequestAndSeeCodeInResponse(int statusCodeForAuthorization) {
        String accessToken = (String) TestCache.getFromTestCacheMap("token");

        String bearerToken = apiTaskRestClient.sendAuthorizationUnderPlayerRequest(accessToken, statusCodeForAuthorization);
        TestCache.putInTestCacheMap("tokenOfAuthorizedPlayer", bearerToken);
    }

    @When("User send Get existing player's profile request and see existing player's information")
    public void userSendGetExistingPlayerSProfileRequest() {

        String expectedId = (String) TestCache.getFromTestCacheMap("playerId");
        String bearerToken = (String) TestCache.getFromTestCacheMap("tokenOfAuthorizedPlayer");

        GetSingleProfileResponseBodyDTO singleProfileResponseBody =
                apiTaskRestClient.sendGetSinglePlayerProfileRequest(bearerToken, expectedId, 200);

        NewPlayer player = (NewPlayer) TestCache.getFromTestCacheMap("infoAboutRegisteredUser");
        String expectedUsername = player.getUsername();
        String expectedName = player.getName();
        String expectedSurname = player.getSurname();

        String actualId = singleProfileResponseBody.getId();
        String actualUsername = singleProfileResponseBody.getUsername();
        String actualName = singleProfileResponseBody.getName();
        String actualSurname = singleProfileResponseBody.getSurname();

        Assertions.assertThat(actualId).isEqualTo(expectedId);
        Assertions.assertThat(actualUsername).isEqualTo(expectedUsername);
        Assertions.assertThat(actualName).isEqualTo(expectedName);
        Assertions.assertThat(actualSurname).isEqualTo(expectedSurname);
    }

    @When("User send Get not existing player's profile request and see {int} code response")
    public void userSendGetNotExistingPlayerSProfileRequestAndSeeCodeResponse(int statusCode) {
        String bearerToken = (String) TestCache.getFromTestCacheMap("tokenOfAuthorizedPlayer");

        GetSingleProfileResponseBodyDTO singleProfileResponseBody =
                apiTaskRestClient.sendGetSinglePlayerProfileRequest(bearerToken, "1", statusCode);
    }

    private boolean tryToGetFromTestCacheMap(String key) {
        try {
            TestCache.getFromTestCacheMap(key);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
