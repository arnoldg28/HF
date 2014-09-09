public class BankAccount{

	private int balance = 100;
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	public int getBalance(){
		return this.balance;
	}
	
	public void withdraw(int amount){
		balance = balance - amount;
	}

}