import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Question2 {
//	2. Modify the following parse() method so that it will compile: (Score 1)  
//	 
//    ``` java
//      public static void parse(File file) {
//          RandomAccessFile input = null;
//          String line = null;
//          
//          try {
//              input = new RandomAccessFile(file, &quot;r&quot;);
//              while ((line = input.readLine()) != null) {
//                  System.out.println(line);
//              }
//              return;
//          } finally {
//                if (input != null) {
//                  input.close();
//                }
//            }
//      }   
	
	
	
	
	public static void parse(File file) {
         RandomAccessFile input = null;
         String line = null;
         
         try {
             input = new RandomAccessFile(file, "r");
             while ((line = input.readLine()) != null) {
                 System.out.println(line);
             }
             return;
         } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
               if (input != null) {
                 try {
					input.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
               }
           }
     }  
}
