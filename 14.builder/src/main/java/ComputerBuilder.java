public interface ComputerBuilder {

	void buildProcessor();

	void buildRAM();

	void buildStorage();

	void buildGraphicsCard();

	void buildOperatingSystem();

	Computer getComputer();
}
