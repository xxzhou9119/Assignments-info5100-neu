import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExtraCreditAtmFileVersion {
	public void setAvailableAmountInMachine(double availableAmountInMachine) throws IOException{
		File f=new File("textfile.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(Double.toString(availableAmountInMachine));
        fw.close();	
    }
	public double getAvailableAmountInMachine() throws IOException{
        FileReader fr = new FileReader("textfile.txt");  
        BufferedReader br = new BufferedReader(fr); 
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return Double.parseDouble(sb.toString());
	    } finally {
	        br.close();
	    }
    }
	
	public void setTransactionFee(double transactionFee) throws IOException{
		File f=new File("textfile.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(Double.toString(transactionFee));
        fw.close();	
    }
	public double getTransactionFee() throws IOException{
        FileReader fr = new FileReader("textfile.txt");  
        BufferedReader br = new BufferedReader(fr); 
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return Double.parseDouble(sb.toString());
	    } finally {
	        br.close();
	    }
    }
	public void setUserData(String userData) throws IOException{
		File f=new File("textfile.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(userData);
        fw.close();	
    }
	public String getUserData() throws IOException{
        FileReader fr = new FileReader("textfile.txt");  
        BufferedReader br = new BufferedReader(fr); 
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
    }
	
	public void setRecentTransactions(String recentTransactions) throws IOException{
		File f=new File("textfile.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(recentTransactions);
        fw.close();	
    }
	public String getRecentTransactions() throws IOException{
        FileReader fr = new FileReader("textfile.txt");  
        BufferedReader br = new BufferedReader(fr); 
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
    }
	
	
}
