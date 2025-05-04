package components.textfield;

public class TextFieldB extends TextField {
	protected String text;

	public TextFieldB(String text) {
		this.text = text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println("*=========================*");
		System.out.printf("|      B-TextField: %s       |%n", text);
		System.out.println("*=========================*");
		System.out.println();
	}
}
