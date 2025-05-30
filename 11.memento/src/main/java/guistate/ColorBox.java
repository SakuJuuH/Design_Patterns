package guistate;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox {

	private final Rectangle rectangle;
	private final Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};
	private final int id;
	private final Controller controller;
	private int colorIndex = 0;

	public ColorBox(int id, Controller controller) {
		this.id = id;
		this.controller = controller;

		rectangle = new Rectangle(100, 100);
		rectangle.setFill(colors[colorIndex]);

		rectangle.setOnMouseClicked(event -> {
			changeColor();
			controller.setOption(id, colorIndex);
		});
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	private void changeColor() {
		colorIndex = (colorIndex + 1) % colors.length;
		rectangle.setFill(colors[colorIndex]);
	}

	public void setColor(int colorIndex) {
		this.colorIndex = colorIndex;
		rectangle.setFill(colors[colorIndex]);
	}

}
