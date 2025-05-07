package receiver;

public class CursorReceiver {
	private static final int GRID_SIZE = 8;
	private int x = 0;
	private int y = 0;

	public void moveUp() {
		if (y > 0) {
			y--;
		}
	}

	public void moveDown() {
		if (y < GRID_SIZE - 1) {
			y++;
		}
	}

	public void moveLeft() {
		if (x > 0) {
			x--;
		}
	}

	public void moveRight() {
		if (x < GRID_SIZE - 1) {
			x++;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}