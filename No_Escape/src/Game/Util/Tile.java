package Game.Util;

public enum Tile {

	PATH('.'),
	CLOSEDDOOR('D'),
	WALL('#'),
	PLAYER('A'),
	HINT('?'),
	KEY(','),
	DOOR('/'),
	PAPERROLLED('*'),
	SANDCLOCK('8'),
	SONG('~'),
	STAIR('^'),
	SIGN('O'),
	MASTERKEY('!'),
	COMPUTER('@'),
	CALCULATOR('%'),
	POINTER('^');
	
	
	
	private char symbol;
	
	Tile( char symbol){
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
		}
}
