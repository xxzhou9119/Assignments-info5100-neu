import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

 class ATM {

//	- -  Create an **User** class with attributes *name*, *age*, *address*, *phoneNumber* and *bankAccountNumber*.
//	  - -  Create a **Atm** class with attributes *availableAmountInMachine*, *transactionFee* and *userData*.  
//	    *  *userData* should store **USER**, **PASSWORD**, and other account details internally in a dataStructure of your choice. 
//	    *  The constructor should initialize all the attributes.
//	  - -  The machine should be able to perform these actions.  
//	    *  Ask for **NEW USER** or **CURRENT USER** as the start.
//	    *  Create a **NEW USER** with a unique *bankAccountNumber* and *password*.
//	    *  **CURRENT USER** should be able to login using bankAccountNumber and password.
//	    *  **CURRENT USER** should be able to use *FORGOT PASSWORD*.
//	    *  *PASSWORD* can be resetted by validating the *name*, *age* and *phoneNumber* of the user.  
//	    *   After login the user should be able to use **availableBalance**, **withDrawal**, **deposit**, **recentTransactions**, **changePassword** and **exit**.  
//	    *    _recentTransaction_ should display the last 10 transactions, in a format of *transactionName* - *amount*. (*transactionName* is *withDrawal* or *deposit*).  
//	    *  Add a *transactionFee* for every transaction done and update the *availableAmountInMachine*.
//	    *  Machine should not allow user to withdrawal more amount than his *availableBalance*.
//	    *  You can add additional functions to make it pretty. UI is not required.
//
	double availableAmountInMachine;
	double transactionFee;
	HashMap<User,String> userData;
	
	Queue<String> recentTransactions;
	
	
	public ATM(double availableAmountInMachine, double transactionFee) {
		
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		this.userData = new HashMap<User,String>();
		this.recentTransactions=new LinkedList<String>();
	}
	
	boolean isCurrentUser(User user){
		if(this.userData.containsKey(user)){
			return true;
		}
		return false;
	}
	
	void createNewUser(User user,String bankAccountNumber,String password){
		if(!user.getBankAccountNumber().equals(bankAccountNumber)){
			System.out.println("The bankAccountNumber does not exist.");
		}else{
	      this.userData.put(user, password);
		}
	}
	
	boolean logIn(String bankAccountNumber,String password){
		for(User user:this.userData.keySet()){
			if(user.getBankAccountNumber().equals(bankAccountNumber) && this.userData.get(user).equals(password)){
				return true;
			}
		}
		return false;
	}
		
	void forgotPassword(User user,String newPassWord){
		if(isCurrentUser(user)){
			this.resetPassWord(user.getName(),user.getAge(),user.getPhoneNumber(),newPassWord);
		}
	}
	
	void resetPassWord(String name,int age,String phoneNumber,String newPassWord){
		for(User user:this.userData.keySet()){
			if(user.getName().equals(name) && user.getAge()==age && user.getPhoneNumber().equals(phoneNumber)){
				this.userData.put(user, newPassWord);
				return;
			}
		}
		System.out.println("Can't reset password!");
	}
	
	double withDrawal(double amount){
		if(availableAmountInMachine-this.transactionFee<amount){
			System.out.println("Your availableBalance is less than the amount you want to withdrawal! Your withDraw change to "+(availableAmountInMachine-this.transactionFee));
			amount=availableAmountInMachine-this.transactionFee;
		}
		availableAmountInMachine=availableAmountInMachine-amount-this.transactionFee;
		if(this.recentTransactions.size()==10){
			this.recentTransactions.poll();
		}
		this.recentTransactions.offer("withDrawal--"+amount);
		return availableAmountInMachine;
		
	}
	
      double deposit(double amount){
		availableAmountInMachine=availableAmountInMachine+amount-this.transactionFee;
		if(this.recentTransactions.size()==10){
			this.recentTransactions.poll();
		}
		this.recentTransactions.offer("deposit--"+amount);
		return availableAmountInMachine; 
	}
	String recentTransactions(){
		StringBuilder sb=new StringBuilder();
		while(!this.recentTransactions.isEmpty()){
			sb.append(this.recentTransactions.poll());
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	void changePassword(User user,String newPassWord){
		this.userData.put(user, newPassWord);
	}
	
	void exit(User user){
		System.exit(0);
		System.out.println("Thank you!");
	}
	
}
	

	
	
		
	
	
	
	
	


