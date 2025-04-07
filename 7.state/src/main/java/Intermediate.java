public class Intermediate extends Level {

	private final int levelThreshold;

	public Intermediate(Character character) {
		super(character);
		this.levelThreshold = 200;
	}

	@Override
	void train() {
		super.getCharacter().setExperience(getCharacter().getExperience() + 10);
	}

	@Override
	void meditate() {
		super.getCharacter().setHp(getCharacter().getHp() + 10);
	}

	@Override
	void fight() {
		System.out.println("Cannot fight as an Intermediate!");
	}

	public int getLevelThreshold() {
		return levelThreshold;
	}
}
