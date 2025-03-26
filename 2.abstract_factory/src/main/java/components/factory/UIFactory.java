package components.factory;

import components.button.Button;
import components.checkbox.Checkbox;
import components.textfield.TextField;

public abstract class UIFactory {
	public abstract Button createButton(String text);

	public abstract Checkbox createCheckbox(String text);

	public abstract TextField createTextField(String text);
}
