import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {
    private final String API_KEY;

    public ConsultaCotacao(String apiKey) {
        this.API_KEY = apiKey;
    }

    public CotacaoV6Exchangerate obterTaxaDeCambio(String moedaDe, String moedaPara) {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/" + moedaDe + "/" + moedaPara) ;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            return new Gson().fromJson(response.body(), CotacaoV6Exchangerate.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter a taxa de câmbio.");
        }
    }
}
