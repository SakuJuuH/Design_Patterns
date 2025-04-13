package guistate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {

	// create a GUI with three adjacent ColorBoxes and one CheckBox below them
	private Controller controller;
	private ColorBox colorBox1;
	private ColorBox colorBox2;
	private ColorBox colorBox3;
	private CheckBox checkBox;
	private Stage historyStage;
	private ListView<String> historyListView;
	private ObservableList<String> historyItems;

	public void start(Stage stage) {

		controller = new Controller(this);

		// Insets for margin and padding
		Insets insets = new Insets(10, 10, 10, 10);

		// Create three ColorBoxes
		colorBox1 = new ColorBox(1, controller);
		colorBox2 = new ColorBox(2, controller);
		colorBox3 = new ColorBox(3, controller);

		// Create a CheckBox
		checkBox = new CheckBox("Click me!");
		checkBox.setPadding(insets);

		// Add the ColorBoxes and CheckBox to a HBox
		HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
		hBox.setSpacing(10);

		HBox.setMargin(colorBox1.getRectangle(), insets);
		HBox.setMargin(colorBox2.getRectangle(), insets);
		HBox.setMargin(colorBox3.getRectangle(), insets);


		Label label = new Label("Press Ctrl-Z to undo the last change.");
		label.setPadding(insets);

		Label label2 = new Label("Press Ctrl-Y to redo the last change.");
		label2.setPadding(insets);

		Button historyButton = new Button("Show History");

		// create a VBox that contains the HBox and the CheckBox
		VBox vBox = new VBox(hBox, checkBox, label, label2, historyButton);

		// call controller when the CheckBox is clicked
		checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected())
		);

		// Set the HBox to be the root of the Scene
		Scene scene = new Scene(vBox);

		scene.setOnKeyPressed(event -> {
			if (event.isControlDown() && event.getCode() == KeyCode.Z) {
				// Ctrl-Z: undo
				System.out.println("Undo key combination pressed");
				controller.undo();
				updateHistoryWindow();
			} else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
				// Ctrl-Y: redo
				System.out.println("Redo key combination pressed");
				controller.redo();
				updateHistoryWindow();
			}
		});

		historyButton.setOnAction(event -> {
			if (historyStage == null || !historyStage.isShowing()) {
				showHistoryWindow(stage);
			} else {
				historyStage.close();
				historyStage = null;
			}
		});

		stage.setScene(scene);
		stage.setTitle("Memento Pattern Example");
		stage.show();
	}

	private void showHistoryWindow(Stage ownerStage) {
		historyStage = new Stage();
		historyStage.setTitle("Command History");
		historyStage.initOwner(ownerStage);

		VBox content = new VBox(10);
		content.setPadding(new Insets(15));

		Label titleLabel = new Label("History");

		// Initialize the ListView and Observable List
		if (historyItems == null) {
			historyItems = FXCollections.observableArrayList();
		}
		if (historyListView == null) {
			historyListView = new ListView<>(historyItems);
			historyListView.setPrefHeight(300);
			VBox.setVgrow(historyListView, Priority.ALWAYS);
		}

		updateHistoryWindow();

		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> {
			historyStage.close();
			historyStage = null;
		});

		content.getChildren().addAll(titleLabel, historyListView, closeButton);

		Scene scene = new Scene(content, 400, 400);
		historyStage.setScene(scene);
		historyStage.show();

		historyListView.setOnMouseClicked(event -> {
			int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {

				IMemento selectedMemento = controller.getHistory().get(selectedIndex);
				controller.restoreState(selectedMemento);
				updateGui();
			}
		});
	}

	public void updateGui() {
		// called after restoring state from a Memento
		colorBox1.setColor(controller.getOption(1));
		colorBox2.setColor(controller.getOption(2));
		colorBox3.setColor(controller.getOption(3));
		checkBox.setSelected(controller.getIsSelected());
		updateHistoryWindow();
	}

	private void updateHistoryWindow() {
		if (historyListView == null) {
			return;
		}

		historyItems.clear();

		List<IMemento> history = controller.getHistory();
		int currentStateIndex = controller.getCurrentStateIndex();

		for (int i = 0; i < history.size(); i++) {
			IMemento memento = history.get(i);
			if (i == currentStateIndex) {
				historyItems.add("Current State: " + memento.toString());
			} else {
				historyItems.add(memento.toString());
			}
		}
		if (historyItems.isEmpty()) {
			historyListView.setPlaceholder(new Label("No history available"));
		} else {
			historyListView.setPlaceholder(null);
		}
		historyListView.setItems(historyItems);
		historyListView.scrollTo(historyItems.size() - 1);

		historyListView.getSelectionModel().clearSelection();
	}
}

