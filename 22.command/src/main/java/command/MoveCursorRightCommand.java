package command;

import receiver.CursorReceiver;

public class MoveCursorRightCommand implements Command {
	private final CursorReceiver cursor;

	public MoveCursorRightCommand(CursorReceiver cursor) {
		this.cursor = cursor;
	}

	@Override
	public void execute() {
		cursor.moveRight();
	}
}
