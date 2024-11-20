package org.example.header;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredPostSingleHeaderMethod {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
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
