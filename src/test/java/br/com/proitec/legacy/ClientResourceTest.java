package br.com.proitec.legacy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientResourceTest {
@Test
    public void deveTestarGet(){
        given().
                when().
                get("/pages/consultar-clientes").
                then().
                statusCode(200);
    }
}
