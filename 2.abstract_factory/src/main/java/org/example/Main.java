package org.example;

import org.example.components.button.Button;
import org.example.components.checkbox.Checkbox;
import org.example.components.textfield.TextField;

public class Main {
	public static void main(String[] args) {
		UIFactory aFactory = new AFactory();
		UIFactory bFactory = new BFactory();

		Button buttonA = aFactory.createButton("ButtonA");
		Checkbox checkboxA = aFactory.createCheckbox("CheckboxA");
		TextField textFieldA = aFactory.createTextField("TextFieldA");

		Button buttonB = bFactory.createButton("ButtonB");
		Checkbox checkboxB = bFactory.createCheckbox("CheckboxB");
		TextField textFieldB = bFactory.createTextField("TextFieldB");

		buttonA.display();
		checkboxA.display();
		textFieldA.display();

		buttonB.display();
		checkboxB.display();
		textFieldB.display();

		System.out.println();
		System.out.println();
		System.out.println();

		buttonA.setText("This is a ButtonA");
		checkboxA.setText("This is a CheckboxA");
		textFieldA.setText("This is a TextFieldA");

		buttonB.setText("This is a ButtonB");
		checkboxB.setText("This is a CheckboxB");
		textFieldB.setText("This is a TextFieldB");

		buttonA.display();
		checkboxA.display();
		textFieldA.display();

		buttonB.display();
		checkboxB.display();
		textFieldB.display();
	}
}
