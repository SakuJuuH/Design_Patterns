import java.time.LocalDate;

public class Document implements IDocument {
	public LocalDate creationDate;
	public Long id;
	protected String content;

	public Document(Long id, LocalDate creationDate, String content) {
		this.id = id;
		this.creationDate = creationDate;
		this.content = content;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public LocalDate getCreationDate() {
		return creationDate;
	}

	@Override
	public String getContent(User user) {
		return content;
	}
}
