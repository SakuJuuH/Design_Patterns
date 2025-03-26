public class Main {
	public static void main(String[] args) {
		// Create the root department (organization)
		Department organization = new Department("ABC Corp");

		// Create departments
		Department engineering = new Department("Engineering");
		Department sales = new Department("Sales");
		Department rd = new Department("Research & Development");
		Department qa = new Department("Quality Assurance");

		// Create employees
		Employee ceo = new Employee("John Smith", 180000);
		Employee cto = new Employee("Jane Doe", 160000);
		Employee salesDirector = new Employee("Mike Wilson", 120000);
		Employee seniorDev = new Employee("Alice Brown", 110000);
		Employee juniorDev = new Employee("Bob Johnson", 75000);
		Employee researchLead = new Employee("Carol White", 115000);
		Employee qaLead = new Employee("David Miller", 105000);
		Employee salesRep = new Employee("Ellen Davis", 85000);

		// Build the organizational structure
		organization.add(ceo);
		organization.add(engineering);
		organization.add(sales);

		engineering.add(cto);
		engineering.add(rd);
		engineering.add(qa);

		rd.add(researchLead);
		qa.add(qaLead);

		engineering.add(seniorDev);
		engineering.add(juniorDev);

		sales.add(salesDirector);
		sales.add(salesRep);

		// Print the total salary
		System.out.println("Total salary: $" + organization.getSalary());

		// Print the organizational structure in XML format
		System.out.println("\nOrganizational Structure in XML:");
		System.out.println("<organization>");
		System.out.print(organization.toXml(4));
		System.out.println("</organization>");

		// Demonstrate removal
		System.out.println("\nAfter removing the R&D department:");
		engineering.remove(rd);
		System.out.println("<organization>");
		System.out.print(organization.toXml(4));
		System.out.println("</organization>");

		// Add new employee to demonstrate dynamic modification
		Employee newHire = new Employee("Frank Thomas", 90000);
		qa.add(newHire);

		System.out.println("\nAfter adding a new QA employee:");
		System.out.println("<organization>");
		System.out.print(organization.toXml(4));
		System.out.println("</organization>");

		// Print updated total salary
		System.out.println("\nUpdated total salary: $" + organization.getSalary());
	}
}