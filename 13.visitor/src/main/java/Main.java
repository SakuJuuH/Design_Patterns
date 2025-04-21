import java.util.List;

public class Main {
	public static void main(String[] args) {
		// 1. Create the file system structure
		Directory root = new Directory("root");
		Directory documents = new Directory("Documents");
		Directory pictures = new Directory("Pictures");

		File report = new File("report.txt", 2L); // 2 MB
		File presentation = new File("presentation.pptx", 15L); // 15 MB
		File cv = new File("cv.txt", 1L); // 1 MB

		File vacationPhoto = new File("vacation.jpg", 5L); // 5 MB
		File profilePic = new File("profile.png", 3L); // 3 MB
		Directory selfies = new Directory("Selfies");
		File selfie1 = new File("me_at_beach.jpg", 4L); // 4 MB

		// Build the hierarchy
		root.addElement(documents);
		root.addElement(pictures);
		root.addElement(new File("readme.txt", 1L)); // File directly in root

		documents.addElement(report);
		documents.addElement(presentation);
		documents.addElement(cv);

		pictures.addElement(vacationPhoto);
		pictures.addElement(profilePic);
		pictures.addElement(selfies);
		selfies.addElement(selfie1);

		// 2. Use SizeCalculatorVisitor
		System.out.println("--- Calculating Total Size ---");
		SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
		root.accept(sizeVisitor); // Start traversal from the root
		long totalSize = sizeVisitor.getTotalSize();
		System.out.println("Total size of all files: " + totalSize + " MB"); // Expected: 2+15+1+5+3+4+1 = 31 MB
		System.out.println();


		// 3. Use SearchVisitor to find all ".txt" files
		System.out.println("--- Searching for .txt files ---");
		SearchVisitor txtSearchVisitor = new SearchVisitor(".txt");
		root.accept(txtSearchVisitor); // Start traversal
		List<File> txtFiles = txtSearchVisitor.getFoundFiles();

		if (txtFiles.isEmpty()) {
			System.out.println("No .txt files found.");
		} else {
			System.out.println("Found " + txtFiles.size() + " .txt files:");
			for (File file : txtFiles) {
				System.out.println("- " + file.name() + " (" + file.size() + " MB)");
			}
		}
		System.out.println();

		// 4. Use SearchVisitor to find all ".jpg" files
		System.out.println("--- Searching for .jpg files ---");
		SearchVisitor jpgSearchVisitor = new SearchVisitor(".jpg");
		root.accept(jpgSearchVisitor); // Start traversal
		List<File> jpgFiles = jpgSearchVisitor.getFoundFiles();

		if (jpgFiles.isEmpty()) {
			System.out.println("No .jpg files found.");
		} else {
			System.out.println("Found " + jpgFiles.size() + " .jpg files:");
			for (File file : jpgFiles) {
				System.out.println("- " + file.name() + " (" + file.size() + " MB)");
			}
		}
	}
}