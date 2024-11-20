package org.example.header;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredPostHeadersClass {
    public static void main(String[] args) {
        Headers requestHeaders = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("Accept", "application/json"),
                new Header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36"),
                new Header("referer", "https://jsonplaceholder.typicode.com")
        );

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .headers(requestHeaders)
                .body("{\n" +
                        "    \"title\": \"TITLE_ADDED\",\n" +
                        "    \"body\": \"BODY_ADDED\",\n" +
                        "    \"userId\": 700\n" +
                        "}")
                .when()
                .post("/posts")
                .then()
                .statusCode(202)
                .body("id", notNullValue())
                .body("title", equalTo("TITLE_ADDED"))
                .body("body", equalTo("BODY_ADDED"))
                .body("userId", equalTo(700));
        System.out.println("TEST PASSED!");
    }
}
