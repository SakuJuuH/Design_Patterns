package map;

import Tile.Tile;

public abstract class Map {

	abstract Tile createTile();

	public void display() {
		Tile[][] mapGrid = new Tile[5][5];

		for (int i = 0; i < mapGrid.length; i++) {
			for (int j = 0; j < mapGrid[0].length; j++) {
				mapGrid[i][j] = createTile();
			}
		}

		for (Tile[] tiles : mapGrid) {
			for (int j = 0; j < mapGrid[0].length; j++) {
				System.out.print(tiles[j].getCharacter() + " ");
			}
			System.out.println();
		}
	}
}