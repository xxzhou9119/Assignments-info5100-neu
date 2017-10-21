import org.junit.Assert;
import org.junit.Test;
public class ATMTest {
	@Test
	public void testIsCurrentUser() {
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		User input=user;
		boolean expectedOutput=false;
		boolean output=atm.isCurrentUser(input);
		Assert.assertEquals(expectedOutput, output);
		
		atm.createNewUser(user, "0001", "12345");
		expectedOutput=true;
		output=atm.isCurrentUser(user);
		Assert.assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testCreateNewUser(){
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		atm.createNewUser(user, "0001", "12345");
		String expectedOutput="12345";
		String output=atm.userData.get(user);
		Assert.assertEquals(expectedOutput, output);
	}
	
	
	@Test
	public void testLogIn(){
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		atm.createNewUser(user, "0001", "123456");
		boolean expectedOutput=true;
		boolean output=atm.logIn("0001","123456");
		Assert.assertEquals(expectedOutput, output);
		
		expectedOutput=false;
	     output=atm.logIn("0001","12456");
    	Assert.assertEquals(expectedOutput, output);
		
    	expectedOutput=false;
		output=atm.logIn("0002","123456");
		Assert.assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testForgotPassword(){
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		atm.createNewUser(user, "0001","12345");
		atm.forgotPassword(user, "23456");
		String expectedOutput="23456";
		String output=atm.userData.get(user);
		Assert.assertEquals(expectedOutput, output);
		
	}
	
	@Test
	public void testResetPassWord(){
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		atm.createNewUser(user, "0001","12345");
		atm.resetPassWord("A", 20, "123", "23456");
		String expectedOutput="23456";
		String output=atm.userData.get(user);
		Assert.assertEquals(expectedOutput, output);
		
		atm.resetPassWord("A", 20, "234", "34567");
		expectedOutput="23456";
		output=atm.userData.get(user);
		Assert.assertEquals(expectedOutput, output);	
	}
	
	
	
	@Test
	public void testWithDrawal(){
		ATM atm=new ATM(100,1);
		Double expectedOutput=89.0;
		Double output=atm.withDrawal(10);
		Assert.assertEquals(expectedOutput, output);
		
	    expectedOutput=0.0;
	    output=atm.withDrawal(100);
	    Assert.assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testDeposit(){
		ATM atm=new ATM(100,1);
		Double expectedOutput=109.0;
		Double output=atm.deposit(10);
		Assert.assertEquals(expectedOutput, output);
		
	}
	
	@Test
	public void testRecentTransactions(){
		ATM atm=new ATM(100,1);
		atm.withDrawal(101);
		atm.deposit(10);
		String expectedOutput="withDrawal--99.0"+"\n"+"deposit--10.0"+"\n";
		String output=atm.recentTransactions();
		Assert.assertEquals(expectedOutput, output);
		
		
		atm.withDrawal(10);
		atm.deposit(15);
		atm.deposit(5);
		atm.withDrawal(10);
		atm.withDrawal(10);
		atm.deposit(10);
		atm.withDrawal(10);
		atm.deposit(15);
		atm.deposit(10);
		atm.withDrawal(10);
		atm.deposit(5);
		expectedOutput="deposit--15.0"+"\n"+"deposit--5.0"+"\n"+"withDrawal--10.0"+"\n"+"withDrawal--6.0"+"\n"+"deposit--10.0"+"\n"+"withDrawal--8.0"+"\n"+"deposit--15.0"+"\n"+"deposit--10.0"+"\n"+"withDrawal--10.0"+"\n"+"deposit--5.0"+"\n";
	     output=atm.recentTransactions();
	    Assert.assertEquals(expectedOutput, output);
	
	}
	
	@Test
	public void testChangePassword(){
		ATM atm=new ATM(10000,1);
		User user=new User("A",20,"401 Terry Ave N","123","0001");
		atm.createNewUser(user, "0001","12345");
		atm.changePassword(user, "23456");
		String expectedOutput="23456";
		String output=atm.userData.get(user);
		Assert.assertEquals(expectedOutput, output);
	}
	
	
}
