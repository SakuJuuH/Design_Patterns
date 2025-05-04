package components.textfield;

public class TextFieldA extends TextField {
	protected String text;

	public TextFieldA(String text) {
		this.text = text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println("+-------------------------+");
		System.out.printf("| A-TextField: %s          |%n", text);
		System.out.println("+-------------------------+");
		System.out.println();
	}
}
