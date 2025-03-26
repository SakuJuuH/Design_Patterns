package org.example;

import org.example.components.button.Button;
import org.example.components.button.ButtonB;
import org.example.components.checkbox.Checkbox;
import org.example.components.checkbox.CheckboxB;
import org.example.components.textfield.TextField;
import org.example.components.textfield.TextFieldB;

public class BFactory extends UIFactory {
	@Override
	Button createButton(String text) {
		return new ButtonB(text);
	}

	@Override
	Checkbox createCheckbox(String text) {
		return new CheckboxB(text);
	}

	@Override
	TextField createTextField(String text) {
		return new TextFieldB(text);
	}
}
