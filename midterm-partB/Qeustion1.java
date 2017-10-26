
public class Qeustion1 {	
	
	public static int[] reverseEvenIndices(int[] nums){
        int n=0;
        if(nums.length%2==1){
        	n=nums.length-1;
        }else{
        	n=nums.length-2;
        }
        for(int i=0;i<nums.length/2;i+=2){
        	swap(nums,i,n-i);
        }
        return nums;
}
	public static  void swap(int[] nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
