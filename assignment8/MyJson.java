import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyJson {
	public static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException,FileNotFoundException{
		ArrayList<Vehicle> list=new ArrayList<Vehicle>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		br.readLine();
		while(true){
			String line = br.readLine();
			if (line == null)
				break;
			String[] vehicle=line.split("\\~");
			list.add(new Vehicle(vehicle));
			
			
	}
		br.close();
		return list;
    }
	public static String getJsonString(ArrayList<Vehicle> vehicles){
		StringBuilder sb=new StringBuilder();
		sb.append("{"+"\n");
		sb.append("\""+vehicles.get(0).webId+"\""+" : "+"["+"\n");
		for(int i=0;i<vehicles.size();i++){
			sb.append("{"+"\n");
			sb.append("\"id\" : "+"\""+vehicles.get(i).id+"\""+"\n");
			sb.append("\"category\" : "+"\""+vehicles.get(i).category+"\""+"\n");
			sb.append("\"year\" : "+"\""+vehicles.get(i).year+"\""+"\n");
			sb.append("\"make\" : "+"\""+vehicles.get(i).make+"\""+"\n");
			sb.append("\"model\" : "+"\""+vehicles.get(i).model+"\""+"\n");
			sb.append("\"trim\" : "+"\""+vehicles.get(i).trim+"\""+"\n");
			sb.append("\"type\" : "+"\""+vehicles.get(i).type+"\""+"\n");
			sb.append("\"price\" : "+"\""+vehicles.get(i).price+"\""+"\n");
			sb.append("\"photo\" : "+"\""+vehicles.get(i).photo+"\""+"\n");
			if(i!=vehicles.size()-1){
				sb.append("},"+"\n");
			}else{
				sb.append("}"+"\n");
			}
		}
		sb.append("]"+"\n");
		sb.append("}"+"\n");
		return sb.toString();
	}
	public static void writeToFile(String inputToWrite, String filePath) throws IOException{
		File f=new File(filePath+"/Json");
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		pw.print(inputToWrite);
		pw.close();
	}
	
//	Extra credit:
	public static String originalFile(File jsonFile) throws FileNotFoundException,IOException{
		StringBuilder sb=new StringBuilder();
		sb.append("id~webId~category~year~make~model~trim~type~price~photo"+"\n");
		BufferedReader br = new BufferedReader(new FileReader(jsonFile));
		br.readLine();
		String s=br.readLine();

		String[] temp=s.split("\"");
		String webId=temp[1];
		while(true){
			String line=br.readLine();
						
			if(line.equals("]"))
				break;
			if(line.equals("{")){
				String id=br.readLine();
				String[] idChar=id.split("\"");
				sb.append(idChar[idChar.length-1]);
				sb.append("~");
				sb.append(webId+"~");
				String cat=br.readLine();
				String[] catChar=cat.split("\"");
				String lower=catChar[catChar.length-1].toLowerCase();
				sb.append(lower+"~");
				while(true){
					String str=br.readLine();
					if(str.charAt(0)=='}'){
						sb.deleteCharAt(sb.length()-1);
						sb.append("\n");
						break;
					}
					String[] content=str.split("\"");
					if(content[content.length-1].equals(" : ")){
					sb.append("~");
					}else{
					sb.append(content[content.length-1]+"~");
					}
					
				}
				
			}
		}
		br.close();
		return sb.toString();
	}
	public static void writeToOriginal(String inputToWrite, String filePath) throws IOException{
		File f=new File(filePath);
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		pw.print(inputToWrite);
		pw.close();
	}
	
//	public static void main(String[] args) throws IOException{
//	    File file = new File("/Users/xxzhou0109/neu-sep17/assignments/Assignment_8/Question3_camino.txt");
//	    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
//	    String s = getJsonString(vehicles);
//	    writeToFile(s, file.getParent());
//	    File file2=new File("/Users/xxzhou0109/neu-sep17/assignments/Assignment_8/Json");
//	    String original=originalFile(file2);
//	    writeToOriginal(original,"/Users/xxzhou0109/neu-sep17/assignments/Assignment_8/Original");
//	}
}
















