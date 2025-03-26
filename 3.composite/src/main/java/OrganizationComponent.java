public interface OrganizationComponent {
	String getName();

	void add(OrganizationComponent organizationComponent);

	void remove(OrganizationComponent organizationComponent);

	double getSalary();

	String toXml(int indent);
}
