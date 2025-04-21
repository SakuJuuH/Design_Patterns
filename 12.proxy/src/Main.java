import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		// 1. Create Users
		User alice = new User("alice");
		User bob = new User("bob");
		System.out.println("Created users: " + alice.username + ", " + bob.username);
		System.out.println("---");

		// 2. Create Documents
		Document doc1 = new Document(1L, LocalDate.now(), "This is the content of the first document (unprotected).");
		Document doc2 =
				new Document(2L, LocalDate.now(), "This is the SECRET content of the second document (protected).");
		System.out.println("Created documents with IDs: " + doc1.getId() + ", " + doc2.getId());
		System.out.println("---");

		// 3. Get Access Control Service instance
		AccessControlService accessControl = AccessControlService.getInstance();
		System.out.println("AccessControlService obtained.");
		System.out.println("---");

		// 4. Create Library
		Library library = new Library();
		System.out.println("Library created.");
		System.out.println("---");

		// 5. Add unprotected document directly
		System.out.println("Adding unprotected document " + doc1.getId() + " to the library...");
		library.addDocument(doc1);
		System.out.println("Document " + doc1.getId() + " added.");
		System.out.println("---");

		// 6. Register and add protected document
		System.out.println("Registering document " + doc2.getId() + " with AccessControlService...");
		accessControl.registerDocument(doc2.getId());
		System.out.println("Document " + doc2.getId() + " registered.");

		System.out.println("Adding protected document " + doc2.getId() + " to the library (via proxy)...");
		library.addProtectedDocument(doc2); // This adds the DocumentProxy
		System.out.println("Protected document " + doc2.getId() + " added.");
		System.out.println("---");

		// 7. Grant access
		System.out.println("Granting access for user '" + alice.username + "' to document " + doc2.getId() + "...");
		accessControl.grantAccess(doc2.getId(), alice.username);
		System.out.println("Access granted.");
		System.out.println("User '" + bob.username + "' does NOT have access to document " + doc2.getId());
		System.out.println("---");

		// 8. Demonstrate Access Attempts

		// Scenario 1: Alice accesses unprotected doc1 (should succeed)
		System.out.println(
				"Attempting access: User '" + alice.username + "' -> Document " + doc1.getId() + " (unprotected)");
		try {
			IDocument retrievedDoc1 = library.getDocument(doc1.getId());
			String content = retrievedDoc1.getContent(alice); // AccessControl not involved for direct Document
			System.out.println("  Success! Content: \"" + content + "\"");
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");

		// Scenario 2: Bob accesses unprotected doc1 (should succeed)
		System.out.println(
				"Attempting access: User '" + bob.username + "' -> Document " + doc1.getId() + " (unprotected)");
		try {
			IDocument retrievedDoc1 = library.getDocument(doc1.getId());
			String content = retrievedDoc1.getContent(bob); // AccessControl not involved for direct Document
			System.out.println("  Success! Content: \"" + content + "\"");
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");

		// Scenario 3: Alice accesses protected doc2 (should succeed - has permission)
		System.out.println(
				"Attempting access: User '" + alice.username + "' -> Document " + doc2.getId() + " (protected)");
		try {
			IDocument retrievedDoc2 = library.getDocument(doc2.getId()); // Gets the DocumentProxy
			String content = retrievedDoc2.getContent(alice); // Proxy checks access via AccessControlService
			System.out.println("  Success! Content: \"" + content + "\"");
		} catch (AccessDeniedException e) {
			System.out.println("  Failed! Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");

		// Scenario 4: Bob accesses protected doc2 (should fail - no permission)
		System.out.println(
				"Attempting access: User '" + bob.username + "' -> Document " + doc2.getId() + " (protected)");
		try {
			IDocument retrievedDoc2 = library.getDocument(doc2.getId()); // Gets the DocumentProxy
			String content = retrievedDoc2.getContent(bob); // Proxy checks access via AccessControlService
			System.out.println("  Success! Content: \"" + content + "\""); // Should not reach here
		} catch (AccessDeniedException e) {
			System.out.println("  Failed as expected! Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");

		// Scenario 5: Try granting access to an unregistered document (should fail)
		System.out.println(
				"Attempting to grant access for user '" + alice.username + "' to an unregistered document (ID 99L)...");
		try {
			accessControl.grantAccess(99L, alice.username);
			System.out.println("  Success! (This should ideally not happen if unregistered)"); // Should not reach here
		} catch (AccessDeniedException e) {
			System.out.println("  Failed as expected! Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");


		// Scenario 6: Try getting content from a non-existent document in library (should fail)
		System.out.println("Attempting to get non-existent document (ID 100L) from library...");
		try {
			IDocument nonExistentDoc = library.getDocument(100L);
			System.out.println("  Success! (This should not happen)"); // Should not reach here
		} catch (IllegalArgumentException e) {
			System.out.println("  Failed as expected! Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("  Failed! Unexpected error: " + e.getMessage());
		}
		System.out.println("---");

		System.out.println("Demonstration complete.");
	}
}