public class GamingComputerBuilder implements ComputerBuilder {
	private final Computer computer;

	public GamingComputerBuilder() {
		this.computer = new Computer();
	}

	@Override
	public void buildProcessor() {
		System.out.println("Building AMD Ryzen 9 9950x3D");
		computer.setProcessor("AMD Ryzen 9 9950x3D");
	}

	@Override
	public void buildRAM() {
		System.out.println("Building 64GB of G.Skill Trident Z5 8000MHZ DDR5");
		computer.setRam(64);
	}

	@Override
	public void buildStorage() {
		System.out.println("Building 2TB Samsung 9100 PRO SSD");
		computer.setStorage("2TB Samsung 9100 PRO SSD");
	}

	@Override
	public void buildGraphicsCard() {
		System.out.println("Building MSI GeForce RTX 5090 SUPRIM 32GB");
		computer.setGraphicsCard("MSI GeForce RTX 5090 SUPRIM 32GB");
	}

	@Override
	public Computer getComputer() {
		return this.computer;
	}

	@Override
	public void buildOperatingSystem() {
		System.out.println("Building Windows 11 Pro");
		computer.setOperatingSystem("Windows 11 Pro");
	}
}
