import java.awt.FlowLayout;

import javax.swing.*;
public class GraphDetails {
	static JFrame frame;
	GraphDisplay display;
	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private double originX;
	private double originY;
	private double yInc;
	private double xInc;
	private double inputInc;
	
	public GraphDetails(GraphDisplay d){
		display = d;
	}
	public static void main(String[] args) {
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    frame = new JFrame("Text Field Examples");
	    frame.getContentPane().setLayout(new FlowLayout());
	    frame.getContentPane().add(new JTextField("Text field 1"));
	    frame.getContentPane().add(new JTextField("Text field 2", 8));
	    JTextField t = new JTextField("Text field 3", 8);
	    t.setHorizontalAlignment(JTextField.RIGHT);
	    frame.getContentPane().add(t);
	    t = new JTextField("Text field 4", 8);
	    t.setHorizontalAlignment(JTextField.CENTER);
	    frame.getContentPane().add(t);
	    frame.getContentPane().add(new JTextField("Text field 5", 3));

	    frame.pack();
	    frame.setVisible(true);
	  }
	
	
	
	public double getxMax() {
		return xMax;
	}
	public void setxMax(double xMax) {
		this.xMax = xMax;
	}
	public double getxMin() {
		return xMin;
	}
	public void setxMin(double xMin) {
		this.xMin = xMin;
	}
	public double getyMax() {
		return yMax;
	}
	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
	public double getyMin() {
		return yMin;
	}
	public void setyMin(double yMin) {
		this.yMin = yMin;
	}
	public double getOriginX() {
		return originX;
	}
	public void setOriginX(double originX) {
		this.originX = originX;
	}
	public double getOriginY() {
		return originY;
	}
	public void setOriginY(double originY) {
		this.originY = originY;
	}
	public double getyInc() {
		return yInc;
	}
	public void setyInc(double yInc) {
		this.yInc = yInc;
	}
	public double getxInc() {
		return xInc;
	}
	public void setxInc(double xInc) {
		this.xInc = xInc;
	}
	public double getInputInc() {
		return inputInc;
	}
	public void setInputInc(double inputInc) {
		this.inputInc = inputInc;
	}
	
	
	

	
}
