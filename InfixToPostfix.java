
import java.util.Stack; // for using Stack class 
import java.util.Scanner; // for using Scanner class to read inputs 

public class InfixToPostfix {  

/** A method that takes a String as a expression and 
 * validates the expression to check wether the given 
 * expression is fully paranthesized or not. */

	public static boolean hasError(String line){

		StringSplitter data = new StringSplitter(line);
        Stack<String> symbols = new Stack<String>();
   
        boolean error = false;
     
        while (!error && data.hasNext()) {
    
            String next = data.next();
            if (next.equals(")")) {

                if (symbols.size() < 2 || symbols.peek().equals("(")) {
                    error = true;
                } 

                else{

                    String operator = symbols.pop();

                    if (!symbols.peek().equals("(")) {
                        error = true;
                    }
                    
                    else{
                    	//  to remove the "("
                    	symbols.pop();
                    }
                }
            } 

            else if ("(+-*/^".indexOf(next) != -1) {
                symbols.push(next);
            }
        }

        if(error || !symbols.isEmpty())
			return true;

		return false; 

	}

		// main driver method 
	public static void main(String []args){  

		System.out.println("This program evaluates postfix fully");
        System.out.println("parenthesized infix expressions with the");
        System.out.println("operators +, -, *, +, and ^");
        System.out.println();
        // create an Scanner class object to read user input 
        Scanner console = new Scanner(System.in);
        // prompt the user to enter an infix expression 
        System.out.print("Infix expression (return to quit)? ");
        String line = console.nextLine().trim();

        while (line.length() > 0) {
        	   // print the returned expression to the user 
			System.out.println("Required Postfix expression: " + getPostfixExpr(line));
			System.out.print("Infix expression (return to quit)? ");
            line = console.nextLine().trim();
         			
        }
	
	} 

	/** A static method that takes an infix expression and returns 
	 * the valid postfix expression if no error encounters */

	public static String getPostfixExpr(String line) { 

		// checks whether the expression is fully paranthesized 
		boolean error = hasError(line);

		// if expression contains error, then return the string
		if(error)
			return "Illegal expression!";

		char symbol; // for each symbol of the expression
		StringSplitter infixExpr = new StringSplitter(line);
		String postfixExpr = ""; // for storing the post-fix expression 
		// create an static object of Stack class to store the operators 
		Stack<Character> operators = new Stack<>();

	/* loop to iterate each character of the expression */
		while(infixExpr.hasNext()){ 
		// read the first characters 
			symbol = infixExpr.next().charAt(0);    
		/* If the character is letter then add that one to the postfixExpr */
			if (Character.isLetter(symbol))  
				postfixExpr += symbol;
		/** else if character is digit then subtract 48 to get the desired digit in 
		 * ASCII code. */
		
			else if(Character.isDigit(symbol))
				postfixExpr += (symbol - 48);
			
 		/* Push the symbol to the stack for right paranthesis */
			else if(symbol=='(')  
				operators.push(symbol);

			else if (symbol==')'){ 
				/** Keep popping out the operators from the stack and 
				 * add them to the postfix expression until a right 
				 * paranthesis is found */
				while (operators.peek() != '(') {  
					postfixExpr += operators.pop();  
				} 

				/* pop out '(' */
				operators.pop();        //remove '('  
			}
		/* if none of above cases satisfies */ 
			else {

				/** if stack is empty then no need to check anything,
				 *  simply push the symbol to the stack */

				if(operators.isEmpty())
					operators.push(symbol);
			
				else{
				/* if top of the stack is '(' then simply push the symbol into the stack */
					if(operators.peek() == '(')
						operators.push(symbol);
				/** when precedence of incoming symbol is less than or
				 * equal to the precendence of operator at the stack top */
					else if(prec(symbol) <= prec(operators.peek())){

						/* if the precedence incoming symbol and stack's top symbol are equal, then 
						check for associativity. For left to right associative operator, just push the
						symbol in the stack. */ 
						if(prec(symbol) == prec(operators.peek()) && symbol == '^')
							operators.push(symbol);	
						
						else{
							/** otherwise, keep popping out the symbol from the stack and add the 
							 * popped to the postfix expression until the precedence of incoming
							 * symbol is less than the stack top. */
							while(!operators.isEmpty()){

								if(prec(symbol) <= prec(operators.peek()))
									postfixExpr += operators.pop();
								else
									break;
							}
							/* Now, push the incoming symbol in the stack as it's precedence is 
							greater than the stack top or stack is empty */
							operators.push(symbol);	
						}
									
					}
					/* for the case, when the incoming symbol precedence is greater than stack top */
					else
						operators.push(symbol);
				}
			}
 
		} 
		/** After reading all symbols, if any symbols left in the stack the pop out them
		 * from stack and to the postfix expression */
		while (!operators.isEmpty())  
			postfixExpr += operators.pop();  

		/* return the expression */
		return postfixExpr; 
		
	} 

	/* Static method that returns the precedence of the operator */
	private static int prec(char x){ 

		if (x == '+' || x == '-')  
			return 1;  
		if (x == '*' || x == '/' || x == '%')  
			return 2;
		if(x == '^')
			return 3;  
		return 0;  
	}  
}  