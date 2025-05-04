import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
	private final String name;
	private final List<OrganizationComponent> components;

	public Department(String name) {
		this.name = name;
		this.components = new ArrayList<>();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void add(OrganizationComponent organizationComponent) {
		components.add(organizationComponent);
	}

	@Override
	public void remove(OrganizationComponent organizationComponent) {
		components.remove(organizationComponent);
	}

	@Override
	public double getSalary() {
		double totalSalary = 0;
		for (OrganizationComponent organizationComponent : components) {
			totalSalary += organizationComponent.getSalary();
		}
		return totalSalary;
	}

	@Override
	public String toXml(int indent) {
		StringBuilder sb = new StringBuilder();
		String indentation = " ".repeat(indent);

		sb.append(indentation).append("<department>\n");
		sb.append(indentation).append("    <name>").append(this.name).append("</name>\n");

		for (OrganizationComponent organizationComponent : components) {
			sb.append(organizationComponent.toXml(indent + 4));
		}

		sb.append(indentation).append("</department>\n");

		return sb.toString();
	}
}
