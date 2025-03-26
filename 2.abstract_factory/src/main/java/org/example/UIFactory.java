package org.example;

import org.example.components.button.Button;
import org.example.components.checkbox.Checkbox;
import org.example.components.textfield.TextField;

public abstract class UIFactory {
	abstract Button createButton(String text);

	abstract Checkbox createCheckbox(String text);

	abstract TextField createTextField(String text);
}
