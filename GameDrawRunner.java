import java.awt.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GameDrawRunner extends JFrame
{
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1400;

	public GameDrawRunner()
	{
		super("Othello");

		setSize(WIDTH,HEIGHT);
		
		
		GameDraw mb = new GameDraw( );
		       
		add( mb );	
       	
       
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		GameDrawRunner run = new GameDrawRunner();
	}
}