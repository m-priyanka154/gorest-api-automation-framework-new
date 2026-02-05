package com.company.gorest.base;
import com.company.gorest.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseTest {
        @BeforeClass
        public void setup() {

            RestAssured.baseURI = ConfigReader.get("base.url");

            RestAssured.requestSpecification =
                    new RequestSpecBuilder()
                            .addHeader(
                                    "Authorization",
                                    "Bearer " + ConfigReader.get("auth.token")
                            )
                            .setContentType(ContentType.JSON)
                            .build();
        }
    }

