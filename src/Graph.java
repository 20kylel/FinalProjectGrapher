import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Graph extends KeyAdapter {

	private ArrayList<Function> functions;
	private GraphDetails details;
	private GraphDisplay2 display;
	private double scale;

	public Graph(GraphDetails details, double scale)
	{
		functions = new ArrayList<>();
		this.details = details;
		display = details.getDisplay();
		this.scale = scale;
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

	/*
	public void setPoint(double x, double y)
	{
		BufferedImage i = display.getImage();
		i.setRGB((int) (x + details.getOriginX()), (int) (y + details.getOriginY()), 100);
		display.setImage(i);
	}

	public void plotGraph() {
		for (Function f : functions) {
			double originX = details.getOriginX();
			for (double x = (details.getxMin() - originX) / scale; x < details.getxMax() / scale; x++) {
				setPoint(x, ((Function) f).evaluate((int) ((int) x / scale)));
			}
		}
	}
	*/
		
	public void keyPressed(KeyEvent e){
		
	}

}

