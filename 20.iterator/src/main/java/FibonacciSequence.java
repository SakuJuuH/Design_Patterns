import java.util.Iterator;

// This class could also implement Iterator<Integer> in addition,
// which would make using an enhanced for-loop possible in the main program
public class FibonacciSequence implements Sequence {

	private final int limit;

	// Sequence where the limit can be modified
	public FibonacciSequence(int limit) {
		if (limit < 0) {
			throw new IllegalArgumentException("Limit cannot be negative");
		}
		this.limit = limit;
	}

	// A default sequence that goes until it reaches the Integer limit.
	// This limit is never reached due to Integer Overflow.
	public FibonacciSequence() {
		this(Integer.MAX_VALUE);
	}

	// Initialize iterator with default or modified limit
	@Override
	public Iterator<Integer> iterator() {
		// Pass the stored limit to the iterator
		return new FibonacciIterator(this.limit);
	}
}