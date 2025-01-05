import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CartTest {
    static RequestSpecification request;

    @BeforeClass
    public static void beforeClass() {
        request = given()
                .baseUri("https://fakestoreapi.com")
                .log().all();
    }

    @Test
    public void getAllCart() {
        given()
                .spec(request)
                .when()
                .get("/carts")
                .then().log().all().assertThat().statusCode(200)
                .body("[1].id", equalTo(2));
    }

    @Test
    public void getCartsInADateRange() {
        given()
                .spec(request)
                .when()
                .get("/carts?startdate=2019-12-10&enddate=2020-10-10")
                .then().log().all().assertThat().statusCode(200)
                .body("[0].id", equalTo(1));
    }

    @Test
    public void getUserCart() {
        given()
                .spec(request)
                .when()
                .get("/carts/user/2")
                .then().log().all().assertThat().statusCode(200)
                .body("[0].id", equalTo(3));
    }

    @Test
    public void postNewProduct() {
        String body = "{\n" +
                "    \"title\": \"test product\",\n" +
                "    \"price\": 13.5,\n" +
                "    \"description\": \"lorem ipsum set\",\n" +
                "    \"image\": \"https://i.pravatar.cc\",\n" +
                "    \"category\": \"electronic\"\n" +
                "}";

        given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/carts")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void putUpdateProduct() {
        String body = "{\n" +
                "    \"title\": \"test product\",\n" +
                "    \"price\": 13.5,\n" +
                "    \"description\": \"lorem ipsum set\",\n" +
                "    \"image\": \"https://i.pravatar.cc\",\n" +
                "    \"category\": \"electronic\"\n" +
                "}";

        given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/carts/7")
                .then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void deleteCart() {
        given()
                .spec(request)
                .when()
                .delete("/carts/6")
                .then().log().all().assertThat().statusCode(200);
    }
}
