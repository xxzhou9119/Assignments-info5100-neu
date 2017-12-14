/* Good Work
 * score 19
 * You are setting spades as shortest even though it contains king, queen or Ace. check requirements
 */
import java.util.Scanner;

public class GameDriver {
	 
	public static void main(String[] args){
		Game g=new Game(5);
		 g.playAGame();
		 g.printScore();
		 System.out.println("Play another game (y/n)?");
		 Scanner sc = new Scanner(System.in);
		 char c=sc.nextLine().charAt(0);
		 if(c=='y'){
			 newRound();
		 }
	
	 }
	
	public static void newRound(){
		int numberOfPlayers=(int)Math.random()*8+3;
		Game g=new Game(numberOfPlayers);
		 g.playAGame();
		 g.printScore();
		 System.out.println("Play another game (y/n)?");
		 Scanner sc = new Scanner(System.in);
		 char c=sc.nextLine().charAt(0);
		 if(c=='y'){
			 newRound();
		 }
	}


}
