public record Book(String title, String author, String genre, int publicationYear) implements Cloneable {

	@Override
	public int hashCode() {
		return title.hashCode() + author.hashCode() + genre.hashCode() + publicationYear;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return publicationYear == book.publicationYear &&
		       title.equals(book.title) &&
		       author.equals(book.author) &&
		       genre.equals(book.genre);
	}

	@Override
	public Book clone() {
		try {
			return (Book) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Cloning failed for Book", e);
		}
	}

	@Override
	public String toString() {
		return String.format("%s by %s (%s)", title, author, genre);
	}
}
