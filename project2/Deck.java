
public class Deck extends GroupOfCards {
 private final int TOTALCARDS=52;
 
 public Deck(){
	 super(52);
	 for(int i=0;i<4;i++){
	    for(int j=0;j<13;j++){
		this.addCard(new Card(j+2,i));
	 }
   }
 } 
public int getTotalCards(){
	return this.TOTALCARDS;
}

 public void shuffle(){
	 int unshuffled=this.getCurrentSize(); 
	 while(unshuffled>0){
	   int index=(int) (Math.random()*unshuffled);
	   Card card=this.removeCard(index);
	   this.addCard(card);
	   unshuffled--;
	 }
 }
  public Card dealCard(){
	  return this.removeCard(0);
  }
 
  
 
}
