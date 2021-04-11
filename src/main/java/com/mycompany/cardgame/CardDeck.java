/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardgame;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author skidw
 */
public class CardDeck {
    public final Card[] CARDDECK = new Card[52];
    int i = 0;
    BufferedImage spriteSheet;
    
    public CardDeck(BufferedImage deck){
        
        this.spriteSheet = deck;
        createDeck();
        
    }
    
    private void createDeck(){
        for (Card.cardSuits suit : Card.cardSuits.values()){
            for (Card.cardRanks rank : Card.cardRanks.values()){
                CARDDECK[i] = new Card(suit, rank);
                i++;
            }
        }
        
        //try {
            for (Card card : CARDDECK){
            card.setCardJLabel(spriteSheet.getSubimage(71*card.getRankValue(), 96*card.getSuitValue(), 71, 96));
            } 
        //} catch (NullPointerException e){
                
           // }
    }
    
    public void shuffleDeck(){
        for (int i = 0; i < 52; i++){
            Card temp = CARDDECK[i];
            int rand = (int)(Math.random()*52);
            CARDDECK[i] = CARDDECK[rand];
            CARDDECK[rand] = temp;
        }
    }
}
