package com.kamar.cloud_native_application.components.services;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * a service to manage cats.
 * @author kamar baraka.*/

@Service
public class CatService {

    public void getCat(String name) throws Exception {

        /*construct a http client to manage http requests*/
        HttpClient httpClient = HttpClient.newHttpClient();

        /*construct a uri*/
        URI uri = URI.create("http://localhost:8080/api/cat_get?name=%s".formatted(name));

        /*construct a http request*/
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().header("Content-Type", "application/json" ).
                header("Accept", "application/json").build();

        /*send the http request and store the response*/
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        /*print out the response*/
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void main(String[] args) throws Exception{

        CatService catService = new CatService();
        catService.getCat("evans");
    }
}
