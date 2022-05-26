package com.mycompany.quatro.slack;

import org.json.JSONObject;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();
        Slack.sendMessage(json);
    }
}

