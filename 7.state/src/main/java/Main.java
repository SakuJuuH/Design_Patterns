import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Character Development System!");
		System.out.print("Enter your character's name: ");
		String name = scanner.nextLine();

		Character character = new Character(name);
		boolean running = true;

		System.out.println("\nCharacter created! Let's begin your journey.");

		while (running) {
			System.out.println("\n==== Character Status ====");
			character.displayStats();

			System.out.println("\nAvailable actions:");
			System.out.println("1. Train");

			if (!(character.getCurrentLevel() instanceof Novice)) {
				System.out.println("2. Meditate");
			}

			if (character.getCurrentLevel() instanceof Expert) {
				System.out.println("3. Fight");
			}

			System.out.println("0. Exit game");

			System.out.print("\nSelect an action: ");
			int choice;
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
				continue;
			}

			switch (choice) {
				case 1:
					System.out.println("\n>>> Training...");
					character.train();
					break;
				case 2:
					System.out.println("\n>>> Meditating...");
					character.meditate();
					break;
				case 3:
					System.out.println("\n>>> Fighting...");
					character.fight();
					break;
				case 0:
					running = false;
					System.out.println("\nThank you for playing!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}

			if (character.getCurrentLevel() instanceof Master) {
				System.out.println("\nCongratulations! You've mastered the game!");
				System.out.println("Final stats:");
				character.displayStats();
				running = false;
			}

			if (running) {
				System.out.println("\nPress Enter to continue...");
				scanner.nextLine();
			}
		}

		scanner.close();
	}
}