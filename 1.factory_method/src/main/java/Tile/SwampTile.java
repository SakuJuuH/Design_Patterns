package Tile;

public class SwampTile implements Tile {

	@Override
	public char getCharacter() {
		return 'S';
	}

	@Override
	public String getType() {
		return "swamp";
	}
}
