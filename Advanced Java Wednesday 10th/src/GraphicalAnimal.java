import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


public class GraphicalAnimal extends Animal implements Runnable{

	private final int FISH_SIZE = 20;
	
	private Field field;
	
	public GraphicalAnimal(Field field)
	{
		super(field.getBounds());
		this.field = field;
	}
	
	public void Draw()
	{
		Graphics2D g 	= (Graphics2D)this.field.getGraphics();
		g.setColor(Color.blue);
		Shape c 		= new Ellipse2D.Double(this.GetPoint().getX(), this.GetPoint().getY(), this.FISH_SIZE, this.FISH_SIZE);
		
		g.fill(c);
	}
	
	public void Clear()
	{
		Graphics2D g 	= (Graphics2D)this.field.getGraphics();
		g.setColor(Color.white);
		Shape c 		= new Ellipse2D.Double(this.GetPoint().getX(), this.GetPoint().getY(), this.FISH_SIZE, this.FISH_SIZE);
		
		g.fill(c);
	}
	
	@Override
	public void run()
	{
		while(true)
		{			
			try 
			{
				synchronized (this) {
					this.wait(50);		
				}
			} catch (Exception e) {
				
			}
			
			this.Clear();
			this.Move();
			this.Draw();
		}
	}
}
