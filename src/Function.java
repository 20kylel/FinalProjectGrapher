
public class Function {

	private String function;
	private String validChars[] = {"+", "-", "*", "/", "^", "%", 
			"x", "y", "X", "Y", "=", "(", ")",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	public Function(String f){
		function = validFunction(f);
	}

	private String validFunction(String f){
		String s = "";
		for(int i=0; i<f.length(); i++){
			if(isValidChar(f.substring(i, i+1))){
				s += f.substring(i, i+1);
			}
		}
		return s;
	}

	/*
	 * Invalid if:
	 * Uneven parenthesis
	 * Doubling operators (+, -, *, /, ^, %)
	 * Doubling variables
	 * Not starting with "y="
	 */
	public boolean isValid(String f){
		return false;
	}

	private boolean isValidChar(String s){
		for(int i=0; i<validChars.length; i++){
			if(s.equals(validChars[i])){
				return true;
			}
		}
		return false;
	}

	public String getFunction(){ return function; }

	public static void main(String[] args){
		Function f = new Function("y=x");
		System.out.println(f.getFunction());
	}

	public double evaluate(int x){
		return calculate(function, x);
	}
	
	private double calculate(String function, int x){
		double val = 0;
		for(int i=0; i<function.length(); i++){
			
		}
		return val;
	}
}