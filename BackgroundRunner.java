import java.awt.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class BackgroundRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public BackgroundRunner()
	{
		super("MouseBob Runner");

		setSize(WIDTH,HEIGHT);
		
		       
		add( new Background() );	
       	
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		BackgroundRunner run = new BackgroundRunner();
	}
}