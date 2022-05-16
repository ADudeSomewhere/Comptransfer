import javax.swing.JFrame;

@SuppressWarnings("serial")
public class KeyBoxRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public KeyBoxRunner()
	{
		super("Key Listener!!");

		setSize(WIDTH,HEIGHT);
		
		getContentPane().add( new KeyBox() ); 


		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		KeyBoxRunner run = new KeyBoxRunner();
	}
}