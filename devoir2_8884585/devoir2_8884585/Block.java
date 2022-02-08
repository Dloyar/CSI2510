import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 
 * @author Rayold
 *Once a transaction has been validated, a block is
 * created and added to the end of the block chain.
 */
public class Block {
	 private int index;                // the index of the block in the list
	 private java.sql.Timestamp timestamp;  // time at which transaction 
	                                         // has been processed
	  private Transaction transaction;  // the transaction object
	  private int nonceInt;
	  private char a;
	  private String nonce;// random string (for proof of work)
	  private String previousHash;   // previous hash 
	  //(in first block, set to string of zeroes of size of complexity "00000")
	  private String hash;  // hash of the block (hash of string obtained 
	//from previous variables via toString() method)
	  
	  public Block(int index, String previousHash,PersonAccount sender, PersonAccount receiver, int amount) throws UnsupportedEncodingException {
			this.index= index;
			this.previousHash = previousHash;
			this.timestamp = new Timestamp(System.currentTimeMillis());
			this.hash=calculateHash();
			transaction = new Transaction(sender, receiver, amount);
		}
	  public Block(int index, String previousHash,PersonAccount sender, PersonAccount receiver, int amount,long timestamp,String nonce, String expected) throws UnsupportedEncodingException {
			this.index= index;
			this.previousHash = previousHash;
			this.timestamp = new Timestamp(timestamp);		
			this.nonce = nonce;
			this.transaction = new Transaction(sender, receiver, amount);
			this.hash=verifyHash();
		}
	  public String getHash() {
		  return hash;
	  }
	  public String getPreviousHash() {
		  return previousHash;
	  }
	  public int getNonce(){
		  return nonceInt;
	  }
	  
	  public String calculateHash() throws UnsupportedEncodingException {
			String calculatedhash = Sha1.hash(this.toString(), Sha1.OUT_HEXW);
			return calculatedhash;
		}
	  
	  public String verifyHash() throws UnsupportedEncodingException {
			String calculatedhash = Sha1.hash(this.toString1(), Sha1.OUT_HEXW);
			return calculatedhash;
		}
	  public void mineBlock(int difficulty) throws UnsupportedEncodingException {
			String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
			Random numberRandom = new Random();
			while(!hash.substring( 0, difficulty).equals(target)) {
				nonceInt ++; 

				hash = calculateHash();

			}

			System.out.println("Block Mined!!! : " + hash);
	  }
	  public String toString1() {
		   return timestamp.toString() + ":" + transaction.toString() 
		              + "." + nonce+ previousHash;
		  }
	  public String toString() {
		   return timestamp.toString() + ":" + transaction
		              + "." + nonceInt+ previousHash;
		  }
}