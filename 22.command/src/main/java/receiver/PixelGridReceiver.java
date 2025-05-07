package receiver;

public class PixelGridReceiver {

	private static final int GRID_SIZE = 8;
	private final int[][] pixelGrid;

	public PixelGridReceiver() {
		this.pixelGrid = new int[GRID_SIZE][GRID_SIZE];
	}

	public int[][] getPixelGrid() {
		return pixelGrid;
	}

	public void togglePixel(int x, int y) {
		if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
			pixelGrid[y][x] = pixelGrid[y][x] == 0 ? 1 : 0;
		}
	}

	public void generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("int[][] pixelArt = {\n");

		for (int i = 0; i < pixelGrid.length; i++) {
			sb.append("    {");
			for (int j = 0; j < pixelGrid[i].length; j++) {
				sb.append(pixelGrid[i][j]);
				if (j < pixelGrid[i].length - 1) {
					sb.append(", ");
				}
			}
			sb.append("}");
			if (i < pixelGrid.length - 1) {
				sb.append(",");
			}
			sb.append("\n");
		}

		sb.append("};");
		System.out.println(sb);
	}
}
