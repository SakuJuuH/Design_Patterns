public class Expert extends Level {

	private final int levelThreshold;

	public Expert(Character character) {
		super(character);
		this.levelThreshold = 300;
	}

	@Override
	void train() {
		super.getCharacter().setExperience(getCharacter().getExperience() + 10);
	}

	@Override
	void meditate() {
		super.getCharacter().setHp(getCharacter().getHp() + 20);
	}

	@Override
	void fight() {
		super.getCharacter().setHp(getCharacter().getHp() - 10);
		super.getCharacter().setExperience(getCharacter().getExperience() + 25);
	}

	public int getLevelThreshold() {
		return levelThreshold;
	}
}
