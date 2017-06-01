import java.awt.Color;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		//GraphDisplay display = new GraphDisplay(0, 0, 400, 400);
		GraphDetails details = new GraphDetails();
		Graph graph = new Graph(details, 1);

		Scanner scanner = new Scanner(System.in);
		
		GraphDisplay2 display = new GraphDisplay2(graph, details);
		
		System.out.println("Enter functions below: ");
		System.out.print("f(x)=");
		
		while(true){
			if(scanner.hasNext()){
				Function f = new Function(scanner.next(), Color.RED);
				graph.addFunction(f);
				System.out.print("f(x)=");
			}
			display.repaint();
		}

	}

}
