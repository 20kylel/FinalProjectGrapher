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

	public GraphDisplay2(Graph graph, GraphDetails gd)
	{	
		this.graph = graph;
		this.gd = gd;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(500, 500));
		frame.getContentPane().add(this);

		frame.setTitle("Grapher");
		frame.setResizable(false);
		
		frame.pack();
		frame.setVisible(true);
		
		color = Color.WHITE;
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
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(color);
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		
		g2.setColor(Color.GRAY);
		g2.fillRect(0, getHeight()/2-1, getWidth(), 3);
		g2.fillRect(getWidth()/2-1, 0, 3, getHeight());
		
		g2.setColor(Color.BLACK);

		int xscale = (int) (getWidth()/(gd.getxMax()-gd.getxMin()));
		int yscale = (int) (getHeight()/(gd.getyMax()-gd.getyMin()));
		ArrayList<Function> functions = graph.getFunctions();
		for(int i=0; i<functions.size(); i++){
			Function f = functions.get(i);
			g2.setColor(f.getColor());
			for(double j=gd.getxMin(); j<gd.getxMax(); j+=gd.getxInc()){
				double y1 = f.evaluate(j);
				double y2 = f.evaluate(j+gd.getxInc());
				if(y1>gd.getyMin() && y1<gd.getyMax() || y2>gd.getyMin() && y2<gd.getyMax()){
					g2.drawLine((int) (j*xscale+getWidth()/2), (int) (getHeight()-y1*yscale-getHeight()/2), (int) ((j+gd.getxInc())*xscale+getWidth()/2), (int) (getHeight()-y2*yscale-getHeight()/2));
				}
			}
		}
		
	}
	
}
