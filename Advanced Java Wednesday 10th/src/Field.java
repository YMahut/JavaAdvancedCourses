import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Field extends JPanel{
	
	private Graphics g;
	
	public Field()
	{
		this.g = this.getGraphics();
	}
	
	public Graphics GetGraphics()
	{
		return this.g;
	}
}
