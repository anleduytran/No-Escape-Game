package Game.Entity;

import Game.Util.Direction;

public class Entity {
	protected static int posX;
	protected static int posY;
	
	protected Entity(int posX, int posY) {
		this.setPos(posX, posY);
	}
	
	//Setter Method
	public void setPos(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	//Getter 
	public static int getPosX() {
		return posX;
	}
	public static int getPosY() {
		return posY;
	}
	//Move method
	protected void move(Direction dir) {
		switch(dir) {
		case FORWARD:
			this.posY--;
			break;
		case BACKWARD:
			this.posY++;
			break;
		case RIGHT:
			this.posX++;
			break;
		case LEFT:
			this.posX--;
			break;
		}
	}
}
