package lab;

import java.net.*;
import java.io.*;
import java.lang.reflect.*;

public class Stack{

	// global array info to store the stack data
	public static int [] info = { 13, 55, 23, 24, 45, 35, 26, 67, 48 };
	//  global variable top
	public int top = 8;

	// global variable max
	public int max = 9;

	public static void main(String[] args) {
		
		// create an object of Stack 

		Stack stk = new Stack();

		int first_p = stk.pop();
		int the_p = stk.peek();

		stk.push(25);
		stk.push(48);

		System.out.println("The variable first_p contains "+ first_p);
		System.out.println("The variable the_p contains "+ the_p);
		System.out.println("The variable top contains "+ stk.top);
	}

	/** pop method to remove the last element from the stack **/

	public int pop(){

// for underflow case 
		if(top < 0)
			return -1;

// get the top element that will be popped out 
		int popped = info[top];
// place zero at the top which is removed now 
		info[top] = 0;
// decrement the top index value 
		top--;
// return the popped out element 
		return popped;

	}
/** method that adds an element into the stack **/
	public void push(int val){
// for overflow case 
		if(top < max){				
			info[top] = val;
			top++;
		}
	}
/** method that returns the top most element **/
	
	public int peek(){

		if(top < 0 || top >= max)
			return -1;

		return info[top];
	}
}