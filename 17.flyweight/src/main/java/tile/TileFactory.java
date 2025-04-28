package tile;

import java.util.HashMap;
import java.util.Map;

public class TileFactory {

	private static final Map<String, Tile> tileCache = new HashMap<>();

	private TileFactory() {
	}

	public static Tile getTile(String type) {
		Tile tile = tileCache.get(type);

		if (tile == null) {
			tile = switch (type) {
				case "forest" -> new ForestTile();
				case "swamp" -> new SwampTile();
				case "water" -> new WaterTile();
				case "road" -> new RoadTile();
				case "building" -> new BuildingTile();
				default -> throw new IllegalArgumentException("Unknown tile type: " + type);
			};
			System.out.println("Creating new tile of type: " + type);
			tileCache.put(type, tile);
		} else {
			System.out.println("Reusing existing tile of type: " + type);
		}
		return tile;
	}

	public static void clearCache() {
		tileCache.clear();
	}

	public static int getCacheSize() {
		return tileCache.size();
	}
}
