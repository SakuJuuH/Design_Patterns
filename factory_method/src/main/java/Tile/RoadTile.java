package Tile;

public class RoadTile implements Tile {

	@Override
	public char getCharacter() {
		return 'R';
	}

	@Override
	public String getType() {
		return "road";
	}
}
