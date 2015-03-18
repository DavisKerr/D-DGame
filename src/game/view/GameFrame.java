package game.view;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Window;

import game.controller.GameController;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class GameFrame extends JFrame
{
	private GamePanel basePanel;
	private SpringLayout baseLayout;
	
	public GameFrame(GameController baseController)
	{
		this.basePanel = new GamePanel(baseController);
		
		
		
		
		setupFrame();
	}

	private void setupFrame() 
	{
		
		this.setContentPane(basePanel);
		this.setContentPane(basePanel);
		this.setSize(800,600);
		this.setResizable(false);
		this.setBackground(Color.green);
		setVisible(true);
		
		
		
	}
	
	

	
}
