public class CompensationClaimHandler extends FeedbackHandler {
	@Override
	public void handleFeedback(Message message) {
		if (message.getMessageType() == Type.COMPENSATION_CLAIM) {
			System.out.println("Handling compensation claim: " + message.getMessageContent());
			System.out.println("Sender email: " + message.getSenderEmail());
			System.out.println("Compensation claim processed.");
		} else if (nextHandler != null) {
			nextHandler.handleFeedback(message);
		} else {
			System.out.println("No handler found for message type: " + message.getMessageType());
		}
	}
}
