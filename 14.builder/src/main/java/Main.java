public class Main {
	public static void main(String[] args) {
		ComputerDirector director = new ComputerDirector();

		// 1. Build a Gaming Computer
		System.out.println("--- Building Gaming Computer ---");
		ComputerBuilder gamingBuilder = new GamingComputerBuilder();
		director.constructComputer(gamingBuilder);
		Computer gamingComputer = gamingBuilder.getComputer();

		System.out.println("\n--- Gaming Computer Configuration ---");
		System.out.println(gamingComputer);
		System.out.println("------------------------------------\n");


		// 2. Build an Office Computer
		System.out.println("--- Building Office Computer ---");
		ComputerBuilder officeBuilder = new OfficeComputerBuilder();
		director.constructComputer(officeBuilder);

		Computer officeComputer = officeBuilder.getComputer();

		System.out.println("\n--- Office Computer Configuration ---");
		System.out.println(officeComputer);
		System.out.println("-----------------------------------");

	}
}