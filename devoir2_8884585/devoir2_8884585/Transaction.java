import java.io.UnsupportedEncodingException;
import java.security.*;

import java.util.ArrayList;
/**
 * 
 * @author Rayold
 * This class transaction is simply one person giving a certain 
 * amount of bitcoins to another person.
 */

public class Transaction {
	private String sender;//the person giving money
	private String receiver;//person receiving the money
	private int amount;//the number of bitcoins involved in the transaction
	
	private PersonAccount sendMoney;
	private PersonAccount receiveMoney;
	
	public Transaction(PersonAccount sendMoney, PersonAccount receiveMoney, int amount) {
		
		this.sendMoney = sendMoney;
		this.receiveMoney = receiveMoney;
		this.sender = sendMoney.getName();
		this.receiver = receiveMoney.getName();
		this.amount = amount;
		transactionProcess();
	}
	public void transactionProcess() {
		this.sendMoney.withdraw(amount);
		this.receiveMoney.deposit(amount);
	}
	public String getReceiver() {
		return receiver;
	}
	public String getSender(){
		return sender;
	}
	public int getAmount() {
		return amount;
	}

	public String toString() {
		return sender + ":" + receiver + "=" + amount;
	}

}
