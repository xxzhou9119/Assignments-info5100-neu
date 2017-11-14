
public class Candy extends DessertItem{
	float weight; // access should be private
	int pricePerPound;
	
	boolean hasWeight(){
		return true;
	}

	public int getCost(){
		int cost=Math.round(weight*pricePerPound);
		return cost;
	}
	public float getWeight(){
		return this.weight;
	}
	
	public int getPrice(){
		return this.pricePerPound;
	}
	public Candy(String name,float weight,int pricePerPound){
		this.name=name;
		this.weight=weight;
		this.pricePerPound=pricePerPound;
		
	}
}
