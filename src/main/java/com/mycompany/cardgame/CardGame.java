/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardgame;

import CardGameSounds.Music;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import cardgameUI.CardGameUI;

public class CardGame {

    public static void main(String[] args) {
        
        BufferedImage bigImg = null;
        
        try {
            bigImg = ImageIO.read(new File("src/main/resources/cards_spritesheet.png"));
        } catch (IOException e) {
        }
        
        CardGameUI gameUI = new CardGameUI(bigImg);
        
        Music.play("src/main/resources/Music.wav");

        gameUI.refreshLayout();
    }
    
}
