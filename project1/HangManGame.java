
import java.util.ArrayList;

public class HangManGame {

	public static void main(String args[]){
		ArrayList<String> wordList=new ArrayList<String>();
		wordList.add("computer");
		wordList.add("software");
		wordList.add("program");
		wordList.add("internship");
		wordList.add("development");
		
		HangMan hm=new HangMan(wordList);
		hm.playGame();
		hm.handleGuess();
		hm.gameWon();
		
	}
	
}
