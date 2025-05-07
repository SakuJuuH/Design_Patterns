import command.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import receiver.CursorReceiver;
import receiver.PixelGridReceiver;

public class GUI extends Application {
	private static final int GRID_SIZE = 8;
	private static final int CELL_SIZE = 50;

	private final Rectangle[][] grid = new Rectangle[GRID_SIZE][GRID_SIZE];
	CursorReceiver cursorReceiver = new CursorReceiver();
	PixelGridReceiver pixelGridReceiver = new PixelGridReceiver();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		// Create grid
		GridPane gridPane = createGrid();
		Button button = new Button("Generate Code");

		Command togglePixel = new TogglePixelCommand(pixelGridReceiver, cursorReceiver);
		Command moveCursorUp = new MoveCursorUpCommand(cursorReceiver);
		Command moveCursorDown = new MoveCursorDownCommand(cursorReceiver);
		Command moveCursorLeft = new MoveCursorLeftCommand(cursorReceiver);
		Command moveCursorRight = new MoveCursorRightCommand(cursorReceiver);
		Command generateCode = new GenerateCodeCommand(pixelGridReceiver);

		root.setCenter(gridPane);
		root.setBottom(button);

		Scene scene = new Scene(root);

		gridPane.setFocusTraversable(true);
		button.setFocusTraversable(false);

		scene.setOnKeyReleased(event -> {
			switch (event.getCode()) {
				case SPACE -> {
					togglePixel.execute();
					updateGridDisplay();
				}
				case UP -> {
					moveCursorUp.execute();
					updateGridDisplay();
				}
				case DOWN -> {
					moveCursorDown.execute();
					updateGridDisplay();
				}
				case LEFT -> {
					moveCursorLeft.execute();
					updateGridDisplay();
				}
				case RIGHT -> {
					moveCursorRight.execute();
					updateGridDisplay();
				}
			}
			event.consume();
		});

		button.setOnMouseClicked(event -> generateCode.execute());

		// Set stage
		primaryStage.setTitle("Pixel Art Editor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane createGrid() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(2);
		gridPane.setVgap(2);

		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
				cell.setFill(Color.WHITE);
				cell.setStroke(Color.BLACK);
				grid[row][col] = cell;
				gridPane.add(cell, col, row);
			}
		}

		updateGridDisplay();

		return gridPane;
	}

	private void updateGridDisplay() {
		// Reset all cells to their proper state first
		int[][] pixelGrid = pixelGridReceiver.getPixelGrid();
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				grid[row][col].setFill(pixelGrid[row][col] == 1 ? Color.BLACK : Color.WHITE);
			}
		}

		// Highlight the cursor position with a different color
		int cursorX = cursorReceiver.getX();
		int cursorY = cursorReceiver.getY();
		grid[cursorY][cursorX].setFill(Color.RED);
	}
}
