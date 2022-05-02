import java.util.*;
import java.util.Stack;


public class BalancedBrackets {

	static boolean isBracketBalanced(String expression) {
		
		Stack<Character> bracketStack = new Stack<Character>();
		
		//check for the corresponding bracket 
		// current element ) --> Top element should be ( 
		// current element } --> Top element should be {
		// current element ] --> Top element should be [
		
		for(char bracket : expression.toCharArray()) {
			switch(bracket)
			{
			case ')' :
				if(bracketStack.isEmpty() || bracketStack.peek() != '(')
					return false;
				else
					bracketStack.pop();
				break;
			case '}':
				if(bracketStack.isEmpty() || bracketStack.peek() != '{')
					return false;
				else
					bracketStack.pop();
				break;
			case ']':
				if(bracketStack.isEmpty() || bracketStack.peek() != '[')
					return false;
				else
					bracketStack.pop();
				break;
			default:
				bracketStack.push(bracket);
					
			}
		}
		return bracketStack.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string");
		Scanner in = new Scanner(System.in);
		
		//take the user input
		String str = in.nextLine();
		
		
		System.out.println(isBracketBalanced(str)? "The entered Strings contain Balanced Brackets" : "The entered Strings do not contain Balanced Brackets");
		in.close();
	}

}
