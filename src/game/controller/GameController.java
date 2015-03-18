package game.controller;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import org.omg.CORBA.Environment;

import game.view.GameFrame;

public class GameController 
{
	private GameFrame baseFrame;
	private int [][] twoD;
	
	public GameController()
	{
		baseFrame = new GameFrame(this);	
	}
	

	public void start()
	{
		
	}
	
}
