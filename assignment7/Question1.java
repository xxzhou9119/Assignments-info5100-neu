
public class Question1 {

	class maxValueThread extends Thread{
	 private int lo, hi;
	 private int[] arr;
	 private int maxValue = Integer.MIN_VALUE;
		    
	 public maxValueThread(int[] arr, int lo, int hi) {
		 this.lo = lo;
		 this.hi = hi;
		 this.arr = arr;
	}
		    
	@Override
	  public void run(){
		for(int i=lo;i<hi;i++){
			if(this.maxValue<arr[i]){
				this.maxValue=arr[i];
			}
		}	
	}
}
	 public static int findMaxValue(int[] arr) throws InterruptedException {
	    int len = arr.length;
	    int max = Integer.MIN_VALUE;
	        
	     // Create and start 4 threads.
	    maxValueThread[] ms = new maxValueThread[4];
	    Question1 q=new Question1(); 
	       for (int i = 0; i < 4; i++) {
	       ms[i] = q.new maxValueThread(arr, (i * len) / 4, ((i + 1) * len / 4));
	       ms[i].start();
	  }
	        
	        // Wait for the threads to finish and sum their results.
	    for (int i = 0; i < 4; i++) {
	       ms[i].join();
	       if(max<ms[i].maxValue){
	       max=ms[i].maxValue;	
	        }
	     }
	        return max;
	  }
	 
	 public static void main(String[] args) throws InterruptedException {
	        int[] arr = new int[10];
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = (int)(Math.random()*100);
	            System.out.print(arr[i]+" ");
	            
	        }
	        System.out.println();
	        int maxValue = findMaxValue(arr);
	        System.out.println("MaxValue: " + maxValue);
	    }
	
}
