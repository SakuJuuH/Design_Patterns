package org.example;

import org.example.components.button.Button;
import org.example.components.button.ButtonA;
import org.example.components.checkbox.Checkbox;
import org.example.components.checkbox.CheckboxA;
import org.example.components.textfield.TextField;
import org.example.components.textfield.TextFieldA;

public class AFactory extends UIFactory {
	@Override
	Button createButton(String text) {
		return new ButtonA(text);
	}

	@Override
	Checkbox createCheckbox(String text) {
		return new CheckboxA(text);
	}

	@Override
	TextField createTextField(String text) {
		return new TextFieldA(text);
	}
}
