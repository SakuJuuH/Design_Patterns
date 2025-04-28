package map;

import tile.Tile;
import tile.TileFactory;

import java.util.Random;

public class WildernessMap extends Map {

	private final Random random = new Random();
	private final String[] tileTypes = {"forest", "swamp", "water"};

	@Override
	Tile createTile() {

		String tileType = tileTypes[random.nextInt(tileTypes.length)];

		return TileFactory.getTile(tileType);
	}
}
