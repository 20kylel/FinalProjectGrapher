import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Function {

	private String function;
	public ArrayList<Object> postfix;
	private HashMap<String, String> valid;
	private static String[][] precedence = {{"^", "*", "-"}, {"^", "/", "+"}, {"^","%","+"}};
	private Color color;
	
	public Function(String f, Color c){
		color = c;
		postfix = new ArrayList<>();
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
			toPostfix(f);
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
		for(int i = 0; i < postfix.size(); i++){
			if(postfix.get(i) instanceof Number){
				stack.push(postfix.get(i).toString());
			}else if(((Character) postfix.get(i)) == 'x' || ((Character) postfix.get(i))== 'X'){
				stack.push(Double.toString(x));
			}else{	
				Double first = Double.parseDouble((String) stack.pop());
				Double second = Double.parseDouble((String) stack.pop());
				if(((Character) postfix.get(i)).charValue() == '*'){
					stack.push(Double.toString(first*second));
					
				}else if(((Character) postfix.get(i)).charValue() == '%'){
					stack.push(Double.toString(second%first));		
					
				}else if(((Character) postfix.get(i)).charValue() == '+'){
					stack.push(Double.toString(first + second));
					
				}else if(((Character) postfix.get(i)).charValue() == '-'){
					stack.push(Double.toString(second - first));
					
				}else if(((Character) postfix.get(i)).charValue() == '^'){
					stack.push(Double.toString(Math.pow(second, first)));
					
				}else if(((Character) postfix.get(i)).charValue() == '/'){
					stack.push(Double.toString(second/first));
					
				}
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

	public void toPostfix(String infixString) {
        Stack stack = new Stack();
        for (int index = 0; index < infixString.length(); index++) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') {
                stack.push('(');
            }else if(!isOperator(chValue) && chValue != 'x' && chValue != 'X'){
            	if(postfix.size() != 0 && (!isOperator(infixString.charAt(index-1)) || (infixString.charAt(index-1) == '-')) && Character.toLowerCase(infixString.charAt(index-1)) != 'x'){
            		if(infixString.charAt(index-1) == '-'){
            			if(postfix.get(postfix.size()-1)instanceof Number && ((Number) postfix.get(postfix.size()-1)).getStr() == "-"  ){
							Number num = (Number) postfix.get(postfix.size() - 1);
							num.setStr(num.getStr() + chValue);
						}else{
            				postfix.add(new Number(""+chValue));
						}
					}else
					{
						Number num = (Number) postfix.get(postfix.size() - 1);
						num.setStr(num.getStr() + chValue);
					}
            	}else{
            		postfix.add(new Number(""+chValue));
            		
            	}
            }else if (chValue == ')') {
                Character oper = (Character) stack.peek();
                while (!(oper.charValue()=='(') && !(stack.isEmpty())) {
                	
                    postfix.add(oper.charValue());
                    
                    stack.pop();
                    if(!(stack.isEmpty())){
                    	oper = (Character) stack.peek();
                    } 
                }if(!(stack.isEmpty())){
                	stack.pop();
                }
            } else if (chValue == '+' || chValue == '-'){
                //Stack is empty
            	if(postfix.size() != 0 && (isOperator(infixString.charAt(index-1))   &&  infixString.charAt(index-1)!=')') && chValue == '-'){
            		postfix.add(new Number("-"));
            	}else if(postfix.size() == 0){
            		postfix.add(new Number("-"));
            	}
            	else{
            		if (stack.isEmpty()) {
            			stack.push(chValue);
            			//current Stack is not empty
            		} else {
            			Character oper = (Character) stack.peek();
            			while (!(stack.isEmpty() || oper.equals(new Character('(')) || oper.equals(new Character(')')))) {
            				stack.pop();
                            postfix.add(oper.charValue());
                            if(!stack.isEmpty()){
                            	oper = (Character) stack.peek();
                            }
            			}
            			stack.push(chValue);
            		}
            	}
            } else if (chValue == '*' || chValue == '/' || chValue=='%') {
                if (stack.isEmpty()) {
                    stack.push(chValue);
                } else {
                    Character oper = (Character) stack.peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && !stack.isEmpty() && oper!= '(') {
                        stack.pop();
                        postfix.add(oper.charValue());
                        if(!stack.isEmpty()){
                        	oper = (Character) stack.peek();
                        }
                    }
                    stack.push(chValue);
                }
            } else if(chValue == '^'){
            	if (stack.isEmpty()) {
                    stack.push(chValue);
                } else {
                    Character oper = (Character) stack.peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && oper!= '('
                    		&& !oper.equals(new Character('*')) &&
                    		!oper.equals(new Character('/')) &&
                    		!oper.equals(new Character('%')) &&
                    		!stack.isEmpty()) {
                    	stack.pop();
                        postfix.add(oper.charValue());
                        if(!stack.isEmpty()){
                        	oper = (Character) stack.peek();
                        }
                    }
                    stack.push(chValue);
                }
            }else if(chValue == 'x' || chValue == 'X'){
            	postfix.add(chValue);
            	
            }
        }
        while (!stack.isEmpty()) {
            Character oper = (Character) stack.peek();
            if (!oper.equals(new Character('('))) {
                stack.pop();
                postfix.add(oper.charValue());
            }
        }
    }
	
	
	public Color getColor(){ return color; }
	
	public static void main(String[] args){
		Function f = new Function("x^-2", Color.BLACK);
		System.out.println(f.postfix);
		System.out.println(f.evaluate(7));
	}
	
	
	private class Number{
		private int val;
		private String str;
		
		public Number(String string){
			str= string;
		}
		
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
		public String toString(){
			return str;
		}
	}
}