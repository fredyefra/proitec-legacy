package br.com.proitec.legacy;
import br.com.proitec.legacy.model.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientResourceTest {

Cliente clienteStub= new Cliente(
        10L,
        "Tião",
        "Rua das flores",
        "99-9999999",
        "tiao@tiao.com.br");

@Test
    public void deveTestarGetAll(){
        given().
                when().
                get("/pages/consultar-clientes").
                then().
                statusCode(200);
    }
    @Test
    public void deveTestarInsert(){

        given().
             //   body(clienteStub).
                when().
                post("/pages/cadastrar-cliente").
                then().
                statusCode(302);
    }



}
