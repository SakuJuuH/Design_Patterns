public class Message {
	private final Type messageType;
	private final String messageContent;
	private final String senderEmail;

	public Message(Type messageType, String messageContent, String senderEmail) {
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.senderEmail = senderEmail;
	}

	public Type getMessageType() {
		return messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public String getSenderEmail() {
		return senderEmail;
	}
}
