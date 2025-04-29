import java.util.*;
import java.util.stream.Collectors;

public class Main {

	/*
	Main class created with the help of AI Assistant
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Recommendation> recommendations = new HashMap<>();
		List<Book> availableBooks = initializeAvailableBooks();

		// Initialize with some default recommendations
		initializeRecommendations(recommendations, availableBooks);

		while (true) {
			printMenu();
			int choice = getUserChoice(scanner);

			switch (choice) {
				case 1 -> viewRecommendations(recommendations);
				case 2 -> cloneAndModifyRecommendation(recommendations, availableBooks, scanner);
				case 3 -> {
					System.out.println("Exiting program. Goodbye!");
					scanner.close();
					return;
				}
				default -> System.out.println("Invalid choice. Please try again.");
			}
			System.out.println("\n----------------------------------------\n");
		}
	}

	private static List<Book> initializeAvailableBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Dune", "Frank Herbert", "Science Fiction", 1965));
		books.add(new Book("Foundation", "Isaac Asimov", "Science Fiction", 1951));
		books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813));
		books.add(new Book("1984", "George Orwell", "Dystopian", 1949));
		books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
		books.add(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Non-Fiction", 2011));
		books.add(new Book("A Brief History of Time", "Stephen Hawking", "Science", 1988));
		books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954));
		return books;
	}

	private static void initializeRecommendations(Map<String, Recommendation> recommendations,
	                                              List<Book> availableBooks) {
		Recommendation sciFiFans = new Recommendation("Sci-Fi Fans");
		sciFiFans.addBook(availableBooks.get(0)); // Dune
		sciFiFans.addBook(availableBooks.get(1)); // Foundation
		sciFiFans.addBook(availableBooks.get(6)); // A Brief History of Time
		recommendations.put(sciFiFans.getTargetAudience(), sciFiFans);

		Recommendation fantasyLovers = new Recommendation("Fantasy Lovers");
		fantasyLovers.addBook(availableBooks.get(4)); // The Hobbit
		fantasyLovers.addBook(availableBooks.get(7)); // The Lord of the Rings
		recommendations.put(fantasyLovers.getTargetAudience(), fantasyLovers);

		Recommendation generalReaders = new Recommendation("General Readers");
		generalReaders.addBook(availableBooks.get(2)); // Pride and Prejudice
		generalReaders.addBook(availableBooks.get(3)); // 1984
		generalReaders.addBook(availableBooks.get(5)); // Sapiens
		recommendations.put(generalReaders.getTargetAudience(), generalReaders);
	}

	private static void printMenu() {
		System.out.println("Recommendation System Menu:");
		System.out.println("1. View All Recommendations");
		System.out.println("2. Clone and Modify a Recommendation");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
	}

	private static int getUserChoice(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.print("Invalid input. Please enter a number: ");
			scanner.next(); // Consume the invalid input
		}
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		return choice;
	}

	private static void viewRecommendations(Map<String, Recommendation> recommendations) {
		if (recommendations.isEmpty()) {
			System.out.println("No recommendations available.");
			return;
		}
		System.out.println("\nCurrent Recommendations:");
		recommendations.values().forEach(System.out::println);
	}

	private static void cloneAndModifyRecommendation(Map<String, Recommendation> recommendations,
	                                                 List<Book> availableBooks, Scanner scanner) {
		if (recommendations.isEmpty()) {
			System.out.println("No recommendations available to clone.");
			return;
		}

		System.out.println("\nAvailable recommendations to clone:");
		List<String> audienceList = new ArrayList<>(recommendations.keySet());
		for (int i = 0; i < audienceList.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, audienceList.get(i));
		}
		System.out.print("Select the number of the recommendation to clone: ");
		int cloneChoice = getUserChoice(scanner);

		if (cloneChoice < 1 || cloneChoice > audienceList.size()) {
			System.out.println("Invalid selection.");
			return;
		}

		String originalAudience = audienceList.get(cloneChoice - 1);
		Recommendation original = recommendations.get(originalAudience);

		// --- Prototype Pattern in action ---
		Recommendation cloned = original.clone();
		// --- End Prototype Pattern ---

		System.out.printf("Cloned '%s'. Enter a new target audience name for this clone: ", originalAudience);
		String newAudience = scanner.nextLine();
		if (newAudience.trim().isEmpty()) {
			System.out.println("Audience name cannot be empty. Using default.");
			newAudience = "Copy of " + originalAudience;
		}
		if (recommendations.containsKey(newAudience)) {
			System.out.printf(
					"Warning: A recommendation for '%s' already exists. It will be overwritten if you save changes.%n",
					newAudience);
		}
		cloned.setTargetAudience(newAudience);


		// Modify the clone
		modifyClonedRecommendation(cloned, availableBooks, scanner);

		// Save the new/modified clone
		recommendations.put(cloned.getTargetAudience(), cloned);
		System.out.printf("New recommendation list '%s' created and saved based on '%s'.%n", cloned.getTargetAudience(),
		                  originalAudience);
		System.out.println("\nFinal state of the cloned list:");
		System.out.println(cloned);
	}

	private static void modifyClonedRecommendation(Recommendation cloned, List<Book> availableBooks, Scanner scanner) {
		while (true) {
			System.out.println("\nModifying Recommendation for: " + cloned.getTargetAudience());
			System.out.println("Current Books: " + (cloned.getRecommendedBooks().isEmpty() ? "None" :
			                                        cloned.getRecommendedBooks().stream().map(Book::title)
			                                              .collect(Collectors.joining(", "))));
			System.out.println("Modification Options:");
			System.out.println("1. Add a Book");
			System.out.println("2. Remove a Book");
			System.out.println("3. Change Target Audience");
			System.out.println("4. Finish Modifying");
			System.out.print("Enter your choice: ");
			int modChoice = getUserChoice(scanner);

			switch (modChoice) {
				case 1:
					addBookToRecommendation(cloned, availableBooks, scanner);
					break;
				case 2:
					removeBookFromRecommendation(cloned, scanner);
					break;
				case 3:
					System.out.print("Enter the new target audience: ");
					String audience = scanner.nextLine();
					if (!audience.trim().isEmpty()) {
						cloned.setTargetAudience(audience);
						System.out.println("Target audience updated to: " + audience);
					} else {
						System.out.println("Target audience cannot be empty.");
					}
					break;
				case 4:
					System.out.println("Finished modifying.");
					return; // Exit modification loop
				default:
					System.out.println("Invalid choice.");
					break;
			}
		}
	}

	private static void addBookToRecommendation(Recommendation recommendation, List<Book> availableBooks,
	                                            Scanner scanner) {
		System.out.println("\nAvailable books to add:");
		for (int i = 0; i < availableBooks.size(); i++) {
			System.out.printf("%d. %s by %s (%s, %d)%n",
			                  i + 1,
			                  availableBooks.get(i).title(),
			                  availableBooks.get(i).author(),
			                  availableBooks.get(i).genre(),
			                  availableBooks.get(i).publicationYear());
		}
		System.out.print("Select the number of the book to add (or 0 to cancel): ");
		int bookChoice = getUserChoice(scanner);

		if (bookChoice > 0 && bookChoice <= availableBooks.size()) {
			Book bookToAdd = availableBooks.get(bookChoice - 1);
			try {
				recommendation.addBook(bookToAdd);
				System.out.printf("Book '%s' added.%n", bookToAdd.title());
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else if (bookChoice != 0) {
			System.out.println("Invalid book selection.");
		} else {
			System.out.println("Add book cancelled.");
		}
	}

	private static void removeBookFromRecommendation(Recommendation recommendation, Scanner scanner) {
		List<Book> currentBooks = recommendation.getRecommendedBooks(); // Gets a copy
		if (currentBooks.isEmpty()) {
			System.out.println("No books in the current recommendation to remove.");
			return;
		}

		System.out.println("\nBooks in the current recommendation:");
		for (int i = 0; i < currentBooks.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, currentBooks.get(i).title());
		}
		System.out.print("Select the number of the book to remove (or 0 to cancel): ");
		int bookChoice = getUserChoice(scanner);

		if (bookChoice > 0 && bookChoice <= currentBooks.size()) {
			Book bookToRemove = currentBooks.get(bookChoice - 1); // Get book from the copy
			try {
				// Need to find the equivalent book in the actual list if using contains/remove by object
				// Since Book has no equals/hashCode, removing by the exact object reference from the copy won't work directly.
				// A safer way is to remove based on a unique identifier like name, or implement equals/hashCode in Book.
				// For simplicity here, let's find by name.

				Book actualBookToRemove = null;
				for (Book b : recommendation.getRecommendedBooks()) { // Iterate internal list
					if (b.title().equals(bookToRemove.title())) { // Simple name comparison
						actualBookToRemove = b;
						break;
					}
				}

				if (actualBookToRemove != null) {
					recommendation.removeBook(actualBookToRemove);
					System.out.printf("Book '%s' removed.%n", bookToRemove.title());
				} else {
					System.out.println(
							"Error: Could not find the exact book instance to remove."); // Should not happen with name matching
				}

			} catch (IllegalArgumentException e) {
				// This might happen if the list was modified concurrently, unlikely here.
				System.out.println("Error: " + e.getMessage());
			}
		} else if (bookChoice != 0) {
			System.out.println("Invalid book selection.");
		} else {
			System.out.println("Remove book cancelled.");
		}
	}
}