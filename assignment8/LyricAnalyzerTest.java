import java.io.File;
import java.io.IOException;

public class LyricAnalyzerTest {
	public static void main(String[] args) throws IOException {
		File file=new File("/Users/xxzhou0109/neu-sep17/assignments/Assignment_8/Question2_test3.txt");
		LyricAnalyzer la=new LyricAnalyzer();
		la.read(file);
		System.out.println(la.mostFrequentWord());
		la.displayWords();
		File f=new File("/Users/xxzhou0109/test");
		la.writeLyrics(f);
		System.out.println(la.count());
	}
}
