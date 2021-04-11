/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgameUI;

import CardGameSounds.Music;
import com.mycompany.cardgame.Card;
import com.mycompany.cardgame.CardDeck;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardGameUI {

    private final JFrame window;
    public CardDeck newDeck;
    public JPanel cardPanel;
    GridLayout fullDeck;
    GridBagLayout mainLayout;
    GridBagConstraints constraints;
    JButton shuffleButton;
    
    public CardGameUI(BufferedImage deck){
        window = new JFrame();
        
        window.setTitle("Card Game");
        window.setResizable(true);
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullDeck = new GridLayout(4,13);
        mainLayout = new GridBagLayout();
        constraints = new GridBagConstraints();
        cardPanel = new JPanel();
        cardPanel.setLayout(fullDeck);
        cardPanel.setPreferredSize(new Dimension(1000, 500));
        
        newDeck = new CardDeck(deck);
        
        window.setLayout(mainLayout);
        
        for (Card card : newDeck.CARDDECK){
            int tempH = card.getCardImage().getHeight()/2;
            int tempW = card.getCardImage().getWidth()/2;
            Image tempImage = imageResizer.resizeImage(card.getCardImage(), tempW, tempH);
            JLabel tempLabel = new JLabel(new ImageIcon(tempImage));
            cardPanel.add(tempLabel);
        }
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        window.add(cardPanel, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> {
            newDeck.shuffleDeck();
            Music.play("src/main/resources/Shuffling.wav");
            cardPanel.removeAll();
            for (Card card : newDeck.CARDDECK){
                JLabel tempLabel = card.getCardJLabel();
                tempLabel.setPreferredSize(new Dimension(71, 96));
                cardPanel.add(tempLabel);
            }
            refreshLayout();
        });
        window.add(shuffleButton, constraints);
    }
    
    public Container getContentPane(){
        return this.window.getContentPane();
    }
    
    public void add(Component comp){
        this.window.add(comp);
    }
    
    public void add(Component comp, Object cons){
        this.window.add(comp, cons);
    }
    
    public void setLayout(LayoutManager manager){
        this.window.setLayout(manager);
    }
    
    
    public void refreshLayout(){
        this.window.pack();
        this.window.setSize(1200, 800);
        this.window.setVisible(true);
    }
    
}
