// No.3
public class ExtractIPAddress { // score update
	public static void main(String args[]){
		ExtractIPAddress comp=new ExtractIPAddress();
		IpAddress ip = comp.new IpAddress("224.0.118.62");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
	}
	
	class IpAddress{
		String address;
		int pos1;
		int pos2;
		int pos3;
		int pos4;
	
	public IpAddress(String addr){
		this.address=addr;
		String[] split=new String[4];
		int j=0;
		String temp="";
		for(int i=0;i<addr.length();i++){  
			if(addr.charAt(i)=='.'){
			split[j]=temp;
			j++;
			temp="";
		}else{
			temp=temp+addr.charAt(i);
		} 
	 }
		split[j]=temp;
		this.pos1=Integer.parseInt(split[0]);
		this.pos2=Integer.parseInt(split[1]);
		this.pos3=Integer.parseInt(split[2]);
		this.pos4=Integer.parseInt(split[3]);
	  }
	
	
	public String getDottedDecimal(){
		
		return this.address;
	}
	
	public int getOctet(int pos){
	  int[] Octet=new int[4];
	  Octet[0]=this.pos1;
	  Octet[1]=this.pos2;
	  Octet[2]=this.pos3;
	  Octet[3]=this.pos4;
	  return Octet[pos-1];
	}
	
	}
	
}
