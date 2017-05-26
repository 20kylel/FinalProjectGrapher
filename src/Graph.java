import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Graph {

		private ArrayList<Function> functions;
		private GraphDetails details;
		private GraphDisplay display;
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

		public void setPoint(double x, double y)
		{
			display.image.setRGB((int) (x + details.getOriginX()), (int) (y + details.getOriginY()), 255);
		}

		public void plotGraph() {
			for (Function f : functions) {
				double originX = details.getOriginX();
				for (double x = (details.getxMin() - originX) / scale; x < details.getxMax() / scale; x++) {
						setPoint(x, f.evaluate(x / scale));
				}
			}
		}


	}

