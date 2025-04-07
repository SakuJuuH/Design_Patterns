public class ContactRequestHandler extends FeedbackHandler {
	@Override
	public void handleFeedback(Message message) {
		if (message.getMessageType() == Type.CONTACT_REQUEST) {
			System.out.println("Handling contact request: " + message.getMessageContent());
			System.out.println("Sender email: " + message.getSenderEmail());
			System.out.println("Contact request processed.");
		} else if (nextHandler != null) {
			nextHandler.handleFeedback(message);
		} else {
			System.out.println("No handler found for message type: " + message.getMessageType());
		}
	}
}
