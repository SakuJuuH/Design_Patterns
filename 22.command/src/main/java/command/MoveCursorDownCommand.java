package command;

import receiver.CursorReceiver;

public class MoveCursorDownCommand implements Command {
	private final CursorReceiver cursor;

	public MoveCursorDownCommand(CursorReceiver cursor) {
		this.cursor = cursor;
	}

	@Override
	public void execute() {
		cursor.moveDown();
	}
}
