import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
	private List<Book> recommendedBooks;
	private String targetAudience;

	public Recommendation(String targetAudience, List<Book> recommendedBooks) {
		this.targetAudience = targetAudience;
		this.recommendedBooks = new ArrayList<>(recommendedBooks);
	}

	public Recommendation(String targetAudience) {
		this(targetAudience, new ArrayList<>());
	}

	@Override
	public Recommendation clone() {
		try {
			Recommendation clonedRecommendation = (Recommendation) super.clone();
			clonedRecommendation.recommendedBooks = new ArrayList<>();

			for (Book book : recommendedBooks) {
				clonedRecommendation.recommendedBooks.add(book.clone());
			}
			return clonedRecommendation;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Cloning failed for Recommendation", e);
		}
	}

	public void addBook(Book book) {
		if (recommendedBooks.contains(book)) {
			throw new IllegalArgumentException("Book is already in the list");
		}
		this.recommendedBooks.add(book);
	}

	public void removeBook(Book book) {
		if (!recommendedBooks.contains(book)) {
			throw new IllegalArgumentException("Book is not in the list");
		}
		this.recommendedBooks.remove(book);
	}

	public List<Book> getRecommendedBooks() {
		return List.copyOf(recommendedBooks);
	}

	public String getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nRecommendation for ").append(targetAudience).append(":");
		for (Book book : recommendedBooks) {
			sb.append("\n   - ").append(book.toString());
		}
		return sb.toString();
	}
}