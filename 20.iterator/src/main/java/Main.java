import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		// Generate the first 10 Fibonacci numbers
		int desiredLimit = 10;
		System.out.println("Generating the first " + desiredLimit + " Fibonacci numbers:");
		FibonacciSequence sequenceWithLimit = new FibonacciSequence(desiredLimit);
		Iterator<Integer> iteratorWithLimit = sequenceWithLimit.iterator();
		while (iteratorWithLimit.hasNext()) {
			System.out.println(iteratorWithLimit.next());
		}

		// Generate fibonacci numbers until the program is stopped.
		System.out.println("\nGenerating Fibonacci numbers (default limit):");
		FibonacciSequence sequenceDefault = new FibonacciSequence();
		Iterator<Integer> iteratorDefault = sequenceDefault.iterator();
		while (iteratorDefault.hasNext()) {
			System.out.println(iteratorDefault.next());
		}
	}
}