
public class Question2 { // score 7
	public int arrangeCoins(int n){
//    In math view, assume there are x lines, a complete stairs needs x*(x+1)/2 coins.
//	  So, if we have n coins, n=x*(x+1)/2, x=((-1+Math.sqrt(1+8.0*n))/2). if x is an integer, that means the
//    last stair is complete, if x is not an integer,that means the last stair is incomplete.		
		
       int result=(int) ((-1+Math.sqrt(1+8.0*n))/2);
       return result;
}

}
