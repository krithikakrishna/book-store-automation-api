package api;

import com.github.javafaker.Faker;
import constants.EndPoints;
import data.BookStoreData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class UserApi {

    static Faker faker = new Faker();

    // Generate random email using faker
    public static String generateFakeEmail() {
        return faker.internet().emailAddress();
    }

    // Generate random password using faker
    public static String generateFakePassword() {
        return faker.internet().password(8, 16, true, true, true);
    }

    public static Response signUp(String email, String password, BookStoreData bookStoreData) {
        return given().contentType(ContentType.JSON)
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .log().all()
                .when().post(EndPoints.SING_UP)
                .then().log().all().extract().response();
    }

    public static Response login(String email, String password) {
        RequestSpecification request = given().contentType(ContentType.JSON).log().all();
        if (email != null && password != null) {
            request.body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}");
        }
        return request.when().post(EndPoints.LOG_IN)
                .then().log().all().extract().response();
    }
}
