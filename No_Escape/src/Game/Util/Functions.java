package Game.Util;

import java.util.Random;

import Game.Reference;
import Game.Entity.Room;

public class Functions {
	//Initializes all moving tiles in the floor like player etc.
	
	public static void initMovingTiles() {
		for(int y = 0; y < Reference.currentRoom.getHeight() -1; y++) {
			for(int x = 0; x < Reference.currentRoom.getWidth() -1; x++) {
				switch(Reference.currentRoom.getTile(x, y)) {
				case PLAYER:
					Reference.player.setPos(x, y);
					break;
				}
			}
		}
	}
	public static int getRandomNumber(int n) {
		Random rand = new Random();
		return rand.nextInt(n)+1;
	}
	private static boolean instruction = true;
	private static int roomCleared = 0;
	private static String message = " ";
	private static String message2 = " ";
	private static String message3 = " ";
	private static boolean openDictionary;
	private static boolean asking;
	private static boolean openDoor;
	private static boolean openClosedDoor;
	private static boolean end = false;
	
	//Checks if player can move and calls Reference.player.move(Direction) 
	 // @param direction - The direction the player wants to move
	public static void handlePlayerMovement(Direction direction) {
		//get the tile the player moving is null
		Tile tile = null;
		switch(direction) {
		case FORWARD:
			tile = Reference.currentRoom.getTile(Reference.player.getPosX(), Reference.player.getPosY()-1);
			break;
		case BACKWARD:
			tile = Reference.currentRoom.getTile(Reference.player.getPosX(), Reference.player.getPosY()+1);
			break;
		case RIGHT:
			tile = Reference.currentRoom.getTile(Reference.player.getPosX() + 1, Reference.player.getPosY());
			break;
		case LEFT:
			tile = Reference.currentRoom.getTile(Reference.player.getPosX() - 1, Reference.player.getPosY());
			break;
		}
	
	//Handle the Player Movement
		switch (tile) {
		case PATH:
			Reference.player.move(direction);
			message = " ";
			message2 = " ";
			message3 = " ";
			instruction = false;
			break; 
		case SIGN:
			Reference.player.move(direction);
			message = "[SIGN]: THE DICTIONARY ? CAN HELP YOU!";
			message2 = " ";
			message3 = " ";
			break;
		case WALL:
			message = "OUCH, YOU HIT THE WALL...";
			message2 = " ";
			message3 = " ";
			break;
		case DOOR:
			if(Reference.currentRoom.isStartRoom()) {
			Reference.player.move(direction);
			Reference.currentRoom = new Room(1); 
			message = "YOU WENT INTO A LOCKED ROOM! FIND THE KEY TO ESCAPE!";
			message2 = " ";
			message3 = " ";
			roomCleared ++;
			}
			//first room
			if(Reference.currentRoom.isFirstRoom()) {
			if(Reference.player.getKeys() == 1) {
				message = "YOU HAVE A KEY, WOULD YOU LIKE TO OPEN?";
				message2 = "     [Y] YES    [N] NO";
				message3 = " ";
				asking = true;
				decision = playerDecision.OPEN_DOOR;
			}
			else if(Reference.player.getKeys() == 0) {
				message = "YOU FOUND A DOOR!";
				message2 = " ";
				message3 = " ";
			}
			}
			//second room
			else if(Reference.currentRoom.isSecondRoom()) {
				if(Reference.player.getKeys() == 1) {
					message = "YOU HAVE A KEY, WOULD YOU LIKE TO OPEN?";
					message2 = "     [Y] YES    [N] NO";
					message3 = " ";
					asking = true;
					decision = playerDecision.OPEN_DOOR;
				}
				else if(Reference.player.getKeys() == 0) {
					message = "YOU FOUND A DOOR!";
					message2 = " ";
					message3 = " ";
				}
			}
			Functions.initMovingTiles();
			break;
		case HINT:
			//Dictionary in the room
				message = "YOU FOUND A DICTIONARY! DO YOU WANT TO OPEN IT?";
				message2= "    [Y] YES    [N] NO";
				message3 = " ";
				asking = true;
				decision = playerDecision.OPEN_DICTIONARY;
			
			break;
		case SONG:
			//in first room
			if(Reference.currentRoom.isFirstRoom()) {
				message = "[WHAT COULD IT BE THE NAME OF THE SONG?]";
				message2 ="THIS IS THE TIME TO REMEMBER,";
				message3 = "CAUSE IT WILL NOT LAST FOREVER...";
			}
			//in second room
			if(Reference.currentRoom.isSecondRoom()) {
				message = "[WHAT COULD IT BE THE NAME OF THE SONG?]";
				message2 ="UP THE STAIRS EVERY NIGHT";
				message3 = "UP THE STAIRS SEVEN FLIGHTS...";
			}
			break;
		case SANDCLOCK:
			//in first room
			if(Reference.currentRoom.isFirstRoom()) {
				message = "IT IS 8 O'CLOCK NOW IN THE ROOM!";
				message2 = " ";
				message3 = " ";
			}
			//in second room
			if(Reference.currentRoom.isSecondRoom()) {
				message = "IT IS A CLOCK BY THE STAIRS...";
				message2 = " ";
				message3 = " ";
			}
			break;
		case PAPERROLLED:
			//in first room
			if(Reference.currentRoom.isFirstRoom()) {
				message = "ALL OF THE TIME, I FAILED TO EXPRESS";
				message2 ="   FEELINGS THROUGH THE SONG... ";
				message3 = " ";
			}
			//in second room
			if(Reference.currentRoom.isSecondRoom()) {
				message = "HARRY POTTER USED TO LIVE UNDER THE STAIRS";
				message2 ="           ...JUST LIKE ME!";
				message3 = " ";
			}
			break;
		case KEY:
				Reference.player.addKeys();
				Reference.player.move(direction);
				message = "YOU FOUND THE KEY! WHAT IS IT FOR?";
				message2 = "";
				message3 = " ";
			break;
		case COMPUTER:
			//in firstROOm;
			if(Reference.currentRoom.isFirstRoom()) {
				message = "[SEARCHING]:BEEP BEEP...";
				message2 = "'BILLY JOEL - THIS IS THE TIME'";
				message3 = "BEEP...";
			}
			if(Reference.currentRoom.isSecondRoom()) {
				message = "[SEARCHING]:BEEP BEEP...";
				message2 = "'ELYSIAN FIELDS - PASSING ON THE STAIRS'";
				message3 = "BEEP...";
			}
			break;
		case MASTERKEY:
				Reference.player.addMasterKeys();
				Reference.player.move(direction);
				message = "YOU FOUND THE MASTER KEY!";
				message2 = " ";
				message3 = " ";
			break;
		case CLOSEDDOOR:
				if(Reference.player.getMasterKeys() == 0) {
					message = "WHERE CAN THE DOOR LEAD YOU TO?";
					message2 = " ";
					message3 = " ";
				}
				if(Reference.player.getMasterKeys() == 1) {
					message = "DO YOU WANT TO OPEN THE DOOR?";
					message2 = "     [Y] YES    [N] NO";
					message3 = " ";
					asking = true;
					decision = playerDecision.OPEN_CLOSEDDOOR;
				}
			break; 
		case CALCULATOR: 
			message = "1 STEP, 2 STEPS, THEN 4 STEPS...";
			message2= "HOW MUCH COULD IT BE?";
			message3 = "[CALCULATOR]: 1 + 2 + 4 = 7 STEPS";
			break;
		case POINTER:
			message = "WHY IS THIS POINTING UP?";
			message2 = "MAYBE IT IS SOMETHING YOU CAN GO UP!";
			message3 = "";
			break;
		}
	}
	public static String getMessage() {
		return message;
		}
	
	//Returns the second message to display on the screen
	public static String getMessage2() {
		return message2;
		}
	
	//Returns the third message to display on the screen
	public static String getMessage3() {
		return message3;
		}
	public static boolean isInstruction() {
		return instruction;
	}
	
	public static void makingDecision(boolean yesno) {
		if(decision == playerDecision.NONE) {
			return;
		}
		else if (decision == playerDecision.OPEN_DICTIONARY && yesno == true) {
			openDictionary = true;
			message = "YOU OPEN THE DICTIONARY";
			message2 = " ";
			message3 = " ";
		}
		else if (decision == playerDecision.OPEN_DICTIONARY && yesno == false) {
			openDictionary = false;
			message = " ";
			message2 = " ";
			message3 = " ";
		}
		else if (decision == playerDecision.OPEN_DOOR && yesno == true) {
			openDoor = true;
			Reference.player.lostKeys();
			Reference.player.move();
			message = "YOU CAN GO IN!";
			message2 = " ";
			message3 = " ";
		}
		else if (decision == playerDecision.OPEN_DOOR && yesno == false) {
			openDoor = false;
			message = " ";
			message2 = " ";
			message3 = " ";
		}
		else if (decision == playerDecision.OPEN_CLOSEDDOOR && yesno == true) {
			openClosedDoor = true;
			if(Reference.currentRoom.isFirstRoom()) {
			openClosedDoor = true;
			Reference.player.lostMasterKeys();
			Reference.currentRoom = new Room(2); 
			message = "OH NO! THE ROOM YOU WERE IN IS JUST AN ILLUSION!";
			message2 = " ";
			message3 = " ";
			roomCleared ++;
			}
			else if(Reference.currentRoom.isSecondRoom()) {
				openClosedDoor = true;
				Reference.player.lostMasterKeys();
				message = "";
				message2 = " ";
				message3 = " ";
				roomCleared ++;
				end = true;
			}
		}
		else if(decision == playerDecision.OPEN_CLOSEDDOOR && yesno == false) {
			openClosedDoor = false;
			message = "YOU CAN COME BACK LATER WHENEVER YOU WANT";
			message2 = " ";
			message3 = " ";
		}
	}
	
	private static playerDecision decision = playerDecision.NONE;
	private enum playerDecision{
		NONE,
		OPEN_DICTIONARY,
		OPEN_DOOR,
		OPEN_CLOSEDDOOR;
	}
	public static boolean isOpenDictionary() {
		return openDictionary;
	}
	public static boolean isAsking() {
		return asking;
	}
	public static boolean isOpenDoor() {
		return openDoor;
	}
	public static boolean isOpenClosedDoor() {
		return openClosedDoor;
	}
	public static boolean isEnd() {
		return end;
	}
}
