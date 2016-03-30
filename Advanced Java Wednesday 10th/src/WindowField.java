import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowField extends JFrame implements ActionListener {
	
	private JButton btnRefresh 			= new JButton("Refresh");
	private JButton btnAdd 				= new JButton("Add Animal");
	private JButton btnDelete 			= new JButton("Delete");
	
	
	private Field field					= new Field();
	private JPanel panCenter			= new JPanel();
	private JPanel panBottom			= new JPanel();
	
	private ArrayList<Thread> lstThread = new ArrayList<Thread>();
	
	public WindowField()
	{
		super("WindowField");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.add(this.btnRefresh, BorderLayout.NORTH);
		
		this.field.setSize(new Dimension(200, 200));
		this.field.setBackground(Color.white);
		this.field.setVisible(true);
		this.add(this.field, BorderLayout.CENTER);
		
		this.panBottom.setLayout(new GridLayout());
		this.panBottom.setVisible(true);
		this.add(this.panBottom, BorderLayout.SOUTH);
		
		this.panBottom.add(this.btnAdd);
		this.panBottom.add(this.btnDelete);
		
		this.btnAdd.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnRefresh.addActionListener(this);
		
		this.pack();
		this.setSize(300, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent source) {
		if(source.getSource().equals(this.btnRefresh))
		{
			this.refresh();
			return;
		}
		
		if(source.getSource().equals(this.btnAdd))
		{
			try {
				GraphicalAnimal fish 	= new GraphicalAnimal(this.field);
				Thread t 				= new Thread(fish);
				this.lstThread.add(t);
				t.start();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return;
		}
		
		if(source.getSource().equals(this.btnDelete))
		{			
			if(this.lstThread.size() > 0)
			{
				Thread t = this.lstThread.get(this.lstThread.size() - 1);
				t.stop();
				this.lstThread.remove(t);
			}
			
			this.refresh();
			
			return;
		}
	}
	
	private void refresh()
	{
		this.field.repaint();
	}
}