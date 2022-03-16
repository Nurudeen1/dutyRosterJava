package com.dutyroster;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class App implements RequestHandler<Map<String,String>, Void> {



    @Override
    public Void handleRequest(Map<String,String> event, Context context) {
        Sms mm = new Sms();
        mm.sendMessage();
        return null;
    }
}


