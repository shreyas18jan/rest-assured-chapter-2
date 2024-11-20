package org.example.body;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredPostFileBody {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
                .body(new File("src/main/resources/JsonHolderPostRequestBody.json"))
        .when()
                .post("/posts")
        .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("TITLE_ADDED"))
                .body("body", equalTo("BODY_ADDED"))
                .body("userId", equalTo(700));

        System.out.println("TEST PASSED!");
    }
}
