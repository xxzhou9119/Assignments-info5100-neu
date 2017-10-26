import java.util.ArrayList;

public class Question4 {
	 public static void main(String[] args){
		 int n=3;
		 int m=4;
		 int sum=7;
		 System.out.println(countNumberOfPossibleWays(m,n,sum));
	 }
	
	 public static int countNumberOfPossibleWays(int m,int n,int x){
	int[] possibleWay=new int[n];
	ArrayList<int[]>result=new ArrayList<int[]>();
	int current=0;
	
	backtracking(possibleWay,m,current,x,result);
	return result.size();
	
  }
	public static void backtracking(int[] nums,int m,int current,int sum, ArrayList<int[]> list){
		if(current==nums.length){
			if(check(nums,sum)){
			list.add(nums);
			}
			return;
			
		}
		for(int i=1;i<m+1;i++){
			nums[current]=i;	
			backtracking(nums,m,current+1,sum,list);
		}
		
	}
	
	public static boolean check(int[] nums,int sum){
		int sumOfNums=0;
		for(int i=0;i<nums.length;i++){
			sumOfNums+=nums[i];
		}
		if(sumOfNums==sum){
			return true;
		}
		return false;
	}
}