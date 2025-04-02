public class XMLPrinter extends PrinterDecorator {
	public XMLPrinter(Printer printer) {
		super(printer);
	}

	@Override
	public void print(String s) {
		String xml = "<message>" + s + "</message>";
		super.print(xml);
	}
}
