import com.fakestore.TestCases.pojo.LoginPojo;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Login {

    @Test
    public void login() {
        LoginPojo body = new LoginPojo("mor_2314","83r5^_");


        given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post("/auth/login")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }
}