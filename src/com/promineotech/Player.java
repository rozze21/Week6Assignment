package com.promineotech;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the game.
 */
public class Player {
 
  
  List<Card> hand = new ArrayList<Card>();  // List of card for the hand
  
   
   int score;           // score 
   String name;                //name
   
    
   public Player(String names) { 
    this.name = names;
    this.score = 0;   
  }
  

 
  public String toString() {
   return name;
  }
//print out information about the player and calls the describe method for each card in the Hand List)
  public void describe() {   
    System.out.println("Player: "  + name + " "+ score + " points!\n");
    for(Card card : hand) {
      card.describe();
    }
    System.out.println("**********************************");
    }
 

  
  public Card flipTopCard() {    // flip method 
    Card cardOnTop = hand.get(0);
    hand.remove(0);
    return cardOnTop;
}
 
  public void draw (Deck deck) {   // draw method 
    Card card = deck.draw();
    hand.add(card);
}
  
  

public void incrementScore(){   //incrementScore method  adds 1 to the player's score
    this.score += 1;
}
public int getScore() {
  return score;
}

}