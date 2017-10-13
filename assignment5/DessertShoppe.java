
public class DessertShoppe {
	public final static String shopName="M & M Dessert Shoppe";
	public final static float taxRate=6.5f;
	public final static int maxSizeOfItem=30;
	public final static int width=50;
	                                        
	public String centsToDollars(int cents){
		String dollars="";
			int a=cents/100;
			if(a!=0){
				dollars+=a;
			}
			dollars+='.';
			int b=cents%100/10;
			dollars+=b;
			int c=cents%100%10;
			dollars+=c;
			return dollars;
		}
	}


