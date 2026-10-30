import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
  
   // board ko matrix ke form me set karna hai  
static  String[] board;
// static block class load hote hi ek baar chal jata hia 

static  String turn ;

// method too check winner 

static  String checkWinner(){
    

    for(int a = 0 ; a< 8 ; a++){
        String line = null;  // har loop me naya line banao, abhi khaali
  // 8 wiineg combination
        switch(a){
            case 0 : line = board[0] + board[1] + board[2]; break;  // row 1 
            case 1 : line = board[3] + board[4] + board[5] ; break; // row 2
            case 2 : line = board[6] + board[7] + board[8] ; break; // row 3
            case 3 : line = board[0] + board[3] + board[6] ; break; // col 1
            case 4 : line = board[1] +  board[4] + board[7]; break; // Col 2
            case 5: line = board[2] + board[5] + board[8]; break; // Col 3
            case 6: line = board[0] + board[4] + board[8]; break; // Diagonal 1
            case 7: line = board[2] + board[4] + board[6]; break; // Diagonal 2
        }

        // agar line xxx ya ooo ho gai to aap jit gaye 
        if(line.equals("xxx")){
             return "x";
        }else if(line.equals("ooo")){
            return "o";
        }
    }

  // Draw check: Agar board me 1 se 9 tak koi bhi number bacha hai, toh game abhi khatam nahi hua

  for(int a = 0 ; a < 9 ; a++){
    if(Arrays.asList(board).contains(String.valueOf(a+1))){
        break;
    }else if (a == 8){
        return " draw";
    }
  }
  System.out.println(turn + " S turn ;  enter a slot number to place " + turn + " in;");
  return null;   // abhi koi wiiner nahi hia 

}



static  void  printBoard(){
    System.out.println("|---|---|---|");
    System.out.println("| " + board[0] + " | "+ board[1] + " | " + board[2] + " |");

    System.out.println("|----------|");
    System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");

    System.out.println("|----------|");
    System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
  
   System.out.println("|---|---|---|");

}

public static void main(String[] args) {
   
 Scanner sc = new Scanner(System.in);   
board = new String[9];

turn = "x";   // game hamesha x se start hoga 
String winner = null;  // abhi koi winner nahi hai 

// Board ko initialize karo numbers 1 se 9 tak (String format me)
for(int a = 0 ; a < 9 ; a++){
board[a] = String.valueOf(a+1);
}

System.out.println("welcome to the TicTacToe  game");
printBoard();
System.out.println("X will start  first...");
  

// game loop : jab tak winner = null hia koi nahi jita 
while( winner == null){
    int numInput ;

    try{
        numInput = sc.nextInt();  // take an input

        // edge conition 
        // // Check 1: Kya input 1 se 9 ke beech hai?
        if(!(numInput > 0 && numInput <= 9)){
            System.out.println("invalid input");
            continue ;
        }

        // check 2 kya oo slot pahle se bhara hua hai
        // Agar board[slot] me abhi bhi number hai (matlab X ya O nahi aaya), toh wo khali hai
        
        if(board[numInput -1].equals(String.valueOf(numInput))){
            board[numInput -1] = turn;

            // turn toggle karo ( x se  0 & o se x )
            turn  = turn.equals("x") ? "o" : "x";

            // print board update karo
            printBoard();
            winner = checkWinner();  // check karo winner koi jeeta kya

         }else{
            System.out.println("slot already taken ; reenter slot number");
         }
    }catch(InputMismatchException e){
       // Agar user ne number ki jagah koi letter type kar diya
        System.out.println("Invalid input; re-enter slot number:");
                sc.nextLine(); // Galti wala input clear karo taaki infinite loop na bane

    }
}

        // Loop khatam hone ke baad final result
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }

        sc.close(); // Scanner close karo
    }
}