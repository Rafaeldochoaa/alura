package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    @GetMapping("/convert")
    public double convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        String url = API_URL + from + "?apikey=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        if (response != null && response.getRates().containsKey(to)) {
            double rate = response.getRates().get(to);
            return amount * rate;
        }
        throw new RuntimeException("Unable to fetch exchange rate for " + to);
    }
}
