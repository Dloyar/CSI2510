import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

public class PasswordCracker {
	
	public PasswordCracker() {
		
	}
	
	@SuppressWarnings("static-access")
	void createDatabase(ArrayList<String> commonPasswords,
			 DatabaseInterface database) throws UnsupportedEncodingException {
		Iterator<String> itr = commonPasswords.iterator();
		while(itr.hasNext()) {
			Sha1 cryptCode = new Sha1();
			String passwords = itr.next();
			String encryptedPassword = cryptCode.hash(passwords); 
			database.save(passwords, encryptedPassword);
			
			//rule1
			if(Character.isLetter((passwords.charAt(0)))) {
				String passwordsRule1 = Character.toUpperCase(passwords.charAt(0))+ passwords.substring(1);
				
				encryptedPassword = cryptCode.hash(passwordsRule1); 
				database.save(passwordsRule1, encryptedPassword);	
			}
			
			//rule2
			String passwordsRule2 = passwords + "2018";
			encryptedPassword = cryptCode.hash(passwordsRule2);
			database.save(passwordsRule2, encryptedPassword);
			
			//rule3
			if(passwords.contains("a")) {	
				String passwordsRule3 = passwords.replace("a", "@");
				encryptedPassword = cryptCode.hash(passwordsRule3);
				database.save(passwordsRule3, encryptedPassword);
			}
			
			//rule4
			if(passwords.contains("e")) {
				String passwordsRule4 = passwords.replace("e", "3");
				encryptedPassword = cryptCode.hash(passwordsRule4);
				database.save(passwordsRule4, encryptedPassword);
			}
			
			//rule5
			if(passwords.contains("i")) {
				String passwordsRule5 = passwords.replace("i", "1");
				encryptedPassword = cryptCode.hash(passwordsRule5);
				database.save(passwordsRule5, encryptedPassword);
			}
			
			//combineRule1andRule2
			String passwordsRule1_2=passwords;
			if(Character.isLetter((passwords.charAt(0)))) {//rule1
				passwordsRule1_2 = Character.toUpperCase(passwords.charAt(0))+ passwords.substring(1);
			}
			passwordsRule1_2 = passwordsRule1_2 + "2018";//rule2
			encryptedPassword = cryptCode.hash(passwordsRule1_2);
			database.save(passwordsRule1_2, encryptedPassword);
			
			//combineRule1andRule3
			String passwordsRule1_3=passwords;
			if(Character.isLetter((passwords.charAt(0)))) {//rule1
				passwordsRule1_3 = Character.toUpperCase(passwords.charAt(0))+ passwords.substring(1);
			}
			if(passwordsRule1_3.contains("a")) {//rule3
				passwordsRule1_3 = passwordsRule1_3.replace("a", "@");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_3);
			database.save(passwordsRule1_3, encryptedPassword);
			
			//combineRule1andRule4
			String passwordsRule1_4=passwords;
			if(Character.isLetter((passwordsRule1_4.charAt(0)))) {//rule1
				passwordsRule1_4 = Character.toUpperCase(passwordsRule1_4.charAt(0))+ passwordsRule1_4.substring(1);
			}
			if(passwordsRule1_4.contains("e")) {//rule4
				passwordsRule1_4 = passwordsRule1_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_4);
			database.save(passwordsRule1_4, encryptedPassword);
			
			//combineRule1andRule5
			String passwordsRule1_5=passwords;
			if(Character.isLetter((passwordsRule1_5.charAt(0)))) {//rule1
				passwordsRule1_5= Character.toUpperCase(passwordsRule1_5.charAt(0))+ passwordsRule1_5.substring(1);
			}
			if(passwordsRule1_5.contains("i")) {//rule4
				passwordsRule1_5 = passwordsRule1_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_5);
			database.save(passwordsRule1_5, encryptedPassword);
			
			//combineRule2and3
			String passwordsRule2_3=passwords;
			passwordsRule2_3 = passwordsRule2_3 + "2018";//rule2
			if(passwordsRule2_3.contains("a")) {//rule3
				passwordsRule2_3 = passwordsRule2_3.replace("a", "@");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_3);
			database.save(passwordsRule2_3, encryptedPassword);
			
			//combineRule2and4
			String passwordsRule2_4=passwords;
			passwordsRule2_4 = passwordsRule2_4 + "2018";//rule2
			if(passwordsRule2_4.contains("e")) {//rule4
				passwordsRule2_4 = passwordsRule2_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_4);
			database.save(passwordsRule2_4, encryptedPassword);
			
			//combineRule2and5
			String passwordsRule2_5=passwords;
			passwordsRule2_5 = passwordsRule2_5 + "2018";//rule2
			if(passwordsRule2_5.contains("i")) {//rule5
				passwordsRule2_5 = passwordsRule2_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_4);
			database.save(passwordsRule2_4, encryptedPassword);
			
			//combineRule3and4
			String passwordsRule3_4=passwords;
			if(passwordsRule3_4.contains("a")) {//rule3
				passwordsRule3_4 = passwordsRule3_4.replace("a", "@");
			}
			if(passwordsRule3_4.contains("e")) {//rule4
				passwordsRule3_4 = passwordsRule3_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule3_4);
			database.save(passwordsRule3_4, encryptedPassword);
			
			//combineRule3and5
			String passwordsRule3_5=passwords;
			if(passwordsRule3_5.contains("a")) {//rule3
				passwordsRule3_5 = passwordsRule3_5.replace("a", "@");
			}
			if(passwordsRule3_5.contains("i")) {//rule5
				passwordsRule3_5 = passwordsRule3_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule3_5);
			database.save(passwordsRule3_5, encryptedPassword);
			
			//combineRule4and5
			String passwordsRule4_5 =passwords;
			if(passwordsRule4_5.contains("e")) {//rule4
				passwordsRule4_5 = passwordsRule4_5.replace("e", "3");
			}
			if(passwordsRule4_5.contains("i")) {//rule5
				passwordsRule4_5 = passwordsRule4_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule4_5);
			database.save(passwordsRule4_5, encryptedPassword);
			
			//combineRule1_2_3
			String passwordsRule1_2_3=passwords;
			if(Character.isLetter((passwordsRule1_2_3.charAt(0)))) {//rule1
				passwordsRule1_2_3 = Character.toUpperCase(passwordsRule1_2_3.charAt(0))+ passwordsRule1_2_3.substring(1);
			}
			passwordsRule1_2_3 = passwordsRule1_2_3 + "2018";//rule2
			if(passwordsRule1_2_3.contains("a")) {//rule3
				passwordsRule1_2_3 = passwordsRule1_2_3.replace("a", "@");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_2_3);
			database.save(passwordsRule1_2_3, encryptedPassword);
			
			//combineRule1_2_4
			String passwordsRule1_2_4=passwords;
			if(Character.isLetter((passwordsRule1_2_4.charAt(0)))) {//rule1
				passwordsRule1_2_4 = Character.toUpperCase(passwordsRule1_2_4.charAt(0))+ passwordsRule1_2_4.substring(1);
			}
			passwordsRule1_2_4 = passwordsRule1_2_4 + "2018";//rule2
			if(passwordsRule1_2_4.contains("e")) {//rule4
				passwordsRule1_2_4= passwordsRule1_2_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_2_4);
			database.save(passwordsRule1_2_4, encryptedPassword);
			
			//combineRule1_2_5
			String passwordsRule1_2_5=passwords;
			if(Character.isLetter((passwordsRule1_2_5.charAt(0)))) {//rule1
				passwordsRule1_2_5 = Character.toUpperCase(passwordsRule1_2_5.charAt(0))+ passwordsRule1_2_5.substring(1);
			}
			passwordsRule1_2_5 = passwordsRule1_2_5 + "2018";//rule2
			if(passwordsRule1_2_5.contains("i")) {//rule5
				passwordsRule1_2_5= passwordsRule1_2_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_2_5);
			database.save(passwordsRule1_2_5, encryptedPassword);
			
			//combineRule1_3_4
			String passwordsRule1_3_4=passwords;
			if(Character.isLetter((passwordsRule1_3_4.charAt(0)))) {//rule1
				passwordsRule1_3_4 = Character.toUpperCase(passwordsRule1_3_4.charAt(0))+ passwordsRule1_3_4.substring(1);
			}
			if(passwordsRule1_3_4.contains("a")) {//rule3
				passwordsRule1_3_4 = passwordsRule1_3_4.replace("a", "@");
			}
			if(passwordsRule1_3_4.contains("e")) {//rule4
				passwordsRule1_3_4= passwordsRule1_3_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_3_4);
			database.save(passwordsRule1_3_4, encryptedPassword);
			
			//combineRule1_3_5
			String passwordsRule1_3_5=passwords;
			if(Character.isLetter((passwordsRule1_3_5.charAt(0)))) {//rule1
				passwordsRule1_3_5 = Character.toUpperCase(passwordsRule1_3_5.charAt(0))+ passwordsRule1_3_5.substring(1);
			}
			if(passwordsRule1_3_5.contains("a")) {//rule3
				passwordsRule1_3_5 = passwordsRule1_3_5.replace("a", "@");
			}
			if(passwordsRule1_3_5.contains("i")) {//rule5
				passwordsRule1_3_5= passwordsRule1_3_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_3_5);
			database.save(passwordsRule1_3_5, encryptedPassword);
			
			//combineRule1_4_5
			String passwordsRule1_4_5=passwords;
			if(Character.isLetter((passwordsRule1_4_5.charAt(0)))) {//rule1
				passwordsRule1_4_5 = Character.toUpperCase(passwordsRule1_4_5.charAt(0))+ passwordsRule1_4_5.substring(1);
			}
			if(passwordsRule1_4_5.contains("e")) {//rule4
				passwordsRule1_4_5 = passwordsRule1_4_5.replace("e", "3");
			}
			if(passwordsRule1_4_5.contains("i")) {//rule5
				passwordsRule1_4_5= passwordsRule1_4_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_4_5);
			database.save(passwordsRule1_4_5, encryptedPassword);
			
			//combineRule2_3_4
			String passwordsRule2_3_4=passwords;
			passwordsRule2_3_4 = passwordsRule2_3_4 + "2018";//rule2
			if(passwordsRule2_3_4.contains("a")) {//rule3
				passwordsRule2_3_4 = passwordsRule2_3_4.replace("a", "@");
			}
			if(passwordsRule2_3_4.contains("e")) {//rule4
				passwordsRule2_3_4= passwordsRule2_3_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_3_4);
			database.save(passwordsRule2_3_4, encryptedPassword);
			
			
			//combineRule2_3_5
			String passwordsRule2_3_5=passwords;
			passwordsRule2_3_5 = passwordsRule2_3_5 + "2018";//rule2
			if(passwordsRule2_3_5.contains("a")) {//rule3
				passwordsRule2_3_5= passwordsRule2_3_5.replace("a", "@");
			}
			if(passwordsRule2_3_5.contains("i")) {//rule5
				passwordsRule2_3_5= passwordsRule2_3_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_3_5);
			database.save(passwordsRule2_3_5, encryptedPassword);
			
			//combineRule2_4_5
			String passwordsRule2_4_5=passwords;
			passwordsRule2_4_5 = passwordsRule2_4_5 + "2018";//rule2
			if(passwordsRule2_3_4.contains("e")) {//rule4
				passwordsRule2_3_4= passwordsRule2_3_4.replace("e", "3");
			}
			if(passwordsRule2_4_5.contains("i")) {//rule5
				passwordsRule2_4_5= passwordsRule2_4_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule2_4_5);
			database.save(passwordsRule2_4_5, encryptedPassword);
			
			
			//combineRule1_2_3_4
			String passwordsRule1_2_3_4=passwords;
			if(Character.isLetter((passwordsRule1_2_3_4.charAt(0)))) {//rule1
				passwordsRule1_2_3_4= Character.toUpperCase(passwordsRule1_2_3_4.charAt(0))+ passwordsRule1_2_3_4.substring(1);
			}
			passwordsRule1_2_3_4= passwordsRule1_2_3_4 + "2018";//rule2
			if(passwordsRule1_2_3_4.contains("a")) {//rule3
				passwordsRule1_2_3_4 = passwordsRule1_2_3_4.replace("a", "@");
			}
			if(passwordsRule1_2_3_4.contains("e")) {//rule4
				passwordsRule1_2_3_4 = passwordsRule1_2_3_4.replace("e", "3");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_2_3_4);
			database.save(passwordsRule1_2_3_4, encryptedPassword);
			
			//combineRule1_2_3_5
			String passwordsRule1_2_3_5=passwords;
			if(Character.isLetter((passwordsRule1_2_3_5.charAt(0)))) {//rule1
				passwordsRule1_2_3_5= Character.toUpperCase(passwordsRule1_2_3_5.charAt(0))+ passwordsRule1_2_3_5.substring(1);
			}
			passwordsRule1_2_3_5= passwordsRule1_2_3_5 + "2018";//rule2
			if(passwordsRule1_2_3_5.contains("a")) {//rule3
				passwordsRule1_2_3_5 = passwordsRule1_2_3_5.replace("a", "@");
			}
			if(passwordsRule1_2_3_5.contains("i")) {//rule5
				passwordsRule1_2_3_5 = passwordsRule1_2_3_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_2_3_5);
			database.save(passwordsRule1_2_3_5, encryptedPassword);
			
			//combineRule1_3_4_5
			String passwordsRule1_3_4_5=passwords;
			if(Character.isLetter((passwordsRule1_3_4_5.charAt(0)))) {//rule1
				passwordsRule1_3_4_5= Character.toUpperCase(passwordsRule1_3_4_5.charAt(0))+ passwordsRule1_3_4_5.substring(1);
			}
			if(passwordsRule1_3_4_5.contains("a")) {//rule3
				passwordsRule1_3_4_5 = passwordsRule1_3_4_5.replace("a", "@");
			}
			if(passwordsRule1_3_4_5.contains("e")) {//rule4
				passwordsRule1_3_4_5 = passwordsRule1_3_4_5.replace("e", "3");
			}
			if(passwordsRule1_3_4_5.contains("i")) {//rule5
				passwordsRule1_3_4_5 = passwordsRule1_3_4_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwordsRule1_3_4_5);
			database.save(passwordsRule1_3_4_5, encryptedPassword);
			
			//combineRule2_3_4_5
			String passwordsRule2_3_4_5 = passwords;
			passwordsRule2_3_4_5= passwordsRule2_3_4_5 + "2018";//rule2
			if(passwordsRule2_3_4_5.contains("a")) {//rule3
				passwordsRule2_3_4_5= passwordsRule2_3_4_5.replace("a", "@");
			}
			if(passwordsRule2_3_4_5.contains("e")) {//rule4
				passwordsRule2_3_4_5 = passwordsRule2_3_4_5.replace("e", "3");
			}
			if(	passwordsRule2_3_4_5.contains("i")) {//rule5
				passwordsRule2_3_4_5 = 	passwordsRule2_3_4_5.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(	passwordsRule2_3_4_5);
			database.save(	passwordsRule2_3_4_5, encryptedPassword);
			
			
			//combineAlltheRule
			if(Character.isLetter((passwords.charAt(0)))) {//rule1
				passwords = Character.toUpperCase(passwords.charAt(0))+ passwords.substring(1);
			}
			passwords = passwords + "2018";//rule2
			if(passwords.contains("a")) {//rule3
				passwords = passwords.replace("a", "@");
			}
			if(passwords.contains("e")) {//rule4
				passwords = passwords.replace("e", "3");
			}
			if(passwords.contains("i")) {//rule5
				passwords = passwords.replace("i", "1");
			}
			encryptedPassword = cryptCode.hash(passwords);
			database.save(passwords, encryptedPassword);
		}
	}
	
	String crackPassword(String encryptedPassword,
			 DatabaseInterface database) {
		return database.decrypt(encryptedPassword);
	}

}
