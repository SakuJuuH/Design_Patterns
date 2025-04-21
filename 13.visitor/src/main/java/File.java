public record File(String name, Long size) implements FileSystemElement {

	@Override
	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
