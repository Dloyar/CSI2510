
public class PersonAccount {
	private String name;
	private int balance;
	
	public PersonAccount(String name) {
			this.name = name;
			balance = 0;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(int amount) {
		balance = amount;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public String getName() {
		return name;
	}
}
