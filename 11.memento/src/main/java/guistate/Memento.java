package guistate;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Memento implements IMemento {

	private final int[] options;
	private final boolean isSelected;
	private final LocalDateTime creationTime;

	public Memento(int[] options, boolean isSelected) {
		this.options = options.clone(); // Copy options array
		this.isSelected = isSelected;
		this.creationTime = LocalDateTime.now();
		System.out.println("Memento created");
	}

	@Override
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}

	public int[] getOptions() {
		return options;
	}

	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public String toString() {
		return "Colors: " + Arrays.toString(options) + ", Checkbox: " + (isSelected ? "selected" : "not selected") +
		       ", created at: " + getCreationTime();
	}
}
