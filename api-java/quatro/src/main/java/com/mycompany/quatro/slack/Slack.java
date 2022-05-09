package com.mycompany.quatro.slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class Slack {
     private static final HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";
    
    public static void sendMessage(JSONObject content)throws IOException, InterruptedException{
         HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         
          System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
