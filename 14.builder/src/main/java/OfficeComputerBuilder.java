public class OfficeComputerBuilder implements ComputerBuilder {
	private final Computer computer;

	public OfficeComputerBuilder() {
		this.computer = new Computer();
	}

	@Override
	public void buildProcessor() {
		System.out.println("Building Apple M4 Max");
		computer.setProcessor("Apple M4 Max");
	}

	@Override
	public void buildRAM() {
		System.out.println("Building 32GB of Apple Memory 3200MHZ");
		computer.setRam(32);
	}

	@Override
	public void buildStorage() {
		System.out.println("Building 4TB Samsung 9100 Pro SSD");
		computer.setStorage("4TB Samsung 9100 Pro SSD");
	}

	@Override
	public void buildGraphicsCard() {
		System.out.println("Building Apple M4 Max");
		computer.setGraphicsCard("Apple M4 Max");
	}

	@Override
	public Computer getComputer() {
		return this.computer;
	}

	@Override
	public void buildOperatingSystem() {
		System.out.println("Building macOS 15 Sequoia");
		computer.setOperatingSystem("macOS 15 Sequoia");
	}
}
