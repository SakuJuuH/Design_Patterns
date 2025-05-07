package command;

import receiver.CursorReceiver;

public class MoveCursorLeftCommand implements Command {
	private final CursorReceiver cursor;

	public MoveCursorLeftCommand(CursorReceiver cursor) {
		this.cursor = cursor;
	}

	@Override
	public void execute() {
		cursor.moveLeft();
	}
}
