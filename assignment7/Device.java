
public class Device {
	private boolean working=true;
	
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean b) {
		this.working = b;
	}
	public void startup() {
		System.out.println("Device started");
	} 
    public void shutdown() {
    	System.out.println("Device shutting down due to maintenance");
    } 
}
