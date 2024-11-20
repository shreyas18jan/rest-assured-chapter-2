package org.example.queryparam;

import static io.restassured.RestAssured.given;

public class RestAssuredPostSingleQueryParamMethod {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/posts")
                .queryParams("userId", "1")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
        .when()
                .get()
        .then()
                .statusCode(200);

        System.out.println("TEST PASSED!");
    }
}
