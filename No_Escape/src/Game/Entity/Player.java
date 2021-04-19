package Game.Entity;

import Game.Util.Direction;

public class Player extends Entity{
	
	private Direction facing;
	
	private int keys;
	private int masterKeys;
	
	private boolean alive;
	
	public Player(int posX, int posY) {
		super(posX, posY);
		this.alive = true;
		System.out.println("[Player]: Creating Player");
	}
	
	@Override
	public void move(Direction dir) {
		super.move(dir);
	}
	
	//Move the player in direction he facing 
	public void move() {
		this.move(facing);
	}
	
	public void setFacing(Direction dir) {
		this.facing = dir;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void setDead() {
		this.alive = false;
	}
	public int getKeys() {
		return keys;
	}
	public void addKeys() {
		keys++;
	}
	public int getMasterKeys() {
		return masterKeys;
	}
	public void addMasterKeys() {
		masterKeys++;
	}
	public void lostKeys() {
		keys --;
	}
	public void lostMasterKeys() {
		masterKeys -- ;
	}
	
}
