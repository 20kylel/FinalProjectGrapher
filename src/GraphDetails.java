import java.awt.FlowLayout;

import javax.swing.*;
public class GraphDetails {
	static JFrame frame;
	GraphDisplay display;
	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private double yInc;
	private double xInc;
	private double inputInc;
	
	private double originX;
	private double originY;
	
	public GraphDetails(GraphDisplay d){
		display = d;
	}
	public void prepareJFrame(){
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    frame = new JFrame("Text Field Examples");
	    frame.getContentPane().setLayout(new FlowLayout());
	    JTextField xMaxT = new JTextField("EnterValue", JLabel.RIGHT);
	    JTextField xMinT = new JTextField("EnterValue", JLabel.RIGHT);
	    JTextField yMaxT = new JTextField("EnterValue", JLabel.RIGHT);
	    JTextField yMinT = new JTextField("EnterValue",JLabel.RIGHT );
	    JTextField yIncT = new JTextField("EnterValue", JLabel.RIGHT);
	    JTextField xIncT = new JTextField("EnterValue", JLabel.RIGHT);
	    JTextField inputIncT = new JTextField("EnterValue", JLabel.RIGHT);	    
	    xMaxT.setHorizontalAlignment(JTextField.RIGHT);
	    xMinT.setHorizontalAlignment(JTextField.RIGHT);
	    yMaxT.setHorizontalAlignment(JTextField.RIGHT);
	    yMinT.setHorizontalAlignment(JTextField.RIGHT);
	    yIncT.setHorizontalAlignment(JTextField.RIGHT);
	    xIncT.setHorizontalAlignment(JTextField.RIGHT);
	    inputIncT.setHorizontalAlignment(JTextField.RIGHT);
	    
	    JLabel xMaxL = new JLabel("X Maximum", JLabel.RIGHT);
	    JLabel xMinL = new JLabel("X Minimum", JLabel.RIGHT);
	    JLabel yMaxL = new JLabel("Y Maximum", JLabel.RIGHT);
	    JLabel yMinL = new JLabel("Y Minimum",JLabel.RIGHT );
	    JLabel yIncL = new JLabel("Y Increment", JLabel.RIGHT);
	    JLabel xIncL = new JLabel("X Increment", JLabel.RIGHT);
	    JLabel inputIncL = new JLabel("Input Increment", JLabel.RIGHT);	    
	    xMaxT.setHorizontalAlignment(JLabel.RIGHT);
	    xMinT.setHorizontalAlignment(JLabel.RIGHT);
	    yMaxT.setHorizontalAlignment(JLabel.RIGHT);
	    yMinT.setHorizontalAlignment(JLabel.RIGHT);
	    yIncT.setHorizontalAlignment(JLabel.RIGHT);
	    xIncT.setHorizontalAlignment(JLabel.RIGHT);
	    inputIncT.setHorizontalAlignment(JLabel.RIGHT);
	    
	    frame.getContentPane().add(new JLabel(""));
	    frame.getContentPane().add();
	    frame.getContentPane().add();
	    frame.getContentPane().add();
	    frame.getContentPane().add();
	    frame.getContentPane().add();
	    frame.getContentPane().add();
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

    public GraphDisplay getDisplay()
    {
        return display;
    }

    public void setDisplay(GraphDisplay display)
    {
        this.display = display;
    }
}
