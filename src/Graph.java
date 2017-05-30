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
		public void setPoint(double x, double y)
		{
			display.getImage().setRGB((int) (x + details.getOriginX()), (int) (y + details.getOriginY()), 255);
		}

		public void plotGraph() {
			Function i = new Function("ajdlfa");
			for (Function f : functions) {
				double originX = details.getOriginX();
				for (double x = (details.getxMin() - originX) / scale; x < details.getxMax() / scale; x++) {
						setPoint(x, ((Function) f).evaluate((double) x / scale));
				}
			}
		}


	}

