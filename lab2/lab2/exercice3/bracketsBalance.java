package exercice3;
/*  CSI2114 Lab 3 - lab3.java
 *
 *  Class to check balanced brackets in math expressions
 *
 *  Usage: java bracketsBalance <exp>
 *
 *  by Jeff Souza
 *
 */

class bracketsBalance {

	private boolean bBalance( String exp ) {
		ArrayStack s = new ArrayStack();
		
		for(int i = 0; i< exp.length();i++) {
			char currentChar = exp.charAt(i);
			if(currentChar == '(' || currentChar == '{' 
					||currentChar == '['  ) {
				s.push(currentChar);
				
				
			}else if(currentChar == ')') {
				
				char p = (char) s.pop();
				if(p != '(') {
					return false;
				}
			}else if(currentChar == '}') {
			char p = (char) s.pop();
			if(p != '{')
				return false;
			}else if(currentChar == ']') {
				char p = (char) s.pop();
				if(p != '[')
					return false;
		
	}
		}
		
		return false;
	} /* bBalance */


	public static void main( String [] args ) {

		bracketsBalance    b      = new bracketsBalance();
		boolean            result = b.bBalance ("()" );

		if( result ) System.out.println ( "The expression is balanced." );
		else System.out.println ( "The expression is NOT balanced." );
	} /* main */


}
