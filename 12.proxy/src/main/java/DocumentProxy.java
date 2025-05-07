import java.time.LocalDate;

public class DocumentProxy implements IDocument {
	private final Document document;

	public DocumentProxy(Document document) {
		this.document = document;
	}

	@Override
	public Long getId() {
		return document.getId();
	}

	@Override
	public LocalDate getCreationDate() {
		return document.getCreationDate();
	}

	@Override
	public String getContent(User user) {
		if (AccessControlService.getInstance().isAllowed(this.getId(), user.username)) {
			return document.getContent(user);
		} else {
			throw new AccessDeniedException("Access denied for user " + user.username + " to document " + this.getId());
		}
	}
}
