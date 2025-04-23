public class Computer {
	private String processor;
	private int ram;
	private String storage;
	private String graphicsCard;
	private String operatingSystem;

	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return String.format(
				"┌───────────────── COMPUTER CONFIGURATION ──────────────────┐%n" +
				"│ %-17s │ %-37s │%n" +
				"├───────────────────┼───────────────────────────────────────┤%n" +
				"│ Processor         │ %-37s │%n" +
				"│ RAM               │ %-37s │%n" +
				"│ Storage           │ %-37s │%n" +
				"│ Graphics Card     │ %-37s │%n" +
				"│ Operating System  │ %-37s │%n" +
				"└───────────────────┴───────────────────────────────────────┘",
				"Component", "Value",
				processor,
				ram + "GB",
				storage,
				graphicsCard,
				operatingSystem
		);
	}
}
