package controller2;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyConverterControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testConvertCurrency() {
        String from = "USD";
        String to = "EUR";
        double amount = 100;
        String url = "/api/convert?from=" + from + "&to=" + to + "&amount=" + amount;
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Aquí deberías ajustar el valor esperado según la tasa de conversión actual
        assertEquals(200.0, response.getBody(), 0.01); // Por ejemplo, puedes usar un valor esperado realista
    }
}
