import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;

public class ChatController {

	@FXML
	public TextArea chatHistoryArea;
	@FXML
	public ComboBox<User> recipientComboBox;
	@FXML
	public TextField messageInput;
	@FXML
	public Button sendButton;

	private IMediator mediator;
	private User currentUser;

	@FXML
	public void initialize() {
		chatHistoryArea.setWrapText(true);
		recipientComboBox.setCellFactory(lv -> new ListCell<>() {
			@Override
			protected void updateItem(User item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? null : item.toString());
			}
		});
		recipientComboBox.setButtonCell(new ListCell<>() {
			@Override
			protected void updateItem(User item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? null : item.toString());
			}
		});
	}

	public void setup(User user, IMediator mediator) {
		if (user == null) {
			showAlert("Error", "Cannot setup chat controller: user is null.");
			return;
		}
		if (mediator == null) {
			showAlert("Error", "Cannot setup chat controller: mediator is null.");
			return;
		}

		this.currentUser = user;
		this.mediator = mediator;

		this.mediator.registerController(this.currentUser, this);

		updateRecipientList();
	}

	public void setStageEventHandlers(Stage stage) {
		stage.setOnCloseRequest((WindowEvent event) -> {
			System.out.println("Window closing for user: " + currentUser.getUsername());
			if (mediator != null && currentUser != null) {
				mediator.unregisterController(currentUser);
			}
		});
	}


	private void updateRecipientList() {
		if (mediator != null && currentUser != null) {
			List<User> allUsers = mediator.getUsers();
			Platform.runLater(() -> {
				User selectedRecipient = recipientComboBox.getValue();
				recipientComboBox.setItems(FXCollections.observableArrayList(
						allUsers.stream().filter(u -> !u.equals(currentUser)).toList()
				));
				if (selectedRecipient != null && recipientComboBox.getItems().contains(selectedRecipient)) {
					recipientComboBox.setValue(selectedRecipient);
				} else {
					recipientComboBox.setValue(null);
				}
			});
		}
	}

	@FXML
	public void sendMessage(ActionEvent actionEvent) {
		User recipient = recipientComboBox.getValue();
		String message = messageInput.getText();

		if (currentUser == null) {
			showAlert("Error", "Cannot send message: current user is not set.");
			return;
		}
		if (recipient == null) {
			showAlert("Error", "Please select a recipient.");
			return;
		}
		if (message == null || message.trim().isEmpty()) {
			showAlert("Error", "Cannot send an empty message.");
			return;
		}

		currentUser.send(message.trim(), recipient);

		messageInput.clear();
	}

	public void handleUserAdded(User newUser) {
		if (!newUser.equals(currentUser)) {
			Platform.runLater(() -> {
				if (!recipientComboBox.getItems().contains(newUser)) {
					recipientComboBox.getItems().add(newUser);
				}
			});
		}
	}

	public void handleUserRemoved(User removedUser) {
		if (!removedUser.equals(currentUser)) {
			Platform.runLater(() -> {
				User selectedRecipient = recipientComboBox.getValue();
				recipientComboBox.getItems().remove(removedUser);
				if (removedUser.equals(selectedRecipient)) {
					recipientComboBox.setValue(null);
				}
			});
		}
	}

	public void displayReceivedMessage(String message, User sender) {
		Platform.runLater(() -> chatHistoryArea.appendText(sender.getUsername() + ": " + message + "\n"));
	}

	public void displayMessage(String message) {
		Platform.runLater(() -> chatHistoryArea.appendText(message + "\n"));
	}

	// Helper method to show alerts
	private void showAlert(String title, String message) {
		Platform.runLater(() -> {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
		});
	}
}