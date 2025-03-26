public class Employee implements OrganizationComponent {
	private final String name;
	private final double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void add(OrganizationComponent organizationComponent) {
		throw new UnsupportedOperationException("Cannot add to an Employee");
	}

	@Override
	public void remove(OrganizationComponent organizationComponent) {
		throw new UnsupportedOperationException("Cannot remove from an Employee");
	}

	@Override
	public double getSalary() {
		return this.salary;
	}

	@Override
	public String toXml(int indent) {
		StringBuilder sb = new StringBuilder();
		String indentation = " ".repeat(indent);
		sb.append(indentation).append("<Employee>\n");
		sb.append(indentation).append("    <name>").append(this.name).append("</name>\n");
		sb.append(indentation).append("    <salary>").append(this.salary).append("</salary>\n");
		sb.append(indentation).append("</Employee>\n");
		return sb.toString();
	}
}


