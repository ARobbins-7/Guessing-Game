// Andrew Robbins
// CS 145
// Lab 1


import java.util.*;

// Plays a game with the user, where the system chooses a number between 
// 1 and 100 and the user guesses until they find the correct number, 
// then can play again or report statistics
public class Guess {
   
   public static final int RANGE = 100;
   
// Main method, calls methods in order to create the game
   public static void main(String[] args) {
      int x = 2;
      printIntro();
      System.out.println();
      System.out.println("Im thinking of a number between 1 and " + RANGE + "...");    
      int games = 0;
      int best = 9999;
      int timess = 0;
      
      while(x == 2) {
         Random rand = new Random();
         int awn = rand.nextInt(RANGE) + 1;
         int times = 0;
         int done = 1;
         while (done == 1) {
            timess += 1;
            times += 1;
            done = playGame(done, awn);
            System.out.println();
         }   
         games += 1;
         if(times < best) {
            best = times;
         }
         x = reportStats(times, timess, x, games, best);
     } 

   }
   
   //Reports the game statistics to the user after they are finished playing
   public static int reportStats(int times, int timess, int x, int games, int best) {
     if(times == 1) { 
       System.out.println("You got it right in " + times + " guess");
     } else {
        System.out.println("You got it right in " + times + " guesses");
     }
     System.out.print("Do you want to play again? ");
     Scanner in = new Scanner(System.in);
     String input = in.next();
     input = input.substring(0, 1);
     
     if(input.equals("y") || (input.equals("Y"))) {
        return 2;
     } else if(input.equals("n") || (input.equals("N"))) {
        double avg = timess / games;
        System.out.println();
        System.out.println("Overall results: ");
        System.out.println("    total games   = " + games);
        System.out.println("    total guesses = " + timess);
        System.out.println("    guesses/game  = " + avg);
        System.out.println("    best game     = " + best);
        return 1;
        
     } else {
         System.out.println("");
         System.out.println("Please input yes or no");
         System.out.println("");
         reportStats(times, timess, x, games, best);
         return 2;
     }
  }
   
   //plays one game from when the computer picks a number to when the user makes a guess
   public static int playGame(int done, int awn) {
      System.out.println();
      System.out.print("Your guess? ");
      Scanner console = new Scanner(System.in);
      
      if(console.hasNextInt()) {
         int num = console.nextInt();
         System.out.println();
         if (num > awn) {
            System.out.println("It's lower.");
            System.out.println();
            return done;
         } else if (num < awn) {
            System.out.println("It's higher");
            System.out.println();
            return done;
         } else {
            return 2;
         } 
      } else {
         System.out.println("");
         System.out.println("Please input an integer");
         System.out.println("");
         return 1;
      }
   }
   
   //prints the introduction sequence
   public static void printIntro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.print(RANGE);
      System.out.println(" and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println("");
   }
   
}