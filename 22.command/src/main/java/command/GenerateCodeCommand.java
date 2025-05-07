package command;

import receiver.PixelGridReceiver;

public class GenerateCodeCommand implements Command {
	private final PixelGridReceiver receiver;

	public GenerateCodeCommand(PixelGridReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.generateCode();
	}
}
