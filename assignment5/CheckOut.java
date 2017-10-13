import java.util.ArrayList;

public class CheckOut extends DessertShoppe {
   ArrayList<DessertItem> Items=new ArrayList<DessertItem>();
	
   public CheckOut(){
		
	}
	
	public int numberOfItems(){
		return this.Items.size();	
	}
	
	public void enterItem(DessertItem item){
		this.Items.add(item);
	}
	
	public void clear(){
		this.Items.clear();
	}
	
	public int totalCost(){
		int sum=0;
		for(int i=0;i<this.Items.size();i++){
			sum+=this.Items.get(i).getCost();
		}
		return sum;
	}
	
	public int totalTax(){
		int tax=Math.round(this.totalCost()*taxRate/100);
		return tax;
	}
	
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n");
		for(int i=0;i<(width-shopName.length())/2;i++){
			sb.append(' ');
		}
		sb.append(shopName);
		sb.append("\n");
		for(int i=0;i<(width-shopName.length())/2;i++){
			sb.append(' ');
		}
		for(int i=0;i<shopName.length();i++){
			sb.append('-');
		}
		sb.append("\n");
		sb.append("\n");
		for(int i=0;i<Items.size();i++){
		 if(Items.get(i).hasWeight()){
		sb.append(Items.get(i).getWeight()+" lbs. "+"@ "+Items.get(i).centsToDollars(Items.get(i).getPrice())+" /lb.");
		sb.append("\n");
		}
		 if(Items.get(i).hasNumber()){
			sb.append(Items.get(i).getNumber()+" @ "+Items.get(i).centsToDollars(Items.get(i).getPrice())+" /dz.");
			sb.append("\n");
		 }
		 if(Items.get(i).name.length()<=maxSizeOfItem){
			 sb.append(Items.get(i).name);
			 for(int j=0;j<width-Items.get(i).name.length()-Items.get(i).centsToDollars(Items.get(i).getCost()).length();j++){
				sb.append(" ");
			 }
			 sb.append(Items.get(i).centsToDollars(Items.get(i).getCost()));
			 sb.append("\n");
		 }else{
		 String[] words=Items.get(i).name.split(" ");
		 int length=0;
		 for(int j=0;j<words.length;j++){
			 if(length+words[j].length()<=maxSizeOfItem){
				 sb.append(words[j]);
				 length+=words[j].length()+1;
			 }else{
				 sb.append("\n");
				 sb.append(words[j]);
				 length=words[j].length()+1;
			 }
		 }
		 for(int k=0;k<width-length-1-Items.get(i).centsToDollars(Items.get(i).getCost()).length();k++){
			 sb.append(" ");
		 }
		 sb.append(Items.get(i).centsToDollars(Items.get(i).getCost()));
		 sb.append("\n");
		 }
	}
		
		sb.append("\n");
		sb.append("Tax");
		for(int i=0;i<width-3-this.centsToDollars(this.totalTax()).length();i++){
			sb.append(" ");
		}
		sb.append(this.centsToDollars(this.totalTax()));
		sb.append("\n");
		sb.append("Total Cost");
		for(int i=0;i<width-10-this.centsToDollars(this.totalCost()).length();i++){
			sb.append(" ");
		}
		sb.append(this.centsToDollars(this.totalCost()+this.totalTax()));
		sb.append("\n");
		sb.append("\n");
		return sb.toString();
}
}
