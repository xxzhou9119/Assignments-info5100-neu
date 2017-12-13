import java.io.IOException;
import java.util.Scanner;

public class FileCounter { // score 3
	private int characterCount, wordCount, lineCount;
	
	   
	   public int getCharacterCount() {
		return characterCount;
	}

	

	public int getWordCount() {
		return wordCount;
	}

	public int getLineCount() {
		return lineCount;
	}


	public FileCounter(){
	     
}
	   
	 public void read(Scanner in) throws IOException {
		while(in.hasNextLine()){
			this.lineCount++;
			String line=in.nextLine();
			String[] words=line.split(" ");
			this.wordCount+=words.length;
			for(String s:words){
				this.characterCount+=s.length();
			}	
		  }    
	   }

}
