import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph extends KeyAdapter {

	private ArrayList<Function> functions;
	private GraphDetails details;
	private static GraphDisplay2 display;

	public Graph(GraphDetails details, double scale)
	{
		functions = new ArrayList<>();
		this.details = details;
		display = new GraphDisplay2(this, details);
		
		display.addKeyListener(this);
	}

	public void addFunction(Function function)
	{
		functions.add(function);
	}

	public ArrayList<Function> getFunctions()
	{
		return functions;
	}

	public String getFunctionsString()
	{
		String f = "";
		for (Function function : functions)
		{
			f += function.getFunction() + ", ";
		}
		return f;
	}
	
	public void keyPressed(KeyEvent e){
		double xshift = 0, yshift = 0;
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			yshift = 1;
		} else if(e.getKeyCode()==KeyEvent.VK_UP){
			yshift = -1;
		} else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			xshift = 1;
		} else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			xshift = -1;
		} else if(e.getKeyCode()==KeyEvent.VK_0){
			details.setxMax(10);
			details.setxMin(-10);
			details.setyMax(10);
			details.setyMin(-10);
		}
		details.setxMax(details.getxMax()+xshift);
		details.setxMin(details.getxMin()+xshift);
		details.setyMax(details.getyMax()+yshift);
		details.setyMin(details.getyMin()+yshift);
		display.repaint();
	}
	
	public static void main(String[] args){
		GraphDetails details = new GraphDetails(null);
		Graph graph = new Graph(details, 1);
		
		details.setDisplay(display);

		Scanner scanner = new Scanner(System.in);

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

