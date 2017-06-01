import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GraphDisplay2 extends JComponent {

	private JFrame frame;
	private Color color;
	private Graph graph;
	private GraphDetails gd;

	private int xshift;
	private int yshift;

	public GraphDisplay2(Graph graph, GraphDetails gd)
	{	
		this.graph = graph;
		this.gd = gd;

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(600, 600));
		frame.getContentPane().add(this);

		frame.setTitle("Grapher");
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);

		color = Color.WHITE;

		xshift = 0;
		yshift = 0;
	}

	public void setTitle(String title)
	{
		frame.setTitle(title);
	}

	public void setBackgroundColor(Color color)
	{
		this.color = color;
	}

	protected void paintComponent(Graphics g)
	{
		int xscale = (int) (getWidth()/(gd.getxMax()-gd.getxMin()));
		int yscale = (int) (getHeight()/(gd.getyMax()-gd.getyMin()));

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));

		g2.setColor(Color.GRAY);
		double xAxis = getWidth()/2+xshift*xscale*gd.getxInc();
		double yAxis = getHeight()/2+yshift*yscale*gd.getyInc();
		g2.fillRect(0, (int) (yAxis-1), getWidth(), 3);
		g2.fillRect((int) (xAxis-1), 0, 3, getHeight());

		g2.setColor(Color.LIGHT_GRAY);
		for(double i=0; i<getWidth()-xAxis; i+=xscale*gd.getxInc()){
			g2.drawLine((int) (xAxis+i), 0, (int) (xAxis+i), getHeight());
		}
		for(double i=0; i<xAxis; i+=xscale*gd.getxInc()){
			g2.drawLine((int) (xAxis-i), 0, (int) (xAxis-i), getHeight());
		}
		for(double i=0; i<gd.getyMax()*yscale; i+=yscale*gd.getyInc()){
			g2.drawLine(0, (int) (yAxis+i), getWidth(), (int) (yAxis+i));
		}
		for(double i=0; i<yAxis; i+=yscale*gd.getyInc()){			
			g2.drawLine(0, (int) (yAxis-i), getWidth(), (int) (yAxis-i));
		}

		ArrayList<Function> functions = graph.getFunctions();
		for(int i=0; i<functions.size(); i++){
			Function f = functions.get(i);
			g2.setColor(f.getColor());
			g2.setStroke(new BasicStroke(2));
			for(double j=gd.getxMin(); j<gd.getxMax(); j+=gd.getInputInc()){
				double y1 = f.evaluate(j);
				double y2 = f.evaluate(j+gd.getInputInc());
				if(y1>gd.getyMin() && y1<gd.getyMax() || y2>gd.getyMin() && y2<gd.getyMax()){
					g2.drawLine((int) (j*xscale+getWidth()/2)+xshift*xscale, 
							(int) (getHeight()-y1*yscale-getHeight()/2)+yshift*yscale, 
							(int) ((j+gd.getInputInc())*xscale+getWidth()/2)+xshift*xscale, 
							(int) (getHeight()-y2*yscale-getHeight()/2)+yshift*yscale);
				}
			}
		}

	}

	public void addKeyListener(KeyListener listener)
	{
		frame.addKeyListener(listener);
	}

	public void shiftX(int dx){ xshift += dx; }
	public void shiftY(int dy){ yshift += dy; }

	public int getXShift(){ return xshift; }
	public int getYShift(){ return yshift; }

}
