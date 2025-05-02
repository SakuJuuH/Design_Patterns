public class User {
	protected final String username;
	private IMediator chatMediator;

	public User(String username) {
		this.username = username;
	}

	public void setChatMediator(IMediator chatMediator) {
		this.chatMediator = chatMediator;
	}

	public void send(String message, User receiver) {
		if (chatMediator == null) {
			System.err.println("Error: Mediator not set for user " + username);
			return;
		}
		if (receiver == null) {
			System.err.println("Error: Receiver cannot be null for user " + username);
			return;
		}
		// Delegate sending to the mediator
		chatMediator.sendMessage(message, this, receiver);
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return username.equals(user.username);
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}
}