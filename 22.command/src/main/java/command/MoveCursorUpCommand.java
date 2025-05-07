package command;

import receiver.CursorReceiver;

public class MoveCursorUpCommand implements Command {
	private final CursorReceiver cursor;

	public MoveCursorUpCommand(CursorReceiver cursor) {
		this.cursor = cursor;
	}
	
	@Override
	public void execute() {
		cursor.moveUp();
	}
}
