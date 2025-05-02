import java.util.List;

public interface IMediator {
	void sendMessage(String message, User sender, User receiver);

	void addUser(User user);

	List<User> getUsers();

	void registerController(User user, ChatController controller);

	void unregisterController(User user);
}
