import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class BlockChain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 5;
	public static ArrayList<String> chainFile = new ArrayList<String>(); 

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		PersonAccount bitcoin = new PersonAccount("bitcoin");
		bitcoin.setBalance(50);
		PersonAccount satoshi = new PersonAccount("sathosi");
		blockchain.add(new Block(0, "00000", bitcoin, satoshi, 50));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		
		PersonAccount lucia = new PersonAccount("lucia");
		blockchain.add(new Block(1,blockchain.get(blockchain.size()-1).getHash(),satoshi, lucia, 25));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(blockchain.size()-1).mineBlock(difficulty);
	
		PersonAccount robert = new PersonAccount("robert");
		blockchain.add(new Block(2, blockchain.get(blockchain.size()-1).getHash(),satoshi, robert, 25));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(blockchain.size()-1).mineBlock(difficulty);	
		
		//System.out.println(satoshi.getBalance());
		//System.out.println(lucia.getBalance());
		//System.out.println(robert.getBalance());

		System.out.println("\nBlockchain is Valid: " + isChainValid());

		fromFile("bitcoinBank.txt");
	}
	
	public static ArrayList<Block> fromFile(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);
		int count = 0;
		ArrayList<Block> blockchainFile = new ArrayList<Block>();
		while(inputFile.hasNext()) {
			chainFile.add(inputFile.nextLine());
		}
		for(int i=0; i<chainFile.size()/7;i++) {
			if( i==0) {
				int index = Integer.parseInt(chainFile.get(count++));
				long timestamp = Long.parseLong(chainFile.get(count++));
				PersonAccount sender= new PersonAccount( chainFile.get(count++));
				PersonAccount receiver = new PersonAccount( chainFile.get(count++));
				int amount = Integer.parseInt(chainFile.get(count++));
				String nonce=chainFile.get(count++);
				String expected = chainFile.get(count++);
				blockchainFile.add(new Block(index,"00000", sender, receiver, amount, timestamp, nonce, expected));
			}else {
				int index = Integer.parseInt(chainFile.get(count++));
				long timestamp = Long.parseLong(chainFile.get(count++));
				PersonAccount sender= new PersonAccount( chainFile.get(count++));
				PersonAccount receiver = new PersonAccount( chainFile.get(count++));
				int amount = Integer.parseInt(chainFile.get(count++));
				String nonce=chainFile.get(count++);
				String expected = chainFile.get(count++);
				blockchainFile.add(new Block(index,blockchain.get(i).getHash(),sender, receiver, amount, timestamp, nonce, expected));
			}
			
		}
		
		inputFile.close();
		
		return blockchainFile;
		
	}

	public static Boolean isChainValid() throws UnsupportedEncodingException {

		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		

		//loop through blockchain to check hashes:

		for(int i=1; i < blockchain.size(); i++) {

			currentBlock = blockchain.get(i);

			previousBlock = blockchain.get(i-1);

			//compare registered hash and calculated hash:

			if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){

				System.out.println("Current Hashes not equal");			

				return false;

			}

			//compare previous hash and registered previous hash

			if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
				System.out.println("hash:" + previousBlock.getHash());
				System.out.println("Previoushash:" + currentBlock.getPreviousHash());
				System.out.println("Previous Hashes not equal");

				return false;

			}
			//check if hash is solved

			if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {

				System.out.println("This block hasn't been mined");

				return false;

			}

		}

		return true;

	}
}
