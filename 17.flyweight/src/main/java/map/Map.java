package map;

import javafx.scene.canvas.GraphicsContext;
import tile.Tile;
import tile.graphic.TileGraphic;
import tile.graphic.TileGraphicFactory;

public abstract class Map {

	abstract Tile createTile();

	public void render(Tile[][] mapGrid, GraphicsContext gc, double tileSize) {
		if (mapGrid == null || gc == null || tileSize <= 0) {
			System.out.println("Invalid parameters");
			return;
		}

		int gridHeight = mapGrid.length;
		int gridWidth = mapGrid[0].length;

		gc.clearRect(0, 0, gridWidth * tileSize, gridHeight * tileSize);

		System.out.println("Rendering map...");
		for (int y = 0; y < gridHeight; y++) {
			for (int x = 0; x < gridWidth; x++) {
				Tile tile = mapGrid[y][x];
				if (tile != null) {
					String tileType = tile.getType();

					TileGraphic tileGraphic = TileGraphicFactory.getTileGraphic(tileType);

					double renderX = x * tileSize;
					double renderY = y * tileSize;
					tileGraphic.draw(gc, renderX, renderY, tileSize);
				}
			}
		}

		System.out.println("Rendering Complete");
		System.out.println("TileGraphic Flyweight cache size: " + TileGraphicFactory.getCacheSize());
	}

	public Tile[][] generateMapGrid(int width, int height) {
		Tile[][] mapGrid = new Tile[width][height];
		for (int i = 0; i < mapGrid.length; i++) {
			for (int j = 0; j < mapGrid[0].length; j++) {
				mapGrid[i][j] = createTile();
			}
		}
		return mapGrid;
	}
}