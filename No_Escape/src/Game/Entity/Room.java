package Game.Entity;

import java.awt.Color;
import java.util.ArrayList;

import Game.Reference;
import Game.GUI.GameBoard;
import Game.Util.ResourceManager;
import Game.Util.Tile;

public class Room {
	
	private ArrayList<ArrayList<Tile>> tiles;
	private boolean startRoom;
	private boolean firstRoom;
	private boolean secondRoom;
	private boolean firstHintFirstRoom;
	
	public Room(int roomNumber) {
		System.out.println("[Room]: Creating Room " + roomNumber + ".");
		tiles = new ArrayList<ArrayList<Tile>>();
		
		ArrayList<String> strs = ResourceManager.readRoomFile("src/room_txt/room" + roomNumber + ".txt");
		for(int i = 0; i < strs.size()-1; i++) {
			char[] charray = strs.get(i).toCharArray();
			tiles.add(new ArrayList<Tile>());
			for(int j = 0; j < charray.length; j++) {
				switch(charray[j]) {
				case '.':
					tiles.get(i).add(Tile.PATH);
					break;
				case '#':
					tiles.get(i).add(Tile.WALL);
					break;
				case 'A':
					tiles.get(i).add(Tile.PLAYER);
					break;
				case '?':
					tiles.get(i).add(Tile.HINT);
					break;
				case '/':
					tiles.get(i).add(Tile.DOOR);
					break;
					case 'D':
					tiles.get(i).add(Tile.CLOSEDDOOR);
					break;
				case '8':
					tiles.get(i).add(Tile.SANDCLOCK);
					break;
				case '*':
					tiles.get(i).add(Tile.PAPERROLLED);
					break;
				case '~':
					tiles.get(i).add(Tile.SONG);
					break;
				case 'O':
					tiles.get(i).add(Tile.SIGN);
					break;
				case ',':
					tiles.get(i).add(Tile.KEY);
					break;
				case '!':
					tiles.get(i).add(Tile.MASTERKEY);
					break;
				case '@':
					tiles.get(i).add(Tile.COMPUTER);
					break;
				case '%':
					tiles.get(i).add(Tile.CALCULATOR);
					break;
				case '^':
					tiles.get(i).add(Tile.POINTER);
				}
			}
		}
		
		if(roomNumber == 0) {
			startRoom = true;
		}else {
			startRoom = false;
		}
		if(roomNumber == 1) {
			firstRoom = true;
		}else {
			firstRoom = false;
		}
		if(roomNumber == 2) {
			secondRoom = true;
		}else {
			secondRoom = false;
		}
	}
	//Updates the position of the player
	public void updatePlayerPos() {
		//Deletes old pos
		for(int i=0;i<this.getHeight();i++) {
			for(int j=0;j<this.getWidth();j++) {
				if(tiles.get(i).get(j) == Tile.PLAYER)
					tiles.get(i).set(j, Tile.PATH);
			}
		}
		//Sets new pos
		tiles.get(Reference.player.getPosY()).set(Reference.player.getPosX(), Tile.PLAYER);
	}
	
	public int getHeight() {
		return tiles.size();
		
	}
	
	public int getWidth() {
		return tiles.get(0).size();
	}
	
	public Tile getTile(int x, int y) {
		return tiles.get(y).get(x);
	}
	
	public char getTileChar (int x, int y) {
			return tiles.get(y).get(x).getSymbol();
	}
	
	public boolean isStartRoom (){
		return startRoom;
	}
	public boolean isFirstRoom() {
		return firstRoom;
	}
	public boolean isSecondRoom() {
		return secondRoom;
	}
	
}
