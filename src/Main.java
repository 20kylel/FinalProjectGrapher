import java.awt.Color;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		//GraphDisplay display = new GraphDisplay(0, 0, 400, 400);
		GraphDetails details = new GraphDetails();
		Graph graph = new Graph(details, 1);
		
		details.setxInc(0.1);
		Scanner scanner = new Scanner(System.in);
		System.out.println("XMin: ");
		details.setxMin(scanner.nextDouble());
		System.out.println("XMax: ");
		details.setxMax(scanner.nextDouble());
		System.out.println("YMin: ");
		details.setyMin(scanner.nextDouble());
		System.out.println("YMax: ");
		details.setyMax(scanner.nextDouble());
		
		GraphDisplay2 display = new GraphDisplay2(graph, details);
		
		//Double digits incorrect
		/*
		Function f1 = new Function("x", Color.RED);
		graph.addFunction(f1);
		Function f2 = new Function("2*x", Color.ORANGE);
		graph.addFunction(f2);
		Function f3 = new Function("x+9", Color.BLUE);
		graph.addFunction(f3);
		Function f4 = new Function("x^2", Color.GREEN);
		graph.addFunction(f4);
		Function f5 = new Function("3", Color.MAGENTA);
		graph.addFunction(f5);
		*/
		
		System.out.println("Enter functions below: ");
		
		while(true){
			if(scanner.hasNext()){
				Function f = new Function(scanner.next(), Color.RED);
				graph.addFunction(f);
			}
			display.repaint();
		}
		
		/*
		System.out.println(graph.getFunctionsString());

		graph.setPoint(10, 20);
		*/

	}

}
