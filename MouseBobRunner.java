import java.awt.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class MouseBobRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public MouseBobRunner()
	{
		super("MouseBob Runner");

		setSize(WIDTH,HEIGHT);
		
		
		MouseBob mb = new MouseBob( );
		       
		add( mb );	
       	
       
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		MouseBobRunner run = new MouseBobRunner();
	}
}