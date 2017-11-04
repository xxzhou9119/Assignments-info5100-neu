

public class Hand extends GroupOfCards{
private final int NUM;
private int shortest;

 public Hand(int playerNum,int numberOfCards){
	 super(numberOfCards);
	 this.NUM=playerNum;
	 this.shortest=0;
}
 public int getNum(){
	 return this.NUM;
 }
 
 public void sort(){
	 int unSorted=this.getCurrentSize();
	 
	 while(unSorted>0){
		 int maxIndex=0;
	     int max=13*this.getCard(0).getSuits()+this.getCard(0).getNum();
	 for(int i=0;i<unSorted;i++){
		
	     int number=13*this.getCard(i).getSuits()+this.getCard(i).getNum();
		 if(number>max){
			 max=number;
			 maxIndex=i;
		 } 
	 }
	 Card card=this.removeCard(maxIndex);
	 this.addCard(card);
	 unSorted--;
   }
 }
 public void setShortest(){
	 int clubsCount=0;
	 int diamondsCount=0;
	 int heartsCount=0;
	 int spadesCount=0;
	 for(int i=0;i<this.getCurrentSize();i++){
		 switch(this.getCard(i).getSuits()){
		 case(0):
			 clubsCount++;
		     break;
		 case(1):
			 diamondsCount++;
		     break;
		 case(2):
			 heartsCount++;
		     break;
		 case(3):
			 spadesCount++;
		     break;
		 } 
	 }
	 if(clubsCount==0 && diamondsCount==0 && spadesCount==0 ){
		 this.shortest=2;
		 return;
	 }
	 int min=0; 
	 if(clubsCount!=0){
		 this.shortest=0;
	    if(diamondsCount!=0 && diamondsCount<=clubsCount){
		 this.shortest=1;
		 min=diamondsCount;
	   }else{
		  min=clubsCount;
	   }
	 }else if(diamondsCount!=0){
		   this.shortest=1;
		   min=diamondsCount;
	   }else{
		   this.shortest=3;
		   return;
	   }
	 
	 if(spadesCount!=0 && spadesCount<=min && (this.find(14, 3)==-1 || this.find(13, 3)==-1 || this.find(12, 3)==-1)){
			 this.shortest=3;
	    } 
	 
 }
 
    public int getShortest(){
	    return this.shortest;
 }
 
    public int findLowest(int suit){
    	int min=15;
    	int minIndex=-1;
    	for(int i=0;i<this.getCurrentSize();i++){
    		if(this.getCard(i).getSuits()==suit){
    			if(this.getCard(i).getNum()<min){
    				min=this.getCard(i).getNum();
    				minIndex=i;
    			}
    		}
    	}
    	return minIndex;
    }
    
    public int findHighest(int suit){
    	int max=0;
    	int maxIndex=-1;
    	for(int i=0;i<this.getCurrentSize();i++){
    		if(this.getCard(i).getSuits()==suit){
    			if(this.getCard(i).getNum()>max){
    				max=this.getCard(i).getNum();
    				maxIndex=i;
    			}
    		}
    	}
    	return maxIndex;
    }
	
    public int findCount(int suit){
    	int count=0;
    	for(int i=0;i<this.getCurrentSize();i++){
    		if(this.getCard(i).getSuits()==suit){
    			count++;
    		}
    	}
    	return count;
    }
    
    public int find(int num,int suit){
		 for(int i=0;i<this.getCurrentSize();i++){
			 if(this.getCard(i).getNum()==num && this.getCard(i).getSuits()==suit){
				 return i;
			 }
		 }
		 return -1;
	 }
 
   public int findLowest(Game game){
	   int min=15;
	   int minIndex=-1;
	   if(game.getHearts()){
		   for(int i=0;i<this.getCurrentSize();i++){
			   if(this.getCard(i).getNum()<min){
				   min=this.getCard(i).getNum();
				   minIndex=i;
			   }
		   }
		   return minIndex;
	   }else{
		   for(int i=0;i<this.getCurrentSize();i++){
			   if(this.getCard(i).getNum()<min && this.getCard(i).getSuits()!=2){
				   min=this.getCard(i).getNum();
				   minIndex=i;
			   }
	      }
	   }
	   return minIndex;
   }
   
   public int findLastHigh(int suit){
	   int max=0;
	   int lastMax=0;
	   int maxIndex=-1;
	   int lasMaxIndex=-1;
	   for(int i=0;i<this.getCurrentSize();i++){
		   if(this.getCard(i).getSuits()==suit){
			  if(this.getCard(i).getNum()>max){
				  lastMax=max;
				  max=this.getCard(i).getNum();
				  lasMaxIndex=maxIndex;
				  maxIndex=i; 
			  }else if(this.getCard(i).getNum()>lastMax){
				  lastMax=this.getCard(i).getNum();
				  lasMaxIndex=i; 
			  }
		   }
	   }
	   if(maxIndex!=-1){
	   if(this.getCard(maxIndex).getSuits()==3 && this.getCard(maxIndex).getNum()==12 ){
		   if(lasMaxIndex!=-1){
			   return lasMaxIndex;
		   }
	     }
	   }
	   return maxIndex;
   }
   
   public int findHighestBelow(Card winningCard){
	   int index=-1;
	   int suit=winningCard.getSuits();
	   for(int i=0;i<this.getCurrentSize();i++){
		   if(this.getCard(i).getSuits()==suit){
			   if(this.getCard(i).getNum()<winningCard.getNum()){ 
				   if((i!=this.getCurrentSize()-1 && this.getCard(i+1).getSuits()==suit) || i==this.getCurrentSize()-1 ){
			        index=i;
				   return index;
				   }
			   }
		   }
	   }
	   return index;
   }
   
   public int findMiddleHigh(Game game,int suit){
	   int index=-1;
	   if(suit==3 && game.getQueenOfSpades()==false){
		   int max=0;
		   for(int i=0;i<this.getCurrentSize();i++){
		   if(this.getCard(i).getSuits()==suit){
			   if(this.getCard(i).getNum()>max && this.getCard(i).getNum()<=11){
			 max=this.getCard(i).getNum();
			 index=i;
		   }else if(this.getCard(i).getNum()==12){
			   index=i;
		   }
	     }
		   }
     }else{
		  index=this.findHighest(suit);
	  }
	  return index; 
   }
	   
	   
   public int findHighest(){
	   int max=0;
	   int maxIndex=0;
	   for(int i=0;i<this.getCurrentSize();i++){
		   if(this.getCard(i).getNum()>max){
			   max=this.getCard(i).getNum();
			   maxIndex=i;
		   }
	   }
	  return maxIndex; 
   }
   
   public Card playACard(Game game,Trick trick){
	   int index=-1;
	   this.setShortest();
	   if(trick.getCurrentSize()==0){
		   int suit=this.getShortest();
		   if(suit==2){
			   index=this.findLowest(2);
		   }else{
		   index=this.findHighest(suit);
		   }
	   }else if(trick.getCurrentSize()==game.getPlayers()-1 && !trick.getHearts() && !trick.getQueen()){
		   int suit=trick.getCard(0).getSuits();
		   index=this.findLastHigh(suit);
	   }else{
		   if(findHighestBelow(trick.getWinningCard()) >= 0){
			   index=findHighestBelow(trick.getWinningCard());
		   }else{
			   int suit=trick.getCard(0).getSuits();
			   index=findMiddleHigh(game,suit);
		   }
	   }
	   if(index<0){
		   if ((index = find(12, 3)) >= 0); // queen of Spades
		   else if ((index = find(14, 3)) >= 0); // Ace of Spades
		   else if ((index = find(13, 3)) >= 0); // King of Spades
		   else if ((index = findHighest(2)) >= 0); // heart
		   else{
		     index = findHighest();
		   }
	   }
	   Card card=this.removeCard(index);
	   trick.update(this.NUM, card);
	   return card;
   }
   
   
   
   

 
}
