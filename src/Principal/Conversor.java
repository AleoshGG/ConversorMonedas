package Principal;

import Modelos.Moneda;
import Modelos.MonedasAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private Moneda divisa;
    private String dvs1;
    private String dvs2;

    public Conversor(String dvs1, String dvs2) {
        this.dvs1 = dvs1;
        this.dvs2 = dvs2;
    }

    public void obtenerValorMoneda() throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/b06a145886313d8ed9f77035/pair/" + this.dvs1 + "/" + this.dvs2;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().create();

        MonedasAPI monedasAPI = gson.fromJson(json, MonedasAPI.class);
        divisa = new Moneda(monedasAPI);
    }

    public double convertirCantidad(double cantidad) {
        return cantidad * divisa.getValorDivisa();
    }
}
