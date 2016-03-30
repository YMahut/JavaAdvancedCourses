import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;


public class Animal {
	
	private final int PIXEL_MOVE = 5;
	
	private Point p;		// Position of the animal
	private Point upper;	// Position UpperLeft corner
	private Point lower;	// Position LowerRight corner
	
	public Animal(Rectangle rec)
	{
		this.upper 	= new Point((int)rec.getX(), 		(int)rec.getY());
		this.lower 	= new Point((int)rec.getWidth(), 	(int)rec.getHeight());
		this.p		= new Point((int)rec.getWidth()/2, 	(int)rec.getHeight()/2);
		
		this.Move();
	}
	
	public void Move()
	{
		Random random	= new Random();
		
		int newX 		= p.x;
		int newY		= p.y;
		
		if(random.nextBoolean())
		{
			if(newX + this.PIXEL_MOVE < this.lower.getX())
			{
				newX	+= this.PIXEL_MOVE;
			}
		}
		else
		{
			if(newX - this.PIXEL_MOVE > this.upper.getX())
			{
				newX	-= this.PIXEL_MOVE;
			}
		}
		
		if(random.nextBoolean())
		{
			if(newY + this.PIXEL_MOVE < this.lower.getY())
			{
				newY	+= this.PIXEL_MOVE;
			}
		}
		else
		{
			if(newY - this.PIXEL_MOVE > this.upper.getY())
			{
				newY	-= this.PIXEL_MOVE;
			}
		}
		
		this.p.setLocation(newX, newY);
	}
	
	public Point GetPoint()
	{
		return this.p;
	}
}
