import java.util.ArrayList;
import java.util.List;

public class TheExtraCredit {
	
	public static void main(String args[]){
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		List<Integer> a=spiralOrder(matrix);
		System.out.println(a);
	}

		
	public static List<Integer> spiralOrder(int[][] matrix){
		 
		  List<Integer> result=new ArrayList<Integer>();
		        if(matrix.length==0){
		            return result;
		        }
		        
		        int rowFront=0;
		        int rowBack=matrix.length-1;
		        int collumFront=0;
		        int collumBack=matrix[0].length-1;
		        
		        while(rowFront<=rowBack && collumFront<=collumBack ){
		            // traverse from left to the right;
		        	for(int i=rowFront;i<=collumBack;i++){
		                result.add(matrix[rowFront][i]);
		            }
		            rowFront++;
		            // traverse down;
		            for(int i=rowFront;i<=rowBack;i++){
		                result.add(matrix[i][collumBack]);
		            }
		            collumBack--;
		            
		            // check if this row already been encountered;
		            //  then traverse from right to the left;
		            if(rowFront<=rowBack){
		                for(int i=collumBack;i>=collumFront;i--){
		                    result.add(matrix[rowBack][i]);
		                }
		            }
		            rowBack--;
		           
		            //check if this column already been encountered;
		            // traverse up;
		            if(collumFront<=collumBack){
		                for(int i=rowBack;i>=rowFront;i--){
		                    result.add(matrix[i][collumFront]);
		                }
		            }
		            collumFront++;  
		        }
		        return result;
		    }
		
	}
	
	


