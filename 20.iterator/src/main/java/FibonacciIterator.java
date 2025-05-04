import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
	private final int limit;

	// Storing the entire state here makes the FibonacciSequence class more simple
	// therefore, it has been implemented here.
	private int current = 0;
	private int next = 1;
	private int count = 0;

	// Constructor for a sequence with a set limit
	public FibonacciIterator(int limit) {
		// State is managed here so each iterator is independent.
		// The limit is passed from the sequence.
		if (limit < 0) {
			throw new IllegalArgumentException("Limit cannot be negative");
		}
		this.limit = limit;
	}

	// Constructor for a sequence with the default limit of the maximum integer value
	// This limit will never be reached due to Integer Overflow.
	public FibonacciIterator() {
		this(Integer.MAX_VALUE);
	}


	// Checks if the sequence has a next value.
	// Determined if the given limit is less than the current count of generated fibonacci numbers and
	// if next is not a negative caused by an Integer Overflow.
	@Override
	public boolean hasNext() {
		return count < limit && next > 0;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("Fibonacci sequence limit reached or overflow occurred.");
		}

		// Store the number to be returned
		int result = next;

		// Calculate the next pair, checking for potential overflow before assignment
		int temp;
		try {
			// Math.addExact method has to be used to add the values, otherwise an Integer Overflow will happen,
			// and the program will start using negative numbers.
			temp = Math.addExact(current, next);
		} catch (ArithmeticException e) {
			// Math.addExact throws an ArithmeticException in the case of an overflow.
			// If this happens, we will set the count to the limit which will terminate the sequence
			// from generating more numbers.
			count = limit;

			return result;
		}

		// Update state
		current = next;
		next = temp;
		count++;

		return result;
	}
}