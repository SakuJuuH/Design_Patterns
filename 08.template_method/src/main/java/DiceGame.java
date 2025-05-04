import java.util.Random;

public class DiceGame extends Game {

	private final Random random = new Random();
	private int[] scores;
	private int winner;


	@Override
	public void initializeGame(int numberOfPlayers) {
		scores = new int[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Player " + (i + 1) + " is ready to play!");
		}
	}

	@Override
	public boolean endOfGame() {
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= 100) {
				winner = i;
				return true;
			}
		}
		return false;
	}

	@Override
	public void playSingleTurn(int player) {
		int roll = random.nextInt(6) + 1; // Simulate a dice roll (1-6)
		System.out.printf("Player %d rolled: %d%n", player + 1, roll);
		scores[player] += roll;

		if (scores[player] >= 100) {
			System.out.printf("Player %d wins with a score of %d!%n", player + 1, scores[player]);
		} else {
			System.out.printf("Player %d's score: %d%n", player + 1, scores[player]);
		}
		System.out.println();
	}

	@Override
	public void displayWinner() {
		System.out.printf("Player %d wins the game with a score of %d!%n", winner + 1, scores[winner]);
		System.out.println("Scores: ");
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("Player %d: %d%n", i + 1, scores[i]);
		}
		System.out.println();
	}
}
