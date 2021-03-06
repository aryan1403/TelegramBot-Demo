package com.example.configurations;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class cfg {
    public static Dotenv env = new DotenvBuilder().ignoreIfMissing().load();

    public static String botToken = env.get("botToken");
    public static String botUsername = env.get("botUsername");
    public static String handler = "/";
}
