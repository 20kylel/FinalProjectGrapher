import java.util.HashMap;

public class Function {

	private String function;
	private HashMap<String, String> valid;

	public Function(String f){
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
			function = f;
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
		
	}
	
	public String getFunction(){ return function; }

	public static void main(String[] args){
		Function f = new Function("y=x");
		System.out.println(f.getFunction());
	}
	
}