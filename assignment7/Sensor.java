
public class Sensor extends Thread {
	
	 private final Device device;
	 private double value;
	 public Sensor(Device device) {
	      this.device = device;
	      this.value=0.00;
	 }
	 public double getValue() {
	   return value;
	 }
	 public void updateValue() { 
	    this.value +=0.001; // you check with other values here and see how it works
		
	 }
	
	 @Override     
	 public void run() {
		 
		 while(this.device.isWorking()){

			 this.updateValue();
		 }
	   }
	
}
