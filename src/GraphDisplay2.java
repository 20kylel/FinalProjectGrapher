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
		
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(1));
		for(double i=0; i<getWidth()/2; i+=xscale*gd.getxInc()){
			g2.drawLine((int) (getWidth()/2+i), 0, (int) (getWidth()/2+i), getHeight());
			g2.drawLine((int) (getWidth()/2-i), 0, (int) (getWidth()/2-i), getHeight());
		}
		for(double i=0; i<getHeight()/2; i+=yscale*gd.getyInc()){
			g2.drawLine(0, (int) (getHeight()/2+i), getWidth(), (int) (getHeight()/2+i));
			g2.drawLine(0, (int) (getHeight()/2-i), getWidth(), (int) (getHeight()/2-i));
		}

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(4));
		if(gd.getxMax()>=0 && gd.getxMin()<=0){
			g2.drawLine((int) (-gd.getxMin()*xscale), 0, (int) (-gd.getxMin()*xscale), getHeight());
		}
		if(gd.getyMax()>=0 && gd.getyMin()<=0){
			g2.drawLine(0, (int) (getHeight()+gd.getyMin()*yscale), getWidth(), (int) (getHeight()+gd.getyMin()*yscale));
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
					g2.drawLine((int) (j*xscale-gd.getxMin()*xscale), 
							(int) (getHeight()-y1*yscale+gd.getyMin()*yscale), 
							(int) ((j+gd.getInputInc())*xscale-gd.getxMin()*xscale), 
							(int) (getHeight()-y2*yscale+gd.getyMin()*yscale));
				}
			}
		}

	}

	public void addKeyListener(KeyListener listener)
	{
		frame.addKeyListener(listener);
	}

}
