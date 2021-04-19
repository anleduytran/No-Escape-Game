package Game.Entity;

public class HintEntity {
	protected int positionX, positionY;
	
	protected HintEntity(int positionX, int positionY) {
		this.setPosition(positionX, positionY);
	}
	//setter
	public void setPosition(int x, int y) {
		this.positionX  = x;
		this.positionY = y;
	}
	//getter
	public int getPositionX (){
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	
}
