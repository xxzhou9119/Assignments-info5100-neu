
public class IntToRoman {
	public static void main(String[] args) {
		int a=399;
		String b=intToRoman(a);
		System.out.println(b);
		
	}
	 public static String intToRoman(int num) {
		 String roman="";
		 String[] M={"", "M", "MM", "MMM"};
		 String[] C= {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		 String[] X= {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		 String[] I= {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		 
		 int m=num/1000;
		 int c=num%1000/100;
		 int x=num%100/10;
		 int i=num%10;
		 roman=M[m]+C[c]+X[x]+I[i];
		 return roman;
     }
}
