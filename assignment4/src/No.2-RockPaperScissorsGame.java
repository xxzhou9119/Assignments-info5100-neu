//No.2: 
class RockPaperScissorsGame{
   class Tool {
	 protected double strength;
     protected char type;
	
	public void setStrength(int s){
		this.strength=s;
		
	}
	public double getStrength(){
		return strength;
	}
	public Tool(double strength,char type){
		this.strength=strength;
		this.type=type;
	}
	
	public boolean fight(Tool t){
		return true;
	}
    }
	
	class Scissors extends Tool{
		
		public Scissors(double strength){
			super(strength,'s');
		}
		
		@Override
		public boolean fight(Tool t){
			if(t.type=='p'){
				if(this.strength*2>t.getStrength()){
					return true;
				}
              return false;
			}
			if(t.type=='r'){
				if(this.strength/2>t.getStrength()){
					return true;
				}
              return false;
			}
			return true;
		}
		
	}
	
	class Paper extends Tool{
		
		public Paper(double strength){
			super(strength,'p');
		
	    }
		
		@Override
		public boolean fight(Tool t){
			if(t.type=='r'){
				if(this.strength*2>t.getStrength()){
					return true;
				}
              return false;
			}
			if(t.type=='s'){
				if(this.strength/2>t.getStrength()){
					return true;
				}
              return false;
			}
			return true;
		}
	}
	
	class Rock extends Tool{
		public Rock(double strength){
			super(strength,'r');
		}
		
		@Override
		public boolean fight(Tool t){
			if(t.type=='s'){
				if(this.strength*2>t.getStrength()){
					return true;
				}
              return false;
			}
			if(t.type=='p'){
				if(this.strength/2>t.getStrength()){
					return true;
				}
              return false;
			}
			return true;
		}
		
	}
	
    public  static void main(String args[]){
    	RockPaperScissorsGame game = new RockPaperScissorsGame();
        Scissors s = game.new Scissors(5);
        Paper p = game.new Paper(7);
        Rock r = game.new Rock(15);
              
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
}
	

}

