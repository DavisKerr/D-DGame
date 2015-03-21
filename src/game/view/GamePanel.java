package game.view;

import game.controller.CharacterController;
import game.controller.GameController;
import game.controller.MovementListener;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

public class GamePanel extends JPanel implements Runnable
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private Image playerSprite1;
	private Image playerSprite2;
	private Image playerSprite3;
	private Canvas canvas;
	private Thread animator;
	public static final int PWIDTH = 800;
	public static final int PHEIGHT = 600;
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private BufferedImage im;
	private Thread t;
	private int imNum;
	private int x;
	private int y;
	private Graphics dbg;
	private Image dbImage;
	Graphics2D g2;
	private CharacterController character;
	private KeyListener listener;
	
	public GamePanel(GameController baseController)
	{
		this.baseController = baseController;
		character = new CharacterController();
		baseLayout = new SpringLayout();
//		listener = new MovementListener();
//		setFocusable(true);
//		addKeyListener(listener);
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("You pushed: " +  key);
				if(key.equalsIgnoreCase("D"))
				{
					character.setPosition(character.getPosition()[0] + 5, y);
				}
				else if(key.equalsIgnoreCase("A"))
				{
					character.setPosition(character.getPosition()[0] - 5, y);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		setFocusable(true);
		
		x = character.getPosition()[0];
		y = character.getPosition()[1];
		//x = 200;
		
		gameRender();
		
		
		
		//canvas = new Canvas();
		
		setupPanel();
		
		//generateImages();
		startGame();
		dbImage = loadImage("whiteScreen.png");
		
	}
	
	public void gameRender()
	{
		
		
		try
		{
			//im = loadImage("playerprite1.png");
			im = ImageIO.read(getClass().getResource("/images/playersprite1.png"));
			imNum = 0;
		}
		catch(Exception e)
		{
			System.out.println("Load image error: ");
			System.out.println(e);
		}
	}
	
	
	
	public void addNotify()
	{
		super.addNotify();
		startGame();
	}
	
	private void startGame()
	{
		if(animator == null || !running)
		{
			animator = new Thread(this);
			animator.start();
		}
	}
	
	public void  stopGame()
	{
		running = false;
	}
	
	public void run()
	{
		for(int i = 0; i < 10000; i++)
		{
			
			animate();
			//if(listener
			x = character.getPosition()[0];
			y = character.getPosition()[1];
			animateScreen();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				System.out.println(ex);
			}
		}
	}
	
	private Image loadImage(String fileName) 
	{
		
		return new ImageIcon(fileName).getImage();
	}

	private void loadImages() 
	{
		//load images
		//playerSprite1 = loadImage("images/playerSprite1.png");
		playerSprite2 = loadImage("images/playerSprite2.png");
		playerSprite3 = loadImage("images/playerSprite3.png");
		
		//canvas.paint(getGraphics());
	}

	private void setupPanel() 
	{
       
		this.setSize(800, 600);
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		//this.add(canvas);
		//canvas.setSize(800, 600);
		//canvas.setBackground(Color.YELLOW);
		
	}
	
	private void animate()
	{
		
		if(imNum == 0)
		{
			try
			{
				//im = loadImage("playerprite1.png");
				im = ImageIO.read(getClass().getResource("/images/playersprite3.png"));
				
			}
			catch(Exception e)
			{
				System.out.println("Load image error: ");
				System.out.println(e);
			}
			imNum = 1;
		}
		else
		{
			try
			{
				//im = loadImage("playerprite1.png");
				im = ImageIO.read(getClass().getResource("/images/playersprite1.png"));
				
			}
			catch(Exception e)
			{
				System.out.println("Load image error: ");
				System.out.println(e);
			}
			imNum = 0;
		}
	}
	

	private void animateScreen()
	{
		try
		{
			g2 = (Graphics2D) this.getGraphics();
			
			dbImage = createImage(PWIDTH, PHEIGHT);
			g2.setColor(Color.GREEN);
			g2.fillRect(0, 0, PWIDTH, PHEIGHT);
			g2.drawImage(dbImage, 0, 0, null);
			g2.drawImage(im, x, y, null);
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
	
	
}
