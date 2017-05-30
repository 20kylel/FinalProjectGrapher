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
		return 0;
	}
	
	public String getFunction(){ return function; }

	public static String toPostfix(String str){
		Stack stack = new Stack();
		String post = "";
		char[] charr = new char[str.length()];
		str.getChars(0, str.length(), charr, 0);
		for(int i = 0; i < str.length();i++){
			if(charr[i] >= 48 && charr[i] <= 57){
				post += charr[i];
			}else if(getPrecedence(str.substring(i, i+1)) != -1){
				while(!stack.isEmpty() && getPrecedence((String) stack.peek()) <= getPrecedence(str.substring(i, i+1))){
					post += stack.pop();
				}
				stack.push(str.substring(i,i+1));
				
			}else if(str.substring(i,i+1) == "("){
				stack.push(str.substring(i,i+1));
			}else if(str.substring(i, i+1) == ")"){
				while(!stack.isEmpty() && stack.peek() != "(" ){
					post += stack.pop();
				}stack.pop();
			}
		}while(!stack.isEmpty()){
			post+=stack.pop();
		}return post;
	}
	public static int getPrecedence(String str){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(str == precedence[i][j]){
					return j;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		Function f = new Function("y=x");
		System.out.println(getPrecedence("+"));
		System.out.println(toPostfix("1+1"));
	}
	
	
	
}