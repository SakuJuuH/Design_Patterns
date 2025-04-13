package guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private final Model model;
	private final Gui gui;
	private final List<IMemento> undoHistory; // Memento undo history
	private final List<IMemento> redoHistory; // Memento redo history
	private IMemento currentState;

	public Controller(Gui gui) {
		this.model = new Model();
		this.gui = gui;
		this.undoHistory = new ArrayList<>();
		this.redoHistory = new ArrayList<>();
		this.currentState = model.createMemento();
	}

	public void setOption(int optionNumber, int choice) {
		clearRedoHistory();
		saveToUndoHistory();
		model.setOption(optionNumber, choice);
		currentState = model.createMemento();
		gui.updateGui(); // Update GUI after state change
	}

	public int getOption(int optionNumber) {
		return model.getOption(optionNumber);
	}

	public boolean getIsSelected() {
		return model.getIsSelected();
	}

	public void setIsSelected(boolean isSelected) {
		clearRedoHistory();
		saveToUndoHistory();
		model.setIsSelected(isSelected);
		currentState = model.createMemento();
		gui.updateGui(); // Update GUI after state change
	}

	public void undo() {
		if (!undoHistory.isEmpty()) {
			System.out.println("Memento found in history");
			saveToRedoHistory();
			IMemento previousState = undoHistory.removeLast();
			model.restoreState(previousState);
			currentState = previousState;
			gui.updateGui();
		}
	}

	public void redo() {
		if (!redoHistory.isEmpty()) {
			System.out.println("Redoing last action");
			saveToUndoHistory();
			IMemento previousState = redoHistory.removeLast();
			model.restoreState(previousState);
			currentState = previousState;
			gui.updateGui();
		}
	}

	private void saveToUndoHistory() {
		undoHistory.add(currentState);
	}

	private void saveToRedoHistory() {
		redoHistory.add(currentState);
	}

	private void clearRedoHistory() {
		redoHistory.clear();
	}

	public List<IMemento> getHistory() {
		List<IMemento> history = new ArrayList<>();
		history.addAll(undoHistory);
		history.add(currentState);
		history.addAll(redoHistory);
		return history;
	}

	public int getCurrentStateIndex() {
		return undoHistory.size();
	}

	public IMemento getCurrentState() {
		return currentState;
	}

	public void restoreState(IMemento memento) {
		saveToUndoHistory(); // Save current state to undo history

		// Restore the state of the model from the last saved state
		model.restoreState(memento);
		currentState = memento;

		// Clear the redo history after restoring state
		redoHistory.clear();

		// Update the GUI after restoring state
		gui.updateGui();
	}
}