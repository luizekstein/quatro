
package com.mycompany.quatro.slack;

import java.io.IOException;
import org.json.JSONObject;



public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        
        JSONObject json = new JSONObject();
        json.put("text", "Alerta: Servidor moderadamente cheio");
        Slack.sendMessage(json);
    }
}
