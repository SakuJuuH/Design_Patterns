public class Main {
	public static void main(String[] args) {

		CompensationClaimHandler compensationClaimHandler = new CompensationClaimHandler();
		ContactRequestHandler contactRequestHandler = new ContactRequestHandler();
		DevelopmentSuggestionHandler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
		GeneralFeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

		compensationClaimHandler.setNextHandler(contactRequestHandler);
		contactRequestHandler.setNextHandler(developmentSuggestionHandler);
		developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

		// Create different types of messages
		Message compensationMessage = new Message(
				Type.COMPENSATION_CLAIM,
				"My order #12345 arrived damaged. I would like a refund.",
				"customer1@example.com");

		Message contactMessage = new Message(
				Type.CONTACT_REQUEST,
				"I need to speak with someone about my account.",
				"customer2@example.com");

		Message suggestionMessage = new Message(
				Type.DEVELOPMENT_SUGGESTION,
				"It would be great if you added a dark mode to your app.",
				"customer3@example.com");

		Message generalMessage = new Message(
				Type.GENERAL_FEEDBACK,
				"I really enjoy your service. Keep up the good work!",
				"customer4@example.com");

		// Process each message through the chain
		System.out.println("=== Processing Compensation Claim ===");
		compensationClaimHandler.handleFeedback(compensationMessage);

		System.out.println("\n=== Processing Contact Request ===");
		compensationClaimHandler.handleFeedback(contactMessage);

		System.out.println("\n=== Processing Development Suggestion ===");
		compensationClaimHandler.handleFeedback(suggestionMessage);

		System.out.println("\n=== Processing General Feedback ===");
		compensationClaimHandler.handleFeedback(generalMessage);
	}
}