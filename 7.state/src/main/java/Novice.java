public class Novice extends Level {

	private final int levelThreshold;

	public Novice(Character character) {
		super(character);
		this.levelThreshold = 100;
	}

	@Override
	void train() {
		super.getCharacter().setExperience(getCharacter().getExperience() + 10);
	}

	@Override
	void meditate() {
		System.out.println("Cannot meditate as a Novice.");
	}

	@Override
	void fight() {
		System.out.println("Cannot fight as a Novice.");
	}

	public int getLevelThreshold() {
		return levelThreshold;
	}

}
