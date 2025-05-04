package components.factory;

import components.button.Button;
import components.button.ButtonB;
import components.checkbox.Checkbox;
import components.checkbox.CheckboxB;
import components.textfield.TextField;
import components.textfield.TextFieldB;

public class BFactory extends UIFactory {
	@Override
	public Button createButton(String text) {
		return new ButtonB(text);
	}

	@Override
	public Checkbox createCheckbox(String text) {
		return new CheckboxB(text);
	}

	@Override
	public TextField createTextField(String text) {
		return new TextFieldB(text);
	}
}
