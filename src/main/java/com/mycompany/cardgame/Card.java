/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardgame;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
    protected enum cardRanks {Ace(0), Two(1), Three(2), Four(3), Five(4), Six(5), Seven(6), Eight(7), Nine(8), Ten(9), Jack(10), Queen(11), King(12);
    private int value;
    private cardRanks(int value) {
        this.value = value;}
    }
    
    protected enum cardSuits {Spades(0), Hearts(1), Diamonds(2), Clubs(3);
    private int value;
    private cardSuits(int value){
        this.value = value;
    }}
    
    private BufferedImage cardImage;
    private JLabel cardJLabel;
    
    cardRanks rank;
    cardSuits suit;
    
    public Card(){
    }
    
    public Card(cardSuits suit, cardRanks rank){
        this.rank = rank;
        this.suit = suit;
    }
    
    
    public cardRanks getRank(){
        return this.rank;
    }
    
    public cardSuits getSuit(){
        return this.suit;
    }
    
    public int getSuitValue(){
        return this.suit.value;
    }
    
    public int getRankValue(){
        return this.rank.value;
    }
    
    public void setCardJLabel(BufferedImage cardImage){
        this.cardJLabel = new JLabel(new ImageIcon(cardImage));
        this.cardImage = cardImage;
    }
    
    public JLabel getCardJLabel(){
        return this.cardJLabel;
    }
    
    public Boolean getCardByName(cardRanks rank, cardSuits suit){
        return this.rank == rank && this.suit == suit;
    }
    
    public void setCardImage(BufferedImage cardImage){
        this.cardImage = cardImage;
    }
    
    public BufferedImage getCardImage(){
        return this.cardImage;
    }
    
    @Override
    public String toString(){
        return this.rank.toString() + " of " + this.suit.toString();
    }
}
