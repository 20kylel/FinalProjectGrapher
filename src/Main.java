import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		GraphDetails details = new GraphDetails(null);
		Graph graph = new Graph(details, 1);
		GraphDisplay2 display = new GraphDisplay2(graph, details);

		Scanner scanner = new Scanner(System.in);

		details.setDisplay(display);

		System.out.println("Enter functions below: ");
		System.out.print("f(x)=");

		while(true){
			if(scanner.hasNext()){
				String function = scanner.nextLine();
				Function f = new Function(function, getColor(scanner));
				graph.addFunction(f);

				System.out.print("f(x)=");
			}
			display.repaint();
		}

	}

	private static Color getColor(Scanner scanner){
		Color c = Color.BLACK;

		System.out.print("Color (red, orange, yellow, green, blue, purple, black): ");
		String color = scanner.nextLine().toLowerCase();

		if(color.equals("red")){
			return Color.RED;
		} else if(color.equals("orange")){
			return Color.ORANGE;
		} else if(color.equals("yellow")){
			return Color.YELLOW;
		} else if(color.equals("green")){
			return Color.GREEN;
		} else if(color.equals("blue")){
			return Color.BLUE;
		} else if(color.equals("purple")){
			return Color.MAGENTA;
		} else if(color.equals("black")){
			return Color.BLACK;
		} else {
			System.out.println("Invalid color; Default color (Black) chosen");
			return Color.BLACK;
		}
	}

}
