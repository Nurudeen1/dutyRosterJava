package com.dutyroster;

import io.github.cdimascio.dotenv.Dotenv;

class MyCredential {

    public String getFrom() {
        return System.getenv("FROM");
    }

    public String getPassword() {
        return System.getenv("PASSWORD");
    }
}
