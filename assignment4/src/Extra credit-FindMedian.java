// Extra credit:
public class FindMedian { // extra credit 2
	public static void main(String[] args) {
		int[] a={1,2};
		int[] b={3,4};
		double c=findMedianSortedArrays(a,b);
		System.out.println(c);
		
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median=0;
		int m=nums1.length;
		int n=nums2.length;
		int[] merge=mergeTwoArrays(nums1,m,nums2,n);
		int mid=(m+n)/2;
		if((m+n)%2==0){ 
		  median=(double)(merge[mid]+merge[mid-1])/2;
		}else{
			median=merge[mid];
		}
		return median;
			
    }
	
	public static int[] mergeTwoArrays(int[] nums1,int m, int[] nums2,int n){
		int[] result=new int[nums1.length+nums2.length];
		int i=0;
		int j=0;
		int k=0;
		if(m==0){
	        result=nums2;
	  }
	    if(n==0){
	    	result=nums1;
	  }
	    while(i<m && j<n){
	         if(nums1[i]<nums2[j]){
	                result[k]=nums1[i];
	                    i++;
	            }else{
	                result[k]=nums2[j];
	                j++;
	            }
	            k++;
	        }
	        while(i<m) {
	            result[k++]=nums1[i++];
	        } 
	        while(j<n){
	            result[k++]=nums2[j++];
	        }
	        
	        return result;
		
	}
	
}
