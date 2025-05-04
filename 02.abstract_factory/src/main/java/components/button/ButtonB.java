package components.button;

public class ButtonB extends Button {
	protected String text;

	public ButtonB(String text) {
		this.text = text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println("/===================\\");
		System.out.printf("|     %s      |%n", text);
		System.out.println("\\===================/");
		System.out.println();
	}
}
