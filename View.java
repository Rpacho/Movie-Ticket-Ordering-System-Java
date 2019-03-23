import javax.swing.*;
import java.awt.*;

public class View {

	public static void main(String[] args){
		//Create frame
		JFrame frame = new JFrame();
		//Frame config
		

		JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		//frame.add(panel);
		frame.getContentPane().add(panel);
		
		//Buttons
		JButton button = new JButton("Search");
		button.setBounds(10,0,125,35);
		panel.add(button);

		//JTextField textField = new JTextField();
		//textField.setPreferredSize(new Dimension(200, 20));
		//panel.add(textField);

		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hello World");
		frame.setResizable(false);
		frame.setVisible(true);
		
		

	}
}
