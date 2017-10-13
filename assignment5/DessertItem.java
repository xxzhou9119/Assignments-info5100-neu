
public abstract class DessertItem extends DessertShoppe{
   String name;
   boolean hasWeight(){
	   return false;
   }
   boolean hasNumber(){
	   return false;
   }
   
   public DessertItem(){
	   
   }
   
   public DessertItem(String name){
	   this.name=name;
   }
   
   public final String getName(){
	   return this.name;
   }
   
   public abstract int getCost();
   
   public float getWeight(){
	   return 0;
   }
   public int getNumber(){
	   return 0;
   }
   public int getPrice(){
	   return this.getCost();
   }
}
