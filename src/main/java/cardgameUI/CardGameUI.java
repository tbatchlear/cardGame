/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgameUI;

import com.mycompany.cardgame.Card;
import com.mycompany.cardgame.CardDeck;
import com.mycompany.cardgame.CardGame;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;


public class CardGameUI {

    private final JFrame window;
    public CardDeck newDeck;
    
    public CardGameUI(BufferedImage deck){
        window = new JFrame();
        
        window.setTitle("Card Game");
        window.setResizable(true);
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout fullDeck = new GridLayout(4,13);
        GridBagLayout mainLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(fullDeck);
        
        newDeck = new CardDeck(deck);
        
        window.setLayout(mainLayout);
        
        for (Card card : newDeck.CARDDECK){
            cardPanel.add(card.getCardImage());
        }
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        window.add(cardPanel, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> {
            newDeck.shuffleDeck();
            cardPanel.removeAll();
            for (Card card : newDeck.CARDDECK){
                cardPanel.add(card.getCardImage());
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
    
//    public void actionPerformed(ActionEvent e) {
//        if ("reshuffle".equals(e.getActionCommand())) {
//            CardDeck.shuffleDeck();
//        } 
//    }
}
