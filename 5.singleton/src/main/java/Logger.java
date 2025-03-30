import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private static Logger instance;
	private String fileName;
	private BufferedWriter writer;

	private Logger() {
		this.fileName = "logfile.txt";
		try {
			this.writer = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Error initializing logger: " + e.getMessage());
		}
	}

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void setFileName(String fileName) {
		if (fileName.equals(this.fileName)) {
			return;
		}
		try {
			if (writer != null) {
				writer.close();
			}

			this.fileName = fileName;
			this.writer = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Error changing log file: " + e.getMessage());
		}
	}

	public void write(String message) {
		try {
			writer.write(message + "\r\n");
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	public void close() {
		try {
			if (writer != null) {
				writer.close();
				writer = null;
			}
		} catch (IOException e) {
			System.out.println("Error closing logger: " + e.getMessage());
		}
	}
}
