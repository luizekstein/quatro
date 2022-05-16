
package com.mycompany.quatro.slack;

import java.io.IOException;
import org.json.JSONObject;


public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        JSONObject json = new JSONObject();
        
        json.put("text", "Boa tarde Kauã, como posso te ajudar? :shrug:");
        
        Slack.sendMessage(json);
    }
}
