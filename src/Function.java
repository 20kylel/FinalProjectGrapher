import java.util.HashMap;
import java.util.Stack;

public class Function {

	private String function;
	private HashMap<String, String> valid;
	private static String[][] precedence = {{"^", "*", "-"}, {"^", "/", "+"}, {"^","%","+"}};
	public Function(String f){
		valid = new HashMap<>();
		valid.put("+", "+");
		valid.put("-", "-");
		valid.put("*", "*");
		valid.put("/", "/");
		valid.put("^", "^");
		valid.put("%", "%");
		valid.put("x", "x");
		valid.put("X", "X");
		valid.put("(", "(");
		valid.put(")", ")");
		for(int i=0; i<10; i++){
			valid.put(Integer.toString(i), Integer.toString(i));
		}
		
		if(validFunction(f)){
			function = toPostfix(f);
		} else {
			System.out.println("Invalid function: " + f);
		}
		
	}

	private boolean validFunction(String f){
		for(int i=0; i<f.length(); i++){
			String s = f.substring(i, i+1);
			if(valid.get(s)==null){
				return false;
			}
		}
		return true;
	}

	public double evaluate(int x){
		Stack stack = new Stack();
		Double answer = 0.0;
		for(int i = 0; i < function.length(); i++){
			if(function.charAt(i) == 'x' || function.charAt(i) == 'X'){
				stack.push(Integer.toString(x));
			}else if(!isOperator(function.charAt(i))){
				stack.push(function.substring(i, i+1));
			}else if(function.charAt(i) == '*'){
				stack.push(Double.toString(Double.parseDouble((String) stack.pop())*Double.parseDouble((String) stack.pop())));
			}else if(function.charAt(i) == '%'){
				double temp = Double.parseDouble((String) stack.pop());
				stack.push(Double.toString(Double.parseDouble((String) stack.pop())%temp));
			}else if(function.charAt(i) == '/'){
				stack.push(Double.toString(1/Double.parseDouble((String) stack.pop())*Double.parseDouble((String) stack.pop())));
			}else if(function.charAt(i) == '+'){
				stack.push(Double.toString(Double.parseDouble((String) stack.pop())+Double.parseDouble((String) stack.pop())));
			}else if(function.charAt(i) == '-'){
				stack.push(Double.toString(-Double.parseDouble((String) stack.pop())+Double.parseDouble((String) stack.pop())));
			}else if(function.charAt(i) == '^'){
				double temp = Double.parseDouble((String) stack.pop());
				stack.push(Double.toString(Math.pow(Double.parseDouble((String)stack.pop()),temp)));
			}
		}
		return Double.parseDouble((String) stack.pop());
	}
	
	public String getFunction(){ return function; }

	private static boolean isOperator(char c)
	{
	    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
	            || c == '(' || c == ')' || c == '%';
	}

	private static boolean isLowerPrecedence(char op1, char op2)
	{
	    switch (op1)
	    {
	        case '+':
	        case '-':
	            return !(op2 == '+' || op2 == '-');

	        case '*':
	        case '/':
	            return op2 == '^' || op2 == '(';

	        case '^':
	            return op2 == '(';

	        case '(':
	            return true;

	        default:
	            return false;
	    }
	}

	public static String toPostfix(String infix)
	{
	    Stack<Character> stack = new Stack<Character>();
	    StringBuffer postfix = new StringBuffer(infix.length());
	    char c;

	    for (int i = 0; i < infix.length(); i++)
	    {
	        c = infix.charAt(i);

	        if (!isOperator(c))
	        {
	            postfix.append(c);
	        }

	        else
	        {
	            if (c == ')')
	            {

	                while (!stack.isEmpty() && stack.peek() != '(')
	                {
	                    postfix.append(stack.pop());
	                }
	                if (!stack.isEmpty())
	                {
	                    stack.pop();
	                }
	            }

	            else
	            {
	                if (!stack.isEmpty() && !isLowerPrecedence(c, stack.peek()))
	                {
	                    stack.push(c);
	                }
	                else
	                {
	                    while (!stack.isEmpty() && isLowerPrecedence(c, stack.peek()))
	                    {
	                        Character pop = stack.pop();
	                        if (c != '(')
	                        {
	                            postfix.append(pop);
	                        } else {
	                          c = pop;
	                        }
	                    }
	                    stack.push(c);
	                }

	            }
	        }
	    }
	    while (!stack.isEmpty()) {
	      postfix.append(stack.pop());
	    }
	    return postfix.toString();
	}
	
	public static void main(String[] args){
		Function f = new Function("2*X+1");
		System.out.println(f.evaluate(5));
	}
	
	
	
}