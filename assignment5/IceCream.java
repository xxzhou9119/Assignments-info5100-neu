
public class IceCream extends DessertItem{
	float cost;
	
	public int getCost(){
		return Math.round(this.cost);
		
	}
   
	public IceCream(String name,float cost){
		this.name=name;
		this.cost=cost;
		
	}
}
