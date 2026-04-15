package com.example.service

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class ItemResourceTest {

    @Test
    fun `list items returns 200`() {
        given()
            .`when`().get("/items")
            .then()
            .statusCode(200)
    }

    @Test
    fun `create item returns 201`() {
        given()
            .contentType("application/json")
            .body("""{"name":"test","description":"a test item"}""")
            .`when`().post("/items")
            .then()
            .statusCode(201)
    }
}
