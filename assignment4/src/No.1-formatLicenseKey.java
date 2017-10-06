//No.1:
public class formatLicenseKey {
	public static void main(String[] args) {
		String a="-A-A-A-a--";
		String b= LicenseKeyFormatting(a,2);
		System.out.println(b);
	}
	
	public static String LicenseKeyFormatting(String s,int k){
		String format="";
		int count=0;
		for(int i=s.length()-1;i>=0;i--){
			char c=s.charAt(i);
			if(c=='-') continue;
			if(c>='a'&&c<='z'){
				c=(char)(c-32);
			}
			format=c+format;
			count++;
			if(count==k&&i!=0){
				format='-'+format;
				count=0;
			}
		}
		// for edge case that 's' begins with '-':
		if(format.length()!=0){
	         if(format.charAt(0)=='-'){
	            String newFormat="";
	            for(int i=1;i<format.length();i++){
	                newFormat=newFormat+format.charAt(i);
	               
	            } 
	            return newFormat;
	          }
	        }
		return format;
	}

}
