package org.example.components.checkbox;

public class CheckboxB extends Checkbox {
	protected String text;

	public CheckboxB(String text) {
		this.text = text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println(".-----------------.");
		System.out.printf("| [X] %s     |%n", text);
		System.out.println("'-----------------'");
		System.out.println();
	}
}
