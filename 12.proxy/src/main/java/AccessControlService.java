import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {

	private static final AccessControlService instance = new AccessControlService();

	private final HashMap<Long, HashSet<String>> documentAccess;

	private AccessControlService() {
		documentAccess = new HashMap<>();
	}

	public static AccessControlService getInstance() {
		return instance;
	}

	public void registerDocument(Long documentId) {
		if (documentId == null) {
			throw new IllegalArgumentException("Document ID cannot be null");
		}

		documentAccess.putIfAbsent(documentId, new HashSet<>());
	}

	public void grantAccess(Long documentId, String username) {
		if (documentId == null || username == null) {
			throw new AccessDeniedException("Document ID or username cannot be null");
		}

		if (!documentAccess.containsKey(documentId)) {
			throw new IllegalArgumentException("Document not registered");
		}

		HashSet<String> allowedUsers = documentAccess.computeIfAbsent(documentId, k -> new HashSet<>());

		allowedUsers.add(username);
	}

	public boolean isAllowed(Long documentId, String username) {
		if (documentId == null || username == null) {
			throw new AccessDeniedException("Document ID or username cannot be null");
		}

		HashSet<String> allowedUsers = documentAccess.get(documentId);

		return allowedUsers != null && allowedUsers.contains(username);
	}
}
