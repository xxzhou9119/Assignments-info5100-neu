import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void printPascalTriangle(int n){
		List<int[]> pascalTriangle=new ArrayList<int[]>();
		if(n<=0){
			System.out.println("Illegal number.");
		}
		int[] row={1};
		pascalTriangle.add(row);
		for(int i=1;i<n;i++){
			int[] nextRow=new int[i+1];
			for(int j=0;j<i+1;j++){
				if(j==0 || j==i){
					nextRow[j]=1;
				}else{
					nextRow[j]=pascalTriangle.get(i-1)[j]+pascalTriangle.get(i-1)[j-1];
				}
			}
			pascalTriangle.add(nextRow);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<i+1;j++){
				System.out.print(pascalTriangle.get(i)[j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		printPascalTriangle(6);
	}
}
