import java.util.ArrayList;

public class Graph {

	private ArrayList<Function> functions;
	private GraphDetails details;
	private GraphDisplay display;

	public Graph(GraphDetails details)
	{
		functions = new ArrayList<>();
		this.details = details;
		display = details.getDisplay();
	}

	public void addFunction(Function function)
	{
		functions.add(function);
	}

	public void setPoint(int x, int y)
	{

	}


}
