public class EncryptedPrinter extends PrinterDecorator {

	private static final int SHIFT = 3;

	public EncryptedPrinter(Printer printer) {
		super(printer);
	}

	@Override
	public void print(String s) {
		String encrypted = encrypt(s);
		super.print(encrypted);
	}

	private String encrypt(String plainText) {
		StringBuilder result = new StringBuilder();
		for (Character ch : plainText.toCharArray()) {
			if (Character.isLetter(ch)) {
				char base = Character.isUpperCase(ch) ? 'A' : 'a';
				char shifted = (char) (((ch - base + SHIFT) % 26) + base);
				result.append(shifted);
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}
}
