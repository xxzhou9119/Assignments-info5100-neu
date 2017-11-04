
public class Card {
	private int num;
	private int suits;

	public int getNum() {
		return num;
	}	

	public int getSuits() {
		return suits;
	}

	public Card(int num,int suit){
		if(num>=2 && num<=14){
			this.num=num;
		}else{
			System.out.println("illegal number");
		}
		if(suit>=0 && suit<=3){
			this.suits=suit;
		}else{
			System.out.println("illegal suit");
		}
	}
	
	public void display(){
		StringBuilder sb=new StringBuilder();
		switch(this.num){
		case(11):
			sb.append("Jack");
		    break;
		case(12):
			sb.append("Queen");
		    break;
		case(13):
			sb.append("King");
		    break;
		case(14):
			sb.append("Ace");
		    break;
		default:
			sb.append(this.num);
			break;
		}
		sb.append(" of ");
		switch(this.suits) {
		case(0):
			sb.append("clubs ");
		    break;
		case(1):
			sb.append("diamonds ");
		    break;
		case(2):
			sb.append("hearts ");
		    break;
		case(3):
			sb.append("spades ");
		    break;
		}
		
		System.out.println(sb.toString());
	}
	

}
