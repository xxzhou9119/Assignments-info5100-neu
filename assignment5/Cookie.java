
public class Cookie extends DessertItem{
	int number;
	int pricePerDozen;
	
	boolean hasNumber(){
		return true;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public int getCost(){
		int cost=Math.round(pricePerDozen*number/12);
		return cost;
	}
	public int getPrice(){
		return this.pricePerDozen;
	}
	
	public Cookie(String name,int number,int pricePerDozen){
		this.name=name;
		this.number=number;
		this.pricePerDozen=pricePerDozen;
		
	}

}
