public class GeneralFeedbackHandler extends FeedbackHandler {
	@Override
	public void handleFeedback(Message message) {
		if (message.getMessageType() == Type.GENERAL_FEEDBACK) {
			System.out.println("Handling general feedback: " + message.getMessageContent());
			System.out.println("Sender email: " + message.getSenderEmail());
			System.out.println("General feedback processed.");
		} else if (nextHandler != null) {
			nextHandler.handleFeedback(message);
		} else {
			System.out.println("No handler found for message type: " + message.getMessageType());
		}
	}
}
