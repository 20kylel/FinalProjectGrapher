import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Function {

	private String function;
	private ArrayList<Object> functarr;
	private HashMap<String, String> valid;
	private static String[][] precedence = {{"^", "*", "-"}, {"^", "/", "+"}, {"^","%","+"}};
	private Color color;
	
	public Function(String f, Color c){
		color = c;
		
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
			if(valid.get(f.substring(i, i+1))==null){
				return false;
			}
		}
		int parens = 0;
		for(int i=0; i<f.length(); i++){
			if(parens<0){
				return false;
			}
			if(f.substring(i, i+1).equals("(")){
				parens++;
			} else if(f.substring(i, i+1).equals(")")){
				parens--;
			}
		}
		return parens==0;
	}

	public double evaluate(double x){
		Stack stack = new Stack();
		Double answer = 0.0;
		for(int i = 0; i < function.length(); i++){
			if(function.charAt(i) == 'x' || function.charAt(i) == 'X'){
				stack.push(Double.toString(x));
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

	public static String toPostfix(String infixString) {
        String postfixString = " ";
        Stack stack = new Stack();

        for (int index = 0; index < infixString.length(); index++) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') {
                stack.push('(');
            } else if (chValue == ')') {
                Character oper = (Character) stack.peek();
                while (!(oper.equals('(')) && !(stack.isEmpty())) {
                    postfixString += oper.charValue();
                    stack.pop();
                    oper = (Character) stack.peek();
                }
                stack.pop();
            } else if (chValue == '+' || chValue == '-') {
                //Stack is empty
                if (stack.isEmpty()) {
                    stack.push(chValue);
                    //current Stack is not empty
                } else {
                    Character oper = (Character) stack.peek();
                    while (!(stack.isEmpty() || oper.equals(new Character('(')) || oper.equals(new Character(')')))) {
                        stack.pop();
                        postfixString += oper.charValue();
                    }
                    stack.push(chValue);
                }
            } else if (chValue == '*' || chValue == '/' || chValue=='%') {
                if (stack.isEmpty()) {
                    stack.push(chValue);
                } else {
                    Character oper = (Character) stack.peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && !stack.isEmpty()) {
                        stack.pop();
                        postfixString += oper.charValue();
                    }
                    stack.push(chValue);
                }
            } else if(chValue == '^'){
            	if (stack.isEmpty()) {
                    stack.push(chValue);
                } else {
                    Character oper = (Character) stack.peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) 
                    		&& !oper.equals(new Character('*')) &&
                    		!oper.equals(new Character('/')) &&
                    		!oper.equals(new Character('%')) &&
                    		!stack.isEmpty()) {
                        stack.pop();
                        postfixString += oper.charValue();
                    }
                    stack.push(chValue);
                }
            } else {
            	
                postfixString += chValue;
            }
        }
        while (!stack.isEmpty()) {
            Character oper = (Character) stack.peek();
            if (!oper.equals(new Character('('))) {
                stack.pop();
                postfixString += oper.charValue();
            }
        }
        return postfixString;
    }
	
	public Color getColor(){ return color; }
	private class Number{
		private int val;
		private String str;
		
		public Number(int value, String string){
			str= string;
			val = value;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
		
	}
}