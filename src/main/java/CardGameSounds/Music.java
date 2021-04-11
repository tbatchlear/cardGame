/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGameSounds;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author skidw
 */
public class Music {
    
        public static synchronized void play(final String fileName)
    {
        File file = new File(fileName);
        // Note: use .wav files             
        new Thread(new Runnable() { 
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    clip.open(inputStream);
                    clip.start(); 
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
                }
            }
        }).start();
    }
}
