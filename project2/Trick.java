
public class Trick extends GroupOfCards{
	
	private int winner;
	private Card winningCard;
	private boolean hearts;
	private boolean queen;
	
	public Trick(int players){
		super(2*players-1);
	}
	
	public int getWinner() {
		return winner;
	}
	public Card getWinningCard() {
		return winningCard;
	}
	public boolean getHearts() {
		return hearts;
	}
	public void setHearts(boolean b){
		this.hearts=b;
	}
	public boolean getQueen() {
		return queen;
	}
	public void setQueen(boolean b){
		this.queen=b;
	}
	
	public boolean isWinner(Card card){
		if(this.winningCard!=null){
			if(card.getSuits()!=this.winningCard.getSuits() || card.getNum()<this.winningCard.getNum()){
				return false;
			}
		}
		return true;
	}
	
	public void update(int playerNum,Card card){
		if(this.isWinner(card)){
			this.winner=playerNum;
			this.winningCard=card;
			}
			if(card.getSuits()==2){
				this.setHearts(true);
			}
			if(card.getNum()==12){
				this.setQueen(true);
			}
		}
		
	}
	

