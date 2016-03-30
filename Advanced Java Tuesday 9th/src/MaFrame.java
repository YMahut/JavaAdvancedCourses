import java.awt.BorderLayout;

import javax.swing.*;

public class MaFrame extends JFrame {

	JButton northButton = new JButton("North");
	JButton centerButton = new JButton("Center");
	JButton westButton = new JButton("West");
	JButton eastButton = new JButton("East");
	JButton southButton = new JButton("South");
	
	public MaFrame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Fenetre1");
		
		getContentPane().add(northButton, BorderLayout.NORTH);
		getContentPane().add(centerButton, BorderLayout.CENTER);
		getContentPane().add(westButton, BorderLayout.WEST);
		getContentPane().add(eastButton, BorderLayout.EAST);
		getContentPane().add(southButton, BorderLayout.SOUTH);
		
		pack();
	}
	

}
