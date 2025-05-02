import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController extends Application {

	private final ChatMediator mediator = new ChatMediator();
	@FXML
	public TextField usernameField;
	@FXML
	public Button loginButton;

	public void handleLogin(ActionEvent actionEvent) {
		String username = usernameField.getText();

		if (username.isEmpty()) {
			showError("Username cannot be empty");
			return;
		}

		if (mediator.getUsers().stream().anyMatch(u -> u.getUsername().equals(username))) {
			showError("Username already taken");
			return;
		}

		User user = new User(username);

		try {
			FXMLLoader chatLoader = new FXMLLoader(getClass().getResource("chat.fxml"));
			Parent chatRoot = chatLoader.load();

			ChatController chatController = chatLoader.getController();

			chatController.setup(user, mediator);

			Stage chatStage = new Stage();
			chatStage.setTitle(username);
			chatStage.setScene(new Scene(chatRoot));

			chatController.setStageEventHandlers(chatStage);

			chatStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			showError("Failed to open chat window: " + e.getMessage());
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		stage.setTitle("Login");
		stage.setOnCloseRequest(e -> System.exit(0));
	}

	public void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
