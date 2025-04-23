public class ComputerDirector {

	public void constructComputer(ComputerBuilder builder) {
		builder.buildGraphicsCard();
		builder.buildOperatingSystem();
		builder.buildProcessor();
		builder.buildRAM();
		builder.buildStorage();
	}
}
