import java.text.DecimalFormat;

public class Controller extends Thread{
  private Device device;
  private Sensor heat;
  private Sensor pressure;
  
  public  Controller(Device device,Sensor heat,Sensor pressure){
	  this.device=device;
	  this.heat=heat;
	  this.pressure=pressure;
  }
  
  @Override
  public void run(){
	  this.device.startup();
	  System.out.println("heat -> "+ 0.00+", "+"pressure -> "+0.00);
	  while(this.device.isWorking()){
		 
		  this.moniter();
//	      try{
//				this.sleep(1);
//			}catch(InterruptedException ex){
//				ex.printStackTrace();
//			}
	  } 
  }
  public synchronized void moniter(){
//	  DecimalFormat df = new DecimalFormat("#.00"); 
	  double heat=this.heat.getValue();
	  double pressure=this.pressure.getValue();
	  
	  System.out.println("heat -> "+heat+", "+"pressure -> "+pressure);
      if(heat>=70 || pressure>=100){
	      this.device.setWorking(false);
	      this.device.shutdown();
  }
  }
}
