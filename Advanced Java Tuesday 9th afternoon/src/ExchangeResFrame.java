

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExchangeResFrame extends JFrame implements ActionListener{

	JButton add1;
	
	JTextField t1;
	JTextField t2;
	
	public ExchangeResFrame(){
		
		setTitle("ExchangeRes");
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false);
		add1 = new JButton("add");
		
		t1=new JTextField("             ");
		t2=new JTextField("             ");
		JLabel l1= new JLabel("Date (aaaa-mm-jj)");
		JLabel l2= new JLabel("Exchange rate");

		add1.addActionListener(this);
		
		
		setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;

	    gbc.gridx = 0;
	    gbc.gridy = 0;
		getContentPane().add(l1, gbc);
		
		gbc.gridx = 1;
	    gbc.gridy = 0;
		getContentPane().add(t1, gbc);
		
		gbc.gridx = 2;
	    gbc.gridy = 0;
	    getContentPane().add(l2, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 0;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(t2, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(add1, gbc);
		
		setVisible(true);

	}


	public void actionPerformed(ActionEvent e)
	{	
		
		String decimalPattern = "([0-9]*)\\.([0-9]*)";  
		String number= t2.getText();  
		boolean floatValidate = Pattern.matches(decimalPattern, number);
		if(floatValidate){
				System.out.println("ok");
		}else{
			JOptionPane.showMessageDialog(this, "Rate problem : x.xxxx","Inane error",
			JOptionPane.ERROR_MESSAGE);	
		}	    
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(false);
	    boolean dateValidate = sdf.parse(t1.getText(), new ParsePosition(0)) != null;
		
	    addToTable();
	    
	    if(dateValidate){
			System.out.println("ok");
		}else{
			JOptionPane.showMessageDialog(this, "Date problem : yyyy-mm-dd","Inane error",
			    JOptionPane.ERROR_MESSAGE);	
		}	    
		
	}
	
	public void addToTable(){
		
	}
	
}
