
public class Question2 {
	class helloThread extends Thread{
		private final String s="Hello";
		private int num;
		public helloThread(int num){
			this.num=num;
		}
		public int getNum(){
			return this.num;
		}
		@Override
		public void run(){	
			if(this.getNum()>50)
				return;
			helloThread ht=new helloThread(this.getNum()+1);
			ht.start();
            try{
				ht.join();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
            System.out.println(s +" from Thread "+ this.getNum());
		}	
		
	}
	
	 public static void printHello(int num){
		 Question2 q=new Question2();
		 helloThread ht=q.new helloThread(num);
		 ht.start();
	 }
	 public static void main(String[] args){
		 printHello(1);
	 }
}
