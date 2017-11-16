/* Good Work
 * Score 18.5
 * you are not printing previously guessed letters
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
	
	public static String targetWord; // access should be private
	private Character guessWord;
	private String[] line;
	public static String correctWord;
	public static String puzzleWord;
	public static int count=8;

		ArrayList<String> words;
		
		String chooseWord(){
			int n=new Random().nextInt(words.size());
			targetWord=this.words.get(n);
			System.out.println(targetWord);
			return targetWord;
		}
		
		void handleGuess(){	
			
			while(count!=0 && !puzzleWord.equals(targetWord)){
			 System.out.print("Your guess: ");
             Scanner s= new Scanner(System.in);
			 guessWord = s.next().charAt(0);	
			 correctWord=puzzleWord;
			 if(isCorrect()){
				this.update(guessWord);
				System.out.println("You're right!");
				
			 }else{
				 count--;
				 System.out.println("You're wrong!");
			}
			this.printHangman(count);
			System.out.println("The word now looks like this: "+correctWord);
			System.out.println("You have "+count +" guesses left.");	   	  
		}
	  }
		
		
		boolean isCorrect(){
			for(int i=0;i<targetWord.length();i++){
					if(guessWord==targetWord.charAt(i)){
						return true;
					}
			}
					return false;
		}
		
		void update(char c){
			
			puzzleWord="";
			for(int i=0;i<targetWord.length();i++){
				  if(guessWord==targetWord.charAt(i)){
					puzzleWord=puzzleWord+guessWord;	
				}else{
					puzzleWord=puzzleWord+correctWord.charAt(i);		
				  }
			    }
			correctWord=puzzleWord;
			return;
		}
		
		boolean gameWon(){
			if(count==0){
				System.out.println("Sorry! You lost the game!");
				return false;
			}
			System.out.println("Congratulations!! You win the game!");
			return true;
		}
		void gameOver(){
			
		}
	
		void printHangman(int count){
			switch(count){
			case 8:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|              ";
				System.out.println(line[2]);
				line[3]="|              ";
				System.out.println(line[3]);
				line[4]="|              ";
				System.out.println(line[4]);
				line[5]="|              ";
				System.out.println(line[5]);
				line[6]="|              ";
				System.out.println(line[6]);
				line[7]="|              ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
				
			case 7:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|              ";
				System.out.println(line[3]);
				line[4]="|              ";
				System.out.println(line[4]);
				line[5]="|              ";
				System.out.println(line[5]);
				line[6]="|              ";
				System.out.println(line[6]);
				line[7]="|              ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 6:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|              ";
				System.out.println(line[4]);
				line[5]="|              ";
				System.out.println(line[5]);
				line[6]="|              ";
				System.out.println(line[6]);
				line[7]="|              ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 5:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- ";
				System.out.println(line[4]);
				line[5]="|              ";
				System.out.println(line[5]);
				line[6]="|              ";
				System.out.println(line[6]);
				line[7]="|              ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 4:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- --- ";
				System.out.println(line[4]);
				line[5]="|              ";
				System.out.println(line[5]);
				line[6]="|              ";
				System.out.println(line[6]);
				line[7]="|              ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 3:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- --- ";
				System.out.println(line[4]);
				line[5]="|           /   ";
				System.out.println(line[5]);
				line[6]="|         /     ";
				System.out.println(line[6]);
				line[7]="|               ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 2:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- --- ";
				System.out.println(line[4]);
				line[5]="|            / \\";
				System.out.println(line[5]);
				line[6]="|          /     \\ ";
				System.out.println(line[6]);
				line[7]="|                ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 1:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- --- ";
				System.out.println(line[4]);
				line[5]="|            / \\";
				System.out.println(line[5]);
				line[6]="|          /     \\ ";
				System.out.println(line[6]);
				line[7]="|        --       ";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
			case 0:
				line[0]=" --------------";
				System.out.println(line[0]);
				line[1]="|             |";
				System.out.println(line[1]);
				line[2]="|             0";
				System.out.println(line[2]);
				line[3]="|             |";
				System.out.println(line[3]);
				line[4]="|          --- --- ";
				System.out.println(line[4]);
				line[5]="|            / \\";
				System.out.println(line[5]);
				line[6]="|          /     \\ ";
				System.out.println(line[6]);
				line[7]="|       --        --";
				System.out.println(line[7]);
				line[8]="|              ";
				System.out.println(line[8]);
				line[9]=" --------------------------";
				System.out.println(line[9]);
				break;
				
			}
		}
		
		void playGame(){
			System.out.println("Welcom to Hangman!");
		    
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<targetWord.length();i++){
				sb.append('-');	
			}
			puzzleWord=sb.toString();
		    System.out.println("The word now looks like this: "+puzzleWord);
		   System.out.println("You have "+count +" guesses left.");
		   
		}
		
			
		public HangMan(ArrayList<String> words){
			this.words=new ArrayList<String>();
			this.words=words;
			
			this.chooseWord();
			line=new String[10];
			line[0]=" --------------";
			System.out.println(line[0]);
			line[1]="|             |";
			System.out.println(line[1]);
			line[2]="|              ";
			System.out.println(line[2]);
			line[3]="|              ";
			System.out.println(line[3]);
			line[4]="|              ";
			System.out.println(line[4]);
			line[5]="|              ";
			System.out.println(line[5]);
			line[6]="|              ";
			System.out.println(line[6]);
			line[7]="|              ";
			System.out.println(line[7]);
			line[8]="|              ";
			System.out.println(line[8]);
			line[9]=" --------------------------";
			System.out.println(line[9]);
	}
	
}

