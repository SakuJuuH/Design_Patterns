public class Character {
	private final String name;
	private Level currentLevel;
	private int hp;
	private int experience;

	public Character(String name) {
		this.name = name;
		this.hp = 10;
		this.experience = 0;
		this.currentLevel = new Novice(this);
	}

	public void train() {
		currentLevel.train();
		checkLevelUp();
	}

	public void meditate() {
		currentLevel.meditate();
		checkLevelUp();
	}

	public void fight() {
		currentLevel.fight();
		checkLevelUp();
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void checkLevelUp() {
		if (currentLevel instanceof Novice &&
		    experience >= ((Novice) currentLevel).getLevelThreshold()) {
			setCurrentLevel(new Intermediate(this));
			System.out.println("Leveled up to Intermediate! New actions unlocked: Meditate!");
		} else if (currentLevel instanceof Intermediate &&
		           experience >= ((Intermediate) currentLevel).getLevelThreshold()) {
			setCurrentLevel(new Expert(this));
			System.out.println("Leveled up to Expert! New actions unlocked: Fight!");
		} else if (currentLevel instanceof Expert &&
		           experience >= ((Expert) currentLevel).getLevelThreshold()) {
			setCurrentLevel(new Master(this));
			System.out.println("Leveled up to Master! Game completed!");
		}
	}

	public void displayStats() {
		System.out.println("Name: " + name + "\nHP: " + hp + "\nExperience: " + experience + "\nLevel: " +
		                   currentLevel.getClass().getSimpleName());
	}
}
