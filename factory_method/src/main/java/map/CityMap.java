package map;

import Tile.BuildingTile;
import Tile.ForestTile;
import Tile.RoadTile;
import Tile.Tile;

import java.util.Random;

public class CityMap extends Map {

	private final Random random = new Random();
	private final String[] tileTypes = {"forest", "road", "building"};

	@Override
	Tile createTile() {

		String tileType = tileTypes[random.nextInt(tileTypes.length)];

		return switch (tileType) {
			case "forest" -> new ForestTile();
			case "road" -> new RoadTile();
			case "building" -> new BuildingTile();
			default -> throw new IllegalArgumentException("Unknown tile type: " + tileType);
		};
	}
}
