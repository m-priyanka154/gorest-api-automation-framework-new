package com.company.gorest.utils;
import com.company.gorest.models.User;
public class TestDataUtil {
        public static User createUser() {
            User user = new User();
            user.setName("API Automation User");
            user.setEmail("user" + System.currentTimeMillis() + "@mail.com");
            user.setGender("female");
            user.setStatus("active");
            return user;
        }
    }


