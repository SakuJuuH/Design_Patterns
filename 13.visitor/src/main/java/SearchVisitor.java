import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

	private final String searchString;
	private final List<File> foundFiles;

	public SearchVisitor(String searchString) {
		this.searchString = searchString;
		this.foundFiles = new ArrayList<>();
	}

	@Override
	public void visit(File file) {
		if (file.name().contains(searchString)) {
			System.out.println("Found file: " + file.name());
			foundFiles.add(file);
		} else {
			System.out.println("File not found: " + file.name());
		}
	}

	@Override
	public void visit(Directory directory) {
		for (FileSystemElement element : directory.getElements()) {
			element.accept(this);
		}
	}

	public List<File> getFoundFiles() {
		return List.copyOf(foundFiles);
	}
}