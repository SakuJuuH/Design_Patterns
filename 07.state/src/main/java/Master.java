public class Master extends Level {
	public Master(Character character) {
		super(character);
	}

	@Override
	void train() {
		System.out.println("You have reached the max level of Master, you can't train anymore.");
	}

	@Override
	void meditate() {
		System.out.println("You have reached the max level of Master, you can't meditate anymore.");
	}

	@Override
	void fight() {
		System.out.println("You have reached the max level of Master, you can't fight anymore.");
	}
}
