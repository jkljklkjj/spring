package com.example.demo.Tester;

import javax.sound.sampled.*;
import java.io.File;

public class AudioTest {
    public static void main(String[] args) {
        try {
            File audioFile = new File("path/to/your/audio/file");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            int sampleRate = (int) format.getSampleRate();
            int bitDepth = format.getSampleSizeInBits();
            System.out.println("Sample Rate: " + sampleRate + " Hz");
            System.out.println("Bit Depth: " + bitDepth + " bits");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}