package game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.model.Player;

public class CharacterController implements Player 
{
	private int[] position;
	private int speed;
	private int health;
	
	public CharacterController()
	{
		position = new int[2];
		position[0] = 5;
		position[1] = 5;
		speed = 5;
		health = 100;
		
	}
	

	@Override
	public int getSpeed() 
	{
		
		return 0;
	}

	@Override
	public int getHealth() 
	{
		
		return 0;
	}

	@Override
	public int setSpeed() 
	{
		
		return 0;
	}

	@Override
	public void setHealth() 
	{
		
		
	}

	@Override
	public int[] getPosition() 
	{
		return position;
	}

	@Override
	public void setPosition(int x, int y) 
	{
		position[0] = x;
		position[1] = y;
	}


	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		
	}

	
		
}
