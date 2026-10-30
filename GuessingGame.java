import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
     int SecrateNumber = 1 + (int)(100 * Math.random());
// (rand.nextInt(100) 0 se 99 deta hai, +1 karne se 1 se 100 ho gaya)

int  maxAttempt = 5;
boolean hasWon = false;
int  totalAttemptsCount = 0;


System.out.println("welcone to the guessing number game...");
System.out.println("maine ek se leke 100 ke bich me ek number socha  liye hai ....... now its your turn guess the number . But uske pahle listen you have only "+ maxAttempt+ " attempts to guess the number!");

while(!hasWon){
    // each round me 5 attempts honge 
    for(int i = 1 ; i <= maxAttempt; i++){
        System.out.println("your " + i + " " +"Attempt");
        int guess = sc.nextInt();
        // har guess pe counter badega 
        totalAttemptsCount++;

        if(guess == SecrateNumber){
            System.out.println("congratulation you won  you have taken  "+ totalAttemptsCount+ " attempts to guess the number ");
            hasWon = true;
            break;
        }
        else if(guess < SecrateNumber){
            System.out.println("number is greater than  " + guess);

        }else{
            System.out.println("number is smaller than  " + guess);
        }
    }

            // Agar 5 attempts khatam ho gaye aur nahi jeeta

    if(!hasWon){
        System.out.println(" you have finished your 5 attempts");
        System.out.println("you wana continue to play the game..!  Should i increate the attempts (Yes/No)");
     
        String choice = sc.next(); 
        
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("lets start the game again");
        }else{
            System.out.println("game over... your couurect number is " + SecrateNumber );
         break;
        }
    }


}
    
sc.close();

    }

}
