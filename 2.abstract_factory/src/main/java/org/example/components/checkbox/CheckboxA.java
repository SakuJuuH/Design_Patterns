package org.example.components.checkbox;

public class CheckboxA extends Checkbox {
	protected String text;

	public CheckboxA(String text) {
		this.text = text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void display() {
		System.out.println("+---------------+");
		System.out.printf("| {x} %s  |%n", text);
		System.out.println("+---------------+");
		System.out.println();
	}
}
