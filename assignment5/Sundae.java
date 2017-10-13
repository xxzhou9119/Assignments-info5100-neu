
public class Sundae extends IceCream{
	String sundaeName;
	float  sundaePrice;
	
	public int getCost(){
		int cost=Math.round(this.cost+this.sundaePrice);
		return cost;
	}
	
	public Sundae(String name,float cost,String sundaeName,	float sundaePrice){
		super(name,cost);
		this.sundaeName=sundaeName;
		this.sundaePrice=sundaePrice;
	}

}
