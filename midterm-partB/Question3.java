
public class Question3 {
	public static void main(String[] args){
		int[] nums={1,2,3};
		System.out.println(minMoves(nums));
	}
	public static int minMoves(int[] nums) {
	        if(nums.length<2){
	            return 0;
	        }
	        int minNum=nums[0];
	        int sum=nums[0];
	    //  Find the minimum number in the array and sum all the numbers.
	        for(int i=1;i<nums.length;i++){
	            minNum=Math.min( minNum,nums[i]);
	            sum+=nums[i]; 
	        }
	   //Before the progress, the sum of every number is S.After the process, 
	   //assume every number in the array equals to x,there are n numbers in the array, the total sum of them will be x*n.
	   //Because each time we add 1 to (n-1) numbers and we add y times, so S+(n-1)*y=x*n.    
	   //Since the minimum number in the array must participate in every summation (after which it still be
	   // the minimum in the array), so x equals to the minimum + y.     
	        int result=sum-minNum*nums.length;
	        return result; 
	    }
	
}
