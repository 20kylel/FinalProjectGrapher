import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * this works
 */
public class GraphDisplay extends JComponent{
	BufferedImage image;
	JFrame frame;
	public GraphDisplay(int x, int y, int width, int height){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public static void main(String[] args){
		GraphDisplay gd = new GraphDisplay(0,0,100, 100);
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image, 0,0,null );
	}
}
