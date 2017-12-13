import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LyricAnalyzer { // score 4
	private HashMap<String, ArrayList<Integer>> map=new HashMap<String, ArrayList<Integer>>();
	
	public void read(File file) throws IOException, FileNotFoundException{
		int index=1;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(true){
			String line = br.readLine();
			
			if (line == null)
				break;
		    String[] words=line.split(" ");
		    for(int i=0;i<words.length;i++){
		    	if(i!=words.length-1){
		    		this.add(words[i].toUpperCase(), index);
		    		index++;
		    	}else{
		    		this.add(words[i].toUpperCase(), index*(-1));
		    		index++;
		    	}
		    }
		}
		br.close();
	}
	
	private void add(String lyricWord, int wordPosition){
		if(map.containsKey(lyricWord)){
			map.get(lyricWord).add(wordPosition);	
		}else{
			map.put(lyricWord,new ArrayList<Integer>());
			map.get(lyricWord).add(wordPosition);
		}
	}
	
	public void displayWords(){
		Object[] words=map.keySet().toArray();
		Arrays.sort(words);
		System.out.println("Word             Word position(s)");
		System.out.println("==============================");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<words.length;i++){
			String word=(String) words[i];
			sb.append(word);
			for(int k=0;k<17-word.length();k++){
			sb.append(" ");
			}
			for(int j=0;j<map.get(word).size();j++){
			    if(j!=map.get(word).size()-1){
				sb.append(map.get(word).get(j)+",");
			}else{
				sb.append(map.get(word).get(j));
			}
		}
			sb.append("\n");
		}
		String s=sb.toString();
	    System.out.println(s);
	}
	
	public void writeLyrics(File file) throws IOException{
		String[] Lyrics=new String[this.count()+1];
		Object[] words=map.keySet().toArray();
		for(int i=0;i<words.length;i++){
			String word=(String) words[i];
			for(int j=0;j<map.get(word).size();j++){
				int index=map.get(word).get(j);
				if(index<0){
					index=(-1)*index;
					Lyrics[index]=word+"\n";
				}else{
					Lyrics[index]=word+" ";
				}	
			}
	    }
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		for(int i=1;i<Lyrics.length;i++){
			pw.print(Lyrics[i]);
		}
		pw.close();	
 }
	
	public int count(){
		int result=0;
		Object[] words=map.keySet().toArray();
		for(int i=0;i<words.length;i++){
			String word=(String) words[i];
			result+=map.get(word).size();
		}
		return result;
	}
	public String mostFrequentWord(){
	    int maxLength=Integer.MIN_VALUE;
	    String result="";
		Object[] words=map.keySet().toArray();
		Arrays.sort(words);
		for(int i=0;i<words.length;i++){
			String word=(String) words[i];
			int length=map.get(word).size();
			if(length>maxLength){
				maxLength=length;
				result=word;
			}
	    }
		return result;
   }
}
