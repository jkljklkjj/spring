package com.example.demo.Speech;

import java.io.InputStream;

public class VoiceToText {
    public void loadLibrary() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("lib/Msc.jar");
    }
}
