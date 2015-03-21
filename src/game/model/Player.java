package game.model;

public interface Player 
{
	public int getSpeed();
	public int getHealth();
	public int setSpeed();
	public void setHealth();
	public int[] getPosition();
	public void  setPosition();
	void setPosition(int x, int y);
}
