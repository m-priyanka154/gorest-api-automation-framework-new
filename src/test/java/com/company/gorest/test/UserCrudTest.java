package com.company.gorest.test;
import com.company.gorest.base.BaseTest;
import com.company.gorest.client.UserApiClient;
import com.company.gorest.models.User;
import com.company.gorest.utils.TestDataUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class UserCrudTest extends BaseTest{
        UserApiClient apiClient = new UserApiClient();
        User user;
        int userId;

        @Test(priority = 1)
        public void createUserTest() {
            user = TestDataUtil.createUser();
            Response response = apiClient.createUser(user);

            response.then().statusCode(201);
            userId = response.jsonPath().getInt("id");

            assertNotNull(userId);
        }

        @Test(priority = 2)
        public void getUserTest() {
            Response response = apiClient.getUser(userId);

            response.then().statusCode(200);
            assertEquals(response.jsonPath().getString("email"), user.getEmail());
        }

        @Test(priority = 3)
        public void updateUserTest() {
            user.setStatus("inactive");

            Response response = apiClient.updateUser(userId, user);
            response.then().statusCode(200);

            assertEquals(response.jsonPath().getString("status"), "inactive");
        }

        @Test(priority = 4)
        public void deleteUserTest() {
            Response response = apiClient.deleteUser(userId);
            response.then().statusCode(204);
        }

        @Test(priority = 5)
        public void verifyUserDeleted() {
            Response response = apiClient.getUser(userId);
            response.then().statusCode(404);
        }

        }



