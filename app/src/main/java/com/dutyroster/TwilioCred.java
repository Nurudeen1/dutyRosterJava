package com.dutyroster;

import io.github.cdimascio.dotenv.Dotenv;

public class TwilioCred {

    public static String getAccountSid() {
        return System.getenv("ACCOUNT_SID");
    }

    public static String getAuthToken() {
        return System.getenv("AUTH_TOKEN");
    }
}