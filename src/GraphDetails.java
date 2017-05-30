import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GraphDetails implements ActionListener{
	static JFrame frame;
	GraphDisplay display;
	private boolean graphable;
	
	
	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private double yInc;
	private double xInc;
	private double inputInc;
	
	
	private JLabel xMaxL;
	private JLabel xMinL;
	private JLabel yMaxL;
	private JLabel yMinL;
    private JLabel yIncL;
    private JLabel xIncL ;
    private JLabel inputIncL;
    
    private JTextField xMaxT;
	private JTextField xMinT;
	private JTextField yMaxT;
	private JTextField yMinT;
    private JTextField yIncT;
    private JTextField xIncT ;
    private JTextField inputIncT;
    
	
	private double originX;
	private double originY;
	
	public GraphDetails(GraphDisplay d){
		display = d;
		graphable = false;
		this.prepareJFrame();
	}
	
	public static void main(String[] args){
		GraphDetails i = new GraphDetails(new GraphDisplay(1,1,1,1));
	}
	public void prepareJFrame(){
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    frame = new JFrame("Text Field Examples");
	    frame.getContentPane().setLayout(new FlowLayout());
	    xMaxT = new JTextField("EnterVal", JLabel.RIGHT);
	    xMinT = new JTextField("EnterVal", JLabel.RIGHT);
	    yMaxT = new JTextField("EnterVal", JLabel.RIGHT);
	    yMinT = new JTextField("EnterVal",JLabel.RIGHT );
	    yIncT = new JTextField("EnterVal", JLabel.RIGHT);
	    xIncT = new JTextField("EnterVal", JLabel.RIGHT);
	    inputIncT = new JTextField("EnterValue", JLabel.RIGHT);	    
	    xMaxT.setHorizontalAlignment(JTextField.RIGHT);
	    xMinT.setHorizontalAlignment(JTextField.RIGHT);
	    yMaxT.setHorizontalAlignment(JTextField.RIGHT);
	    yMinT.setHorizontalAlignment(JTextField.RIGHT);
	    yIncT.setHorizontalAlignment(JTextField.RIGHT);
	    xIncT.setHorizontalAlignment(JTextField.RIGHT);
	    inputIncT.setHorizontalAlignment(JTextField.RIGHT);
	    
	    xMaxL = new JLabel("X Maximum:", JLabel.RIGHT);
	    xMinL = new JLabel("X Minimum:", JLabel.RIGHT);
	    yMaxL = new JLabel("Y Maximum:", JLabel.RIGHT);
	    yMinL = new JLabel("Y Minimum:",JLabel.RIGHT );
	    yIncL = new JLabel("Y Increment:", JLabel.RIGHT);
	    xIncL = new JLabel("X Increment:", JLabel.RIGHT);
	    inputIncL = new JLabel("Input Increment:", JLabel.RIGHT);	    
	    
	    frame.getContentPane().add(xMaxL);
	    frame.getContentPane().add(xMaxT);
	    frame.getContentPane().add(xMinL);
	    frame.getContentPane().add(xMinT);
	    frame.getContentPane().add(yMaxL);
	    frame.getContentPane().add(yMaxT);
	    frame.getContentPane().add(yMinL);
	    frame.getContentPane().add(yMinT);
	    frame.getContentPane().add(yIncL);
	    frame.getContentPane().add(yIncT);
	    frame.getContentPane().add(xIncL);
	    frame.getContentPane().add(xIncT);
	    frame.getContentPane().add(inputIncL);
	    frame.getContentPane().add(inputIncT);
	    
	    JButton applyButton = new JButton("Apply");
	    applyButton.addActionListener(this);
	    frame.getContentPane().add(applyButton);
	    frame.pack();
	    frame.setVisible(true);
	  }
	
	public boolean graphable(){
		return graphable;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		graphable = false;
		try{
			if(Double.parseDouble(xMaxT.getText())-Double.parseDouble(xMinT.getText()) > screenSize.getHeight()){
				
			}else if(Double.parseDouble(yMaxT.getText())-Double.parseDouble(yMinT.getText()) > screenSize.getWidth()){
				
			}else if(Double.parseDouble(yIncT.getText()) > Double.parseDouble(yMaxT.getText())-Double.parseDouble(yMinT.getText())){
				
			}else if(Double.parseDouble(xIncT.getText()) > Double.parseDouble(xMaxT.getText())-Double.parseDouble(xMinT.getText())){
					
			}else if(Double.parseDouble(inputIncT.getText()) > Double.parseDouble(xMaxT.getText())-Double.parseDouble(xMinT.getText())){
				
			}
			xMax = Double.parseDouble(xMaxT.getText());
			xMin = Double.parseDouble(xMinT.getText());
			yMax = Double.parseDouble(yMaxT.getText());
			yMin = Double.parseDouble(yMinT.getText());
			xInc = Double.parseDouble(xIncT.getText());
			yInc = Double.parseDouble(yIncT.getText());
			inputInc = Double.parseDouble(inputIncT.getText());
			graphable = true;
		}catch(NumberFormatException exception){
			
		}
		
	}
}
