package com.company.gorest.client;
import com.company.gorest.models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class UserApiClient {

        public Response createUser(User user) {
            return given()
                    .body(user)
                    .post("/public/v2/users");
        }

        public Response getUser(int userId) {
            return given()
                    .get("/public/v2/users/" + userId);
        }

        public Response updateUser(int userId, User user) {
            return given()
                    .body(user)
                    .put("/public/v2/users/" + userId);
        }

        public Response deleteUser(int userId) {
            return given()
                    .delete("/public/v2/users/" + userId);
        }
    }

