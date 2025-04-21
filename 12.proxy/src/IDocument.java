import java.time.LocalDate;

public interface IDocument {
	Long getId();

	LocalDate getCreationDate();

	String getContent(User user);
}
