public class SizeCalculatorVisitor implements FileSystemVisitor {
	private long totalSize = 0;

	@Override
	public void visit(File file) {
		totalSize += file.size();
	}

	@Override
	public void visit(Directory directory) {
		for (FileSystemElement element : directory.getElements()) {
			element.accept(this);
		}
	}

	public long getTotalSize() {
		return totalSize;
	}
}
