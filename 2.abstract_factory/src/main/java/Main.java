import components.button.Button;
import components.checkbox.Checkbox;
import components.factory.AFactory;
import components.factory.BFactory;
import components.factory.UIFactory;
import components.textfield.TextField;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		UIFactory aFactory = new AFactory();
		UIFactory bFactory = new BFactory();

		List<Object> uiElementsA = Arrays.asList(aFactory.createButton("ButtonA"), aFactory.createCheckbox("CheckboxA"),
		                                         aFactory.createTextField("TextFieldA"));

		List<Object> uiElementsB = Arrays.asList(bFactory.createButton("ButtonB"), bFactory.createCheckbox("CheckboxB"),
		                                         bFactory.createTextField("TextFieldB"));

		uiElementsA.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).display();
			} else if (element instanceof TextField) {
				((TextField) element).display();
			} else if (element instanceof Checkbox) {
				((Checkbox) element).display();
			}
		});

		uiElementsB.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).display();
			} else if (element instanceof Checkbox) {
				((Checkbox) element).display();
			} else if (element instanceof TextField) {
				((TextField) element).display();
			}
		});

		System.out.println("%n%n");

		uiElementsA.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).setText("This is a ButtonA");
			} else if (element instanceof Checkbox) {
				((Checkbox) element).setText("This is a CheckboxA");
			} else if (element instanceof TextField) {
				((TextField) element).setText("This is a TextFieldA");
			}
		});

		uiElementsB.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).setText("This is a ButtonB");
			} else if (element instanceof Checkbox) {
				((Checkbox) element).setText("This is a CheckboxB");
			} else if (element instanceof TextField) {
				((TextField) element).setText("This is a TextFieldB");
			}
		});

		uiElementsA.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).display();
			} else if (element instanceof Checkbox) {
				((Checkbox) element).display();
			} else if (element instanceof TextField) {
				((TextField) element).display();
			}
		});

		uiElementsB.forEach(element -> {
			if (element instanceof Button) {
				((Button) element).display();
			} else if (element instanceof Checkbox) {
				((Checkbox) element).display();
			} else if (element instanceof TextField) {
				((TextField) element).display();
			}
		});
	}
}
