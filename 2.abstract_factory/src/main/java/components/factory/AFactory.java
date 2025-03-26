package components.factory;

import components.button.Button;
import components.button.ButtonA;
import components.checkbox.Checkbox;
import components.checkbox.CheckboxA;
import components.textfield.TextField;
import components.textfield.TextFieldA;

public class AFactory extends UIFactory {
	@Override
	public Button createButton(String text) {
		return new ButtonA(text);
	}

	@Override
	public Checkbox createCheckbox(String text) {
		return new CheckboxA(text);
	}

	@Override
	public TextField createTextField(String text) {
		return new TextFieldA(text);
	}
}
