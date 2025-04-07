public class DevelopmentSuggestionHandler extends FeedbackHandler {
	@Override
	public void handleFeedback(Message message) {
		if (message.getMessageType() == Type.DEVELOPMENT_SUGGESTION) {
			System.out.println("Handling development suggestion: " + message.getMessageContent());
			System.out.println("Sender email: " + message.getSenderEmail());
			System.out.println("Development suggestion processed.");
		} else if (nextHandler != null) {
			nextHandler.handleFeedback(message);
		} else {
			System.out.println("No handler found for message type: " + message.getMessageType());
		}
	}
}
