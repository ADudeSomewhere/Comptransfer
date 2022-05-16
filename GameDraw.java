import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; /*You must import this in your mouseListener!*/
import java.awt.event.MouseMotionListener; 

@SuppressWarnings("serial")
public class GameDraw extends JPanel implements Runnable ,MouseListener{

	private int mouse_x, mouse_y; /*these will store the location of Mouse cursor, with respect to the window, not the screen */
	private boolean turn=true;//true==white,black=false
	private char px;
	private int py;
	private char tc;
	GameMethods a=new GameMethods();	

	@SuppressWarnings("unused")
	
	public GameDraw ()
	{
		setBackground(Color.WHITE);
		
		mouse_x = 0;
		mouse_y = 0;
		px='Z';
		py=9;
		
		
		addMouseListener(this); /*YOU MUST have this in the constructor of a MouseListener*/
		new Thread(this).start(); /*You have to start a new Thread in a Runnable */
	}

	public void paintComponent( Graphics window )
	{
		window.setColor(Color.DARK_GRAY);
		window.fillRect( 0,0, 2560,1400);

		window.setColor(new Color(17,135,103));
		window.fillRect( 0,0, 1400,1400);
		
		int tilex=0;
		int tiley=0;
		for(int i=1;i<=8;i++) {
			for(int j=1;j<=8;j++) {
				window.setColor(Color.black);
				window.drawRect(tilex, tiley, 175, 175);
				if(a.getSquare(xTranslate(tilex),yTranslate(tiley))!='#') {
					window.setColor(Color.white);
					window.fillOval(tilex+1, tiley+1, 173, 173);
					window.setColor(Color.black);
					window.drawOval(tilex+1, tiley+1, 173, 173);
				}
				if(a.getSquare(xTranslate(tilex),yTranslate(tiley))=='B') {
					window.fillOval(tilex+1, tiley+1, 173, 173);
					window.setColor(Color.white);
					window.drawOval(tilex+1, tiley+1, 173, 173);
				}
				tilex+=175;
			}
			tiley+=175;
			tilex=0;
		}
		window.setColor(Color.WHITE);
		window.drawString("Mouse coordinates (" + MouseInfo.getPointerInfo().getLocation().x + " , " + (MouseInfo.getPointerInfo().getLocation().y-23) + ")", 1450, 10 );
		window.drawString("Game coordinates(mouse) (" + xTranslate(MouseInfo.getPointerInfo().getLocation().x) + " , " + yTranslate(MouseInfo.getPointerInfo().getLocation().y-23) + "), Game coordinates(clicked) ("+px+" , "+py+")", 1450, 30 );

		window.drawString("This is the game of Othello. To play, you must place your piece on an empty tile, so that at least one of your opponent's tiles are between your new piece and old piece.",1450,50);
		window.drawString("This will capture the enemy piece(s), in any and all directions that they're between your newly placed piece and one of your already existing tiles. You must ALWAYS capture an enemy piece.",1450,70);
		window.drawString("To win, have more pieces than the other player by the time the board's full, or put them in a position they can't capture any more pieces. Remember to have fun(and also go for the corners)!",1450,90);
		
		window.drawString("White has "+ a.getWhite() +", and Black has "+ a.getBlack(),1450,110);
		if(turn==true) {	window.drawString("It's the White turn.",1450,130);}		
		else {	window.drawString("It's the Black turn",1450,130);}		
		
	}
	
	public char xTranslate(int xpos) {
		if(xpos<=1400&&xpos>=0) {
			xpos=(xpos/175)+1;
			if(xpos==1) {return('A');}
			else if(xpos==2) {return('B');}
			else if(xpos==3) {return('C');}
			else if(xpos==4) {return('D');}
			else if(xpos==5) {return('E');}
			else if(xpos==6) {return('F');}
			else if(xpos==7) {return('G');}
			else {return('H');}
		} else {return('Z');}
			
	}
	public int yTranslate(int ypos) {
		if(ypos<=1400&&ypos>=0) {
			return((ypos/175)+1);}
		else {return(8);}
	}

	/*You MUST have these 5 methods in a MouseListener */
		
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { 	/////// DOES NOT WORK, CAN PLACE IN INVALID POSITIONS, POSSIBLY DUE TO INCORRECT VALIDITY CHECKING
			if( e.getButton() == 1) {
				if(turn==true) {tc='W';}else{tc='B';}
				px=xTranslate(MouseInfo.getPointerInfo().getLocation().x);
				py=yTranslate(MouseInfo.getPointerInfo().getLocation().y-23);	
				if(a.isValidPlacePub(tc, px, py)==false&&a.shouldSkipTurn(tc)==false){
					return;
				}
				a.placePiece(tc,px,py);
				if(a.isItOver()==true) {}
				if(a.shouldSkipTurn(tc)==false) {
					if(turn==true) {turn=false;}
					else {turn=true;}}
			}
		}
	
	/*This method must be in a Runnable object*/
	public void run()
	{

		try
		{
			while( true )
			{	
			   Thread.sleep(50);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}

}