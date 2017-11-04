
public class Game {
private final int PLAYERS;
private Deck deck;
private Hand[] players;
private Trick[] tricks;
private int numberOfTricks;
private boolean hearts;
private boolean queenOfSpades;

 public Game(int numberOfPlayers){
	this.PLAYERS=numberOfPlayers;
    this.players=new Hand[numberOfPlayers];
    this.deck=new Deck();
	for(int i=0;i<numberOfPlayers;i++){
		players[i]=new Hand(i,deck.getTotalCards()/numberOfPlayers);
    }
	this.tricks=new Trick[deck.getTotalCards()/numberOfPlayers];
	
}

 public int getPlayers(){
	 return this.PLAYERS;
 }
 
  public int getNumberOfTricks() {
	return numberOfTricks;
}
 
 public boolean getHearts() {
	return hearts;
}

 public boolean getQueenOfSpades() {
	return queenOfSpades;
}
 
 public void playAGame(){
	 System.out.println("output - first part");
	 deck.shuffle();
	 int cardsLeft=this.deck.getTotalCards()%this.getPlayers();
	 int cardsInHand=this.deck.getTotalCards()/this.getPlayers();
	 int playerNum=0;
	 int k=0;
	 for(int i=0;i<cardsInHand;i++){
		 for(int j=0;j<this.getPlayers();j++){
			this.players[j].addCard(this.deck.getCard(k));
			if(this.deck.getCard(k).getSuits()==0 && this.deck.getCard(k).getNum()==2){
				playerNum=j;
			}
			k++;
		 }
	 }

	 for(int i=0;i<this.getPlayers();i++){
	
		 this.players[i].sort();
		 this.players[i].setShortest();
		 System.out.println("      player "+this.players[i].getNum()+" shortest="+this.players[i].getShortest());
		 this.players[i].display();
	 }
	 System.out.println("");
	 System.out.println("output - second part");
	 int index=-1;
	 Card card;
	 for(int i=0;i<cardsInHand;i++){
	 
	    if(i==0){
		this.tricks[i]=new Trick(this.getPlayers()+cardsLeft); 
	    }else{
	    	this.tricks[i]=new Trick(this.getPlayers());
	    }
		this.numberOfTricks++;
		if(i==0){
			index=cardsInHand-1;
			card=this.players[playerNum].removeCard(index);
			this.tricks[i].update(playerNum, card);
		}else{
			card=this.players[playerNum].playACard(this, tricks[i]);
		}
		this.tricks[i].addCard(card);
		this.updateHeartsAndQueen(card);
		System.out.print("player "+playerNum+"       ");
		card.display();
		int temp=playerNum;
		for(int j=1;j<this.getPlayers();j++){
			playerNum=(j+temp)%this.getPlayers();
			card=this.players[playerNum].playACard(this, tricks[i]);
			this.tricks[i].addCard(card);
			this.updateHeartsAndQueen(card);
			System.out.print("player "+playerNum+"       ");
			card.display();
		}
		playerNum=this.tricks[i].getWinner();

		if(i==0){
			for(int j=cardsLeft;j>0;j--){
				card=this.deck.getCard(52-j);
				this.tricks[i].addCard(card);
				this.updateHeartsAndQueen(card);
				System.out.print("undelt card    ");
				card.display();
			}
		}
		System.out.println("");
	 } 	 
 }
 
 public void updateHeartsAndQueen(Card card){
	 if(this.hearts==false && card.getSuits()==2){
		 this.hearts=true;
		 System.out.println("Hearts is now broken");
	 }
	 if(card.getNum()==12 & card.getSuits()==3){
		 this.queenOfSpades=true;
	 }	
 }
 
 public int computePoints(int playerNum){
	int count=0;	
	 for(int i=0;i<this.numberOfTricks;i++){
			 if(this.tricks[i].getWinner()==playerNum){
				 for(int j=0;j<this.tricks[i].getCurrentSize();j++){
					 if(this.tricks[i].getCard(j).getSuits()==3 && this.tricks[i].getCard(j).getNum()==12){
						 count+=13;
					 }
					 if(this.tricks[i].getCard(j).getSuits()==2){
						 count++;
					 }
				 }
		 }
	 }
	 return count;
 }
 
 public void printScore(){
	 for(int i=0;i<this.getPlayers();i++){
		 System.out.println("player "+i+" score = "+this.computePoints(i));
		 }
 }
 

}
