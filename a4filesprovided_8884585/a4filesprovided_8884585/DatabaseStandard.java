import java.util.HashMap;

public class DatabaseStandard implements DatabaseInterface{
	
	private java.util.HashMap<String , String> hashmap;
	
	public DatabaseStandard () {
		hashmap = new HashMap<String, String>() ;
	}
	

	@Override
	public String save(String plainPassword, String encryptedPassword) {
		// TODO Auto-generated method stub
		String previousValue = hashmap.get(encryptedPassword);
		if(previousValue != null) {
			hashmap.remove(encryptedPassword);
		}
		hashmap.put(encryptedPassword, plainPassword);
		return previousValue;
	}

	@Override
	public String decrypt(String encryptedPassword) {
		// TODO Auto-generated method stub
		if(hashmap.get(encryptedPassword)==null) {
			return "";
		}
		else {
			return hashmap.get(encryptedPassword);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return hashmap.size();
	}

	@Override
	public void printStatistics() {
		// TODO Auto-generated method stub
		System.out.println("*** DatabaseStandard Statistics ***");
		System.out.println("Size is "+ size() +" passwords");
		System.out.println("*** End DatabaseStandard Statistics ***");
	}


}
