import java.util.HashMap;

public class Library {
	protected HashMap<Long, IDocument> documents = new HashMap<>();

	public void addDocument(IDocument document) {
		if (document == null) {
			throw new IllegalArgumentException("Document cannot be null");
		}

		documents.put(document.getId(), document);
	}

	public IDocument getDocument(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("Document ID cannot be null");
		}

		IDocument document = documents.get(id);

		if (document == null) {
			throw new IllegalArgumentException("Document not found");
		}

		return document;
	}

	public void addProtectedDocument(Document document) {
		if (document == null) {
			throw new IllegalArgumentException("Document or AccessControlService cannot be null");
		}

		if (documents.containsKey(document.getId())) {
			throw new IllegalArgumentException("Document already exists");
		}

		DocumentProxy proxy = new DocumentProxy(document);

		this.addDocument(proxy);
		AccessControlService.getInstance().registerDocument(document.getId());
	}
}
