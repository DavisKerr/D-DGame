package game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener
{
	
	private String key;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		setKey(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void setKey(KeyEvent e)
	{
		
		key = KeyEvent.getKeyText(e.getKeyCode());
		
	}
	public String getKey()
	{
		if(key.equals(null))
		{
			return "";
		}
		else
		{
			return key;
		}
	}
}
