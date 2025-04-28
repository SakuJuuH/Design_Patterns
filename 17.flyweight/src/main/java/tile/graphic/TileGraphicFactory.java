package tile.graphic;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

	private static final Map<String, TileGraphic> tileGraphicCache = new HashMap<>();

	private TileGraphicFactory() {
	}

	public static TileGraphic getTileGraphic(String tileType) {
		return tileGraphicCache.computeIfAbsent(tileType, type -> {
			System.out.println("Creating new graphic for tile type: " + type);
			String resourcePath = "graphics/" + type + ".png";
			return new TileGraphic(resourcePath);
		});
	}

	public static void clearCache() {
		tileGraphicCache.clear();
	}

	public static int getCacheSize() {
		return tileGraphicCache.size();
	}

}
