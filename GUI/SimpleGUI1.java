import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
									
public class SimpleGUI1{

	JFrame frame;
	JLabel label;

	public static void main(String[] args){
		SimpleGUI1 gui = new SimpleGUI1();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change colors");//button practise
		labelButton.addActionListener(new LabelListener()); //2. Register
		
		JButton colorButton = new JButton("Change circle");//button practise
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		
		MyDrawPanel panel = new MyDrawPanel();//drawing practice
		
		frame.getContentPane().add(BorderLayout.SOUTH,colorButton);//practice
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.EAST,labelButton);
		frame.getContentPane().add(BorderLayout.WEST,label);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
									//1. Implement
	class LabelListener implements ActionListener{
	
	//3. Handle
		public void actionPerformed(ActionEvent event){
			label.setText("Ouch!");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
	
}