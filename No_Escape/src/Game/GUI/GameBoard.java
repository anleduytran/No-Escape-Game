package Game.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Game.Main;
import Game.Reference;
import Game.Entity.Player;
import Game.Util.Direction;
import Game.Util.Functions;

public class GameBoard extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	//private static boolean keyFound = false;
	
	private static int roomNumber;
	private static final long serialVersionUID = 1L;

	public GameBoard() {
		addKeyListener(this);
		this.setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		revalidate();
		if(Functions.isEnd() != true) {
		//BackGround
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Reference.windowWidth, Reference.windowHeight);
		g.setColor(Color.WHITE);
		g.drawRoundRect(5,5, Reference.windowWidth - 320, Reference.windowHeight - 150, 5,5 );
		g.drawRoundRect(790, 5, Reference.windowWidth - 810, Reference.windowHeight - 150, 5, 5);
		g.drawRoundRect(5, Reference.windowHeight - 140, Reference.windowWidth - 25, Reference.windowHeight - 505, 5, 5 );
		
		//Room
		g.setColor(Color.WHITE);
		
		int x, y;
		if(Reference.currentRoom.isFirstRoom()) {
			x = 15;
			y = 25;
		} else {
			x = 15;
			y = 25;
		}
		for(int i=0;i<Reference.currentRoom.getHeight();i++) {
			for(int j=0;j<Reference.currentRoom.getWidth();j++) {
				g.drawString(""+Reference.currentRoom.getTileChar(j, i), x, y);
				x+=10;// for width space between symbol :x+=10;
			}
			//y+=15 for height space between symbol; x=15; 
			if(Reference.currentRoom.isFirstRoom()) {
				x=15; 
				y+=15;
				}
			else{
				x=15; 
				y+=15;
				}
		}
		if(Reference.currentRoom.isStartRoom() && Functions.isInstruction()) {
			g.setFont(new Font("arial", Font.PLAIN, 15));
			g.drawString("INSTRUCTION:", 15, 480);
			g.drawString("YOU CAN USE WASD TO MOVE, RIGHTMOST BOARD AS A FUNCTIONAL INVENTORY.", 15, 500);
			g.drawString(Functions.getMessage(), 300, 190);
			roomNumber = 0;
			
		}
		//Message
		g.drawString(Functions.getMessage(), 15, 480);
		g.drawString(Functions.getMessage2(), 15, 500);
		g.drawString(Functions.getMessage3(), 15, 520);

		//Player stats
		g.setFont(new Font("arial", Font.PLAIN, 30));
		g.drawString("NO ESCAPE!", 850, 45);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("ROOM: " + roomNumber, 800, 75);
		g.drawString("KEY: " + Reference.player.getKeys(), 800, 95);
		g.drawString("MASTER KEY: "+ Reference.player.getMasterKeys(), 800, 115);
		if(Reference.currentRoom.isFirstRoom()) {
			roomNumber = 1;
		}
		if(Reference.currentRoom.isSecondRoom()) {
			roomNumber = 2;
		}
//		if(roomNumber == 1) {
//			if(Player.getPosX() == 35 && Player.getPosY() == 9) {
//				keyFound = true;
//			}
//		}
		//g.drawString("ITEMS: ", 800, 95);
		if(Functions.isOpenDictionary() == true) {
			if(roomNumber == 1) {
			g.drawString("DICTIONARY: ", 800, 135);
			g.setFont(new Font("arial", Font.PLAIN, 15));
			g.drawString("* : A ROLLED PAPER MIGHT HAVE", 800, 155);
			g.drawString("SOMETHING TO SAY", 800, 175);
			g.drawString("8: A SANDCLOCK TO SHOW WHAT IS", 800, 195);
			g.drawString("THE TIME IN THE ROOM", 800, 215);
			g.drawString("~ : A SONG THAT MAY SING ANSWER", 800, 235);
			g.drawString("D: THE DOOR THAT LEAD YOU", 800, 255);
			g.drawString("TO THE NEXT ROOM", 800, 275);
			g.drawString("O: THE SIGN TO GUIDE YOU!", 800, 295);
			g.drawString("!: A MASTER KEY", 800, 315);
			g.drawString("@: A COMPUTER TO SEARCH", 800, 335);
			}
			else if(roomNumber == 2) {
				g.drawString("DICTIONARY: ", 800, 135);
				g.setFont(new Font("arial", Font.PLAIN, 15));
				g.drawString("* : A ROLLED PAPER MIGHT HAVE", 800, 155);
				g.drawString("SOMETHING TO SAY", 800, 175);
				g.drawString("8: A SANDCLOCK TO SHOW WHAT IS", 800, 195);
				g.drawString("THE TIME IN THE ROOM", 800, 215);
				g.drawString("~ : A SONG THAT MAY SING ANSWER", 800, 235);
				g.drawString("D: THE DOOR THAT LEAD YOU", 800, 255);
				g.drawString("TO THE NEXT ROOM", 800, 275);
				g.drawString("O: THE SIGN TO GUIDE YOU!", 800, 295);
				g.drawString("!: A MASTER KEY", 800, 315);
				g.drawString("@: A COMPUTER TO SEARCH", 800, 335);
				g.drawString("%: A CALCULATOR", 800,355);
			}
		}
	}
		if(Functions.isEnd() == true) {
			g.setColor(Color.BLACK);
			g.fillRect(0,0, Reference.windowWidth, Reference.windowHeight);
			g.setColor(Color.WHITE);
			g.drawRoundRect(5,5, Reference.windowWidth - 10, Reference.windowHeight - 10, 5,5 );
			g.setFont(new Font("arial", Font.PLAIN, 30));
			g.drawString("'A'", 550, 200);
			g.drawString("CONGRATULATION!", 430, 250);
			g.drawString("YOU HAVE ESCAPED!!", 410, 300);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(Reference.player.isAlive()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				Reference.player.setFacing(Direction.FORWARD);
				Functions.handlePlayerMovement(Direction.FORWARD);
				Reference.currentRoom.updatePlayerPos();
				break;
			case KeyEvent.VK_S:
				Reference.player.setFacing(Direction.BACKWARD);
				Functions.handlePlayerMovement(Direction.BACKWARD);
				Reference.currentRoom.updatePlayerPos();
				break;
			case KeyEvent.VK_D:
				Reference.player.setFacing(Direction.RIGHT);
				Functions.handlePlayerMovement(Direction.RIGHT);
				Reference.currentRoom.updatePlayerPos();
				break;
			case KeyEvent.VK_A:
				Reference.player.setFacing(Direction.LEFT);
				Functions.handlePlayerMovement(Direction.LEFT);
				Reference.currentRoom.updatePlayerPos();
				break;
			case KeyEvent.VK_Y:
				if(Functions.isAsking() == true) {
					Functions.makingDecision(true);
					Reference.currentRoom.updatePlayerPos();
					break;
				}
			case KeyEvent.VK_N:
				if(Functions.isAsking() == true) {
					Functions.makingDecision(false);
					Reference.currentRoom.updatePlayerPos();
					break;
				}
			}
		}else {
			Main.initGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
//	public static boolean isKeyFound() {
//		return keyFound;
//	}
}
