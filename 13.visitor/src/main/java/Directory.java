import java.util.ArrayList;

public class Directory implements FileSystemElement {
	private final String name;
	private final ArrayList<FileSystemElement> elements;

	public Directory(String name) {
		this.name = name;
		this.elements = new ArrayList<>();
	}

	public void addElement(FileSystemElement element) {
		this.elements.add(element);
	}

	public ArrayList<FileSystemElement> getElements() {
		return elements;
	}

	@Override
	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
