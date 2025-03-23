package map;

import Tile.ForestTile;
import Tile.SwampTile;
import Tile.Tile;
import Tile.WaterTile;

import java.util.Random;

public class WildernessMap extends Map {

	private final Random random = new Random();
	private final String[] tileTypes = {"forest", "swamp", "water"};

	@Override
	Tile createTile() {

		String tileType = tileTypes[random.nextInt(tileTypes.length)];

		return switch (tileType) {
			case "forest" -> new ForestTile();
			case "swamp" -> new SwampTile();
			case "water" -> new WaterTile();
			default -> throw new IllegalArgumentException("Unknown tile type: " + tileType);
		};
	}
}
