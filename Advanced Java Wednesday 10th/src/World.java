import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class World extends JFrame implements ActionListener{
	
	private JButton btnCenter = new JButton("addField");
	
	public World()
	{
		super("World");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.add(this.btnCenter, BorderLayout.CENTER);
		this.btnCenter.addActionListener(this);
		this.pack();
		this.setSize(100, 100);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent src) 
	{
		if(src.getSource().equals(this.btnCenter))
		{
			new WindowField();
		}
	}
	
	public static void main(String[] args)
	{
		World world = new World();
	}
}
