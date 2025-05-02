import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatMediator implements IMediator {

	private final List<User> users = new ArrayList<>();
	private final Map<User, ChatController> userControllers = new ConcurrentHashMap<>();

	@Override
	public void sendMessage(String message, User sender, User receiver) {
		ChatController senderController = userControllers.get(sender);
		ChatController receiverController = userControllers.get(receiver);

		if (receiverController != null) {
			receiverController.displayReceivedMessage(message, sender);
		} else {
			System.err.println("Mediator: No controller found for receiver " + receiver.getUsername());
			if (senderController != null) {
				senderController.displayMessage(
						"[System: User " + receiver.getUsername() + " is offline or unavailable]");
			}
		}

		if (senderController != null) {
			senderController.displayMessage("[Me -> " + receiver.getUsername() + "]: " + message);
		} else {
			System.err.println("Mediator: No controller found for sender " + sender.getUsername());
		}
	}

	@Override
	public void addUser(User user) {
		if (!users.contains(user)) {
			users.add(user);
			user.setChatMediator(this);

			ChatController newUserController = userControllers.get(user);
			for (Map.Entry<User, ChatController> entry : userControllers.entrySet()) {
				User existingUser = entry.getKey();
				ChatController existingController = entry.getValue();
				if (!existingUser.equals(user)) {
					existingController.handleUserAdded(user);
					if (newUserController != null) {
						newUserController.handleUserAdded(existingUser);
					}
				}
			}
			System.out.println("Mediator: User added - " + user.getUsername());
		} else {
			System.err.println("Mediator: User already exists - " + user.getUsername());
		}
	}

	@Override
	public List<User> getUsers() {
		return List.copyOf(users);
	}

	@Override
	public void registerController(User user, ChatController controller) {
		System.out.println("Mediator: Registering controller for " + user.getUsername());
		userControllers.put(user, controller);

		if (!users.contains(user)) {
			addUser(user);
		} else {
			for (User existingUser : users) {
				if (!existingUser.equals(user)) {
					controller.handleUserAdded(existingUser);
				}
			}
		}
	}

	@Override
	public void unregisterController(User user) {
		System.out.println("Mediator: Unregistering controller for " + user.getUsername());
		userControllers.remove(user);

		for (ChatController controller : userControllers.values()) {
			controller.handleUserRemoved(user);
		}
	}
}