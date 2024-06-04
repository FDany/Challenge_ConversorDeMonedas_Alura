package models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    public double consulta(String mOrigen, String mFinal){

        URI direccion = URI.create( "https://v6.exchangerate-api.com/v6/6c311c9fae0b7e46aca5cd18/latest/"+mFinal );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{

            HttpResponse<String> response = client
                    .send( request, HttpResponse.BodyHandlers.ofString() );

            return new Gson().fromJson(response.body(), Monedas.class).conversion_rates().get(mOrigen);

        }catch (Exception e){
            throw new RuntimeException("Error inesperado.");
        }
    }
}
