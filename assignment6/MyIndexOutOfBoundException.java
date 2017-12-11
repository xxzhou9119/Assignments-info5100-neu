
public class MyIndexOutOfBoundException extends ArrayIndexOutOfBoundsException{ // score 2
	
	
	public MyIndexOutOfBoundException(int lowerBound,int upperBound,int index){
		super("Error Message: Index: "+index+",but Lower bound: "+lowerBound+", Upper bound: "+upperBound);
	}
	
	public static void main(String args[]) {
		
		try{
			captureException(1,8,9);
		}catch(MyIndexOutOfBoundException e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("Done");
		}
	}
		 
	  public static void captureException(int lowerBound,int upperBound,int index){
			 if(index>upperBound||index<lowerBound){
				 MyIndexOutOfBoundException me=new MyIndexOutOfBoundException(lowerBound,upperBound,index);
				 throw me;
			 }
			 System.out.println(index);
			 
		 }

}
