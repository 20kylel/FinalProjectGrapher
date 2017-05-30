
public class Main {
	public static void main(String[] args){
		GraphDisplay display = new GraphDisplay(0, 0, 400, 400);
		GraphDetails details = new GraphDetails(display);
		Graph graph = new Graph(details, 1);
		Function simple = new Function("y = x");
		graph.addFunction(simple);

		System.out.println(graph.getFunctionsString());

		graph.setPoint(10, 20);

	}
}
