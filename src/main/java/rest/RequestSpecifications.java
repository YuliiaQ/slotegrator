package rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
    private static final String baseUrl = "http://test-api.d6.dev.devcaz.com";
    public static RequestSpecification basicSpec =
            new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .setContentType(ContentType.JSON)
                    .build();
}
