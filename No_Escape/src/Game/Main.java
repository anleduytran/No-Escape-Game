package Game;

import javax.swing.JFrame;

import Game.Entity.Player;
import Game.Entity.Room;
import Game.GUI.GameBoard;
import Game.Util.Functions;


public class Main {
	private static JFrame window;
	private static GameBoard gameBoard;
	
	public static void main(String[] args) {
		System.out.println("Starting...");
		createWindow();
		createGameBoard();
		initGame();
	}
	
	private static void createWindow() {
		System.out.println("[Main]: Creating Window");
		window = new JFrame ("No Escape!");
		window.setVisible(true);
		window.setResizable(false);
		window.setBounds(1366/2 - Reference.windowWidth/2, 768/2 - Reference.windowHeight/2, Reference.windowWidth, Reference.windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void createGameBoard() {
		System.out.println("[Main]: Creating GameBoard");
		gameBoard = new GameBoard();
		window.add(gameBoard);
		gameBoard.requestFocusInWindow();
		
	}
	
	//Start game
	
	public static void initGame() {
		//initialize
		Reference.currentRoom = new Room(0);
		Reference.player = new Player(36,15);
		
		Functions.initMovingTiles();
	}
}
