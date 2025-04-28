package map;

import tile.Tile;
import tile.TileFactory;

import java.util.Random;

public class CityMap extends Map {

	private final Random random = new Random();
	private final String[] tileTypes = {"forest", "road", "building"};

	@Override
	Tile createTile() {

		String tileType = tileTypes[random.nextInt(tileTypes.length)];

		return TileFactory.getTile(tileType);
	}
}
