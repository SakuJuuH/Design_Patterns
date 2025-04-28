import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import map.Map;
import tile.Tile;

public class View extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Flyweight exercise");

		int mapWidth = 10;
		int mapHeight = 10;

		Map map = Game.createMap();
		System.out.println("Generating map...");
		Tile[][] mapGrid = map.generateMapGrid(mapWidth, mapHeight);

		System.out.println("Rendering map...");

		double canvasWidth = 500;
		double canvasHeight = 500;

		Canvas canvas = new Canvas(canvasWidth, canvasHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		double tileSize = 50;

		map.render(mapGrid, gc, tileSize);

		StackPane root = new StackPane();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root, canvasWidth, canvasHeight);

		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
