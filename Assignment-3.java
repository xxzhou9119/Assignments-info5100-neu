
import java.util.Arrays;

public class Assignment3 {
	
	/* No.1
	error :
	 public setName(String name){
	return name;
	 }
	
	 Should be:
	    public void setName(String name){
	         this.name = name;
	 }
	  This code mismatches the Setters'method format with the Getter's method format.And also, we must put 'void'
	  before the Setter's name since "setName" is a behavior and returns nothing.
	  
	  One more thing, I think these two constructors have some error:
	     public Book(int size){
              this.size = size;
         }
          public Book(int price){
              this.price = price;
         }
        The type of parameters within two constructors of one Class should not be the same.
         
         
	 No.2
	 error:
	void getTime(){
        return time;
}
	 void setTime(String t){
            time = t ;
	 
	 Should be:
	    public String getTime(){
            return time;
}
	   public void setTime(String t){
            this.time = t ;
	  }  
     We must put "public" at the front of the Setter and Getter.The type before the  name must match the return type.Since the return type 
     in the Getter is "String", the type before the Getter's name should be "String", not "void". 
	*/
	
	//No.3:
	public static String removeVowelsFromString(String input) {
		String stringWithoutVowels = "";
		for (int i = 0; i < input.length(); i++) {
			if (!isVowel(input.charAt(i))) {
				stringWithoutVowels = stringWithoutVowels + input.charAt(i);
			}
		}
		return stringWithoutVowels;
	}

	public static boolean isVowel(char c) {
		String vowels = "aeiouAEIOU";
		for (int i = 0; i < vowels.length(); i++) {
			if (c == vowels.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	// No.4:
	public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2) {
		// If the lengths of two strings are not same, they can't be Anagrams.
		if (s1.length() != s2.length()) {
			return false;
		}
		if(s1.equals(s2)){
			return false;
		}
		
		// Convert two strings to new character arrays respectively and then
		// sort them.
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		// Compare each character.
		int i = 0;
		for (int j = 0; j < c2.length; j++) {
			if (c1[i] != c2[j]) {
				return false;
			}
			i++;
		}

		return true;
	}
	
	//No.5:
	public class Calculator {
			
		public  double Addition(double a,double b){
			double result=a+b;
			System.out.println(result);
			return result;
		}

		public  double subtraction(double a,double b){
			double result=a-b;
			System.out.println(result);
			return result;
		}

		public double multiplication(double a,double b){
			double result=a*b;
			System.out.println(result);
			return result;
		}
		public double division(double a,double b){
			double result=a/b;
			System.out.println(result);
			return result;
		}
		public double squareRoot(double a){
			double result=Math.sqrt(a);
			System.out.println(result);
			return result;
		}

		public double square(double a){
			double result=a*a;
			System.out.println(result);
			return result;
		}
		public double cube(double a){
			double result=a*a*a;
			System.out.println(result);
			return result;
		}
		public double convertFtoC(double F){
			double C=(F-32)*5/9;
			System.out.println(F+"℉ = "+C+"℃.");
			return C;
		}
		public double convertCtoF(double C){
			double F=C*9/5+32;
			System.out.println(C+"℃ = "+F+"℉.");
			return F;
		}

		public double converFeetToInches(double feet){
			double inch=feet*12;
			System.out.println(feet+"feet"+"="+inch+"Inches.");
		    return inch;
		}

		public double[] solutionToQuadraticEquation(double a,double b,double c){
			if(a==0){
				double[] result=new double[1];
				result[0]=-b/c;
				System.out.println("The solution is: "+result[0]);
				return result;
				
			}
			
			double m=b*b-4*a*c;
			if(m<0){
			double[] result={};
			System.out.println("There is no solution to this quadraticEquation.");
			return result;
			}
			if(m==0){
				double[] result=new double[1];
				result[0]=(-b+Math.sqrt(m)/2*a);
				System.out.println("There is only one solution to this quadraticEquation.");
				System.out.println("The solution is: "+result);
				return result;
			}
			
			double[] result=new double[2];
			result[0]=(-b+Math.sqrt(m))/2*a;
			result[1]=(-b-Math.sqrt(m))/2*a;
			System.out.println("There are two solutions to this quadraticEquation.");
			System.out.println("The solutions are: "+result[0]+" and "+result[1]);
			return result;	
			
			}

		}

	
}
