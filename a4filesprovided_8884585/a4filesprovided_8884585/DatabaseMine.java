import java.util.Hashtable;

public class DatabaseMine implements DatabaseInterface{
	int N;
	private java.util.Hashtable<String , String> hashtable;
	int collision;
	
	public DatabaseMine() {
		N =83459;
		collision = 0;
		hashtable = new Hashtable<String, String>(N) ;
	}
	
	public DatabaseMine(int N) {
		this.N = N;
		hashtable = new Hashtable<String, String>(this.N) ;
	}
	
	@Override
	public String save(String plainPassword, String encryptedPassword) {
		// TODO Auto-generated method stub
		String key = hash(encryptedPassword);
		hashtable.put(key,plainPassword);
		return key;
	}

	@Override
	public String decrypt(String encryptedPassword) {
		// TODO Auto-generated method stub
		if(hashtable.get(hash(encryptedPassword))==null) {
			return "";
		}
		else {
			return hashtable.get(hash(encryptedPassword));
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return hashtable.size();
	}
	public String hash(String key) {
		int a = hashFunction(key);
		if(hashtable.get(key)!=null) {
			a=(a+1)%N;
			collision++;
			hash(Integer.toString(a));
		}
		return Integer.toString(a);
	}
	public int hashFunction(String key) {
		 int address=key.hashCode()%N;
		 return (address>=0)?address:(address+N);
	}

	@Override
	public void printStatistics() {
		// TODO Auto-generated method stub
		System.out.println("*** DatabaseMine Statistics ***");
		System.out.println("Size is "+ size() +" passwords");
		System.out.println("Number of Indexes is  "+ N);
		System.out.println("Load Factor is "+ size()/(double)N);
		System.out.println("Number of displacements (due to collisions) "+ collision);
		System.out.println("*** End DatabaseMine Statistics ***");
	}


}
