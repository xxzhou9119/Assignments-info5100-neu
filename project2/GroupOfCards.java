
public class GroupOfCards{
	private Card[] cards;
	private int currentSize;
	
	public GroupOfCards(int num){
		Card[] cards=new Card[num];
		this.cards=cards;
	}

	public int getCurrentSize(){
		return this.currentSize;
	}
	public void setCurrentSize(int num){
		if(num>=0 && num<=this.cards.length){
			this.currentSize=num;
		}
	}
	
	public Card getCard(int i){
		if(i<0 || i>=this.currentSize){
			throw new ArrayIndexOutOfBoundsException("No card exist.");		
		}
	return this.cards[i];
	}
	
	public void addCard(Card card){
		if(this.getCurrentSize()==this.cards.length){
			System.out.println("The group is full. You can't add a card.");
		}else{
		    this.cards[this.getCurrentSize()]=card;
		    this.setCurrentSize(this.getCurrentSize()+1);;
		}
	}
	
	public Card removeCard(int index){
		Card card=this.getCard(index);
		for(int i=index;i<this.getCurrentSize()-1;i++){
			this.cards[i]=this.cards[i+1];
		}
		this.setCurrentSize(this.getCurrentSize()-1);;
	return card;	
	}
	
	public void display(){
		for(int i=0;i<this.getCurrentSize();i++){
			this.cards[i].display();
	   }		 
	}
	 
	
}
