package tile.graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TileGraphic {

	private final Image image;

	public TileGraphic(String path) {
		this.image = new Image(path);
	}

	public void draw(GraphicsContext gc, double x, double y, double size) {
		if (gc == null) return;
		gc.drawImage(image, x, y, size, size);
	}

	public Image getImage() {
		return image;
	}
}
