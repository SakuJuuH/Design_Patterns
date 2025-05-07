package command;

import receiver.CursorReceiver;
import receiver.PixelGridReceiver;

public class TogglePixelCommand implements Command {

	private final PixelGridReceiver receiver;
	private final CursorReceiver cursor;

	public TogglePixelCommand(PixelGridReceiver receiver, CursorReceiver cursor) {
		this.receiver = receiver;
		this.cursor = cursor;
	}

	@Override
	public void execute() {
		receiver.togglePixel(cursor.getX(), cursor.getY());
	}
}