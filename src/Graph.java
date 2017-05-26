import java.awt.image.BufferedImage;
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

		public void setPoint(double x, double y)
		{
			display.image.setRGB((int) (x + details.getOriginX()), (int) (y + details.getOriginY()), 255);
		}

		public void plotGraph() {
			for (Function f : functions) {
				for (int x = (int) details.getxMin(); x < details.getxMax(); x++) {
					for (int inc = 0; inc < (int) details.getInputInc(); inc++)
					{
						setPoint(x, f.evaluate());
					}
				}
			}
		}


	}

