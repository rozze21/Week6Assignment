package com.promineotech;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The application runner.
 */
public class App {
  
  
     
    public List<String> members = List.of("Carlos","Juan","Elba","Andre","Joseph","Steve",
      "Alex","Marisela","Michael","Screech","El Goblino","Eric");
 
    //   a. Instantiate a Deck and two Players, call the shuffle method on the deck. 
  Random random = new Random(); 
  public Player player1;
  public Player player2;
  public Deck deck;
  
  public static void main(String[] args) {
    new App().run();  
  }
    private void run() {    //created a run method to run execute the SelectPlayer 
      SelectPlayers();
      createAndShuffleDeck();  //and createAndShuffleDeck methods
    }     
     
    
      public void SelectPlayers() {
        List<String> names = new LinkedList<>(members);
        player1 = selectPlayer(names);
        player2 = selectPlayer(names);
        System.out.printf("%s is playing %s.%n\n", player1, player2);
      }   
    
        public Player selectPlayer(List<String> names) {
          int pos = random.nextInt(names.size());
          String name = names.remove(pos);
          return new Player(name);

      }
          
 /*
  *  b) Using a traditional for loop, iterate 52 times calling the Draw method on the other player
  *  each iteration using the Deck you instantiated.
  */
        private void createAndShuffleDeck() {
          deck = new Deck();
          deck.shuffle();
          
         for(int i = 1; i <= 26; i++){       //iterates 26 cards to each player's hand
             player1.hand.add(deck.draw()); 
             player2.hand.add(deck.draw());
         }    
         
         player1.describe();
         player2.describe();
        
         
         
 // c) Using a traditional for loop, iterate 26 times and call the flip method for each player.      
         
         for (int i = 0; i < 26; i++) {
           Card playerOneCard = player1.flipTopCard();  //flip and play first/next card for playerOne
           Card playerTwoCard = player2.flipTopCard();  //flip and play first/next card for playerTwo
             if (playerOneCard.getValue() > playerTwoCard.getValue()) {
                 player1.incrementScore();
             System.out.println("Player: " + player1 + " wins the round. "+  "\n");
             }else if (playerTwoCard.getValue() > playerOneCard.getValue()) {
                 player2.incrementScore();
              System.out.println("Player: "  + player2 + " wins the round. "+ "\n");
             }else {
               System.out.println("Draw!\n");
             }
             System.out.println("Current Score: " + player1 +" "+ player1.getScore()+" "+ player2 + " "+ player2.getScore()+  "\n");
             System.out.println("**********************************");

         }
         
         
 /*
  *  d) Compare the value of each card returned by the two player's flip method. Call the
  *         incrementScore method on the player whose card has the higher value.
  *  e) After the loop, compare the final score from each player.
  *  f) Print the final score of each player, and either "Player 1", "Player 2", or "Draw"
  *         depending on which score is higher or if they are both the same.  
  */

         if (player1.score > player2.score) {
               System.out.println(player1 + " is the Winner!!!");
               System.out.println("With a score of " + player1.score + " to " + player2.score);
             } else if (player2.score > player1.score) {
               System.out.println(player2 + " is the Winner!!!");
               System.out.println("With a score of " + player2.score + " to " + player1.score);
             } else  {  
               System.out.println("Draw!!");
             }    
  
  
   }
}
  