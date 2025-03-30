import java.util.ArrayList;
import java.util.Random;

public class WeatherStation implements Runnable {

	private final int TEMP_UPPER_BOUND = 36;
	private final int TEMP_LOWER_BOUND = -30;
	private final ArrayList<Observer> observers;
	Random rand = new Random();
	private double temperature;

	public WeatherStation() {
		this.temperature = rand.nextDouble(TEMP_LOWER_BOUND, TEMP_UPPER_BOUND);
		this.observers = new ArrayList<>();
	}

	@Override
	public void run() {
		while (true) {
			double tempChange = rand.nextDouble(-2, 3);
			setTemperature(getTemperature() + tempChange);
			notifyObservers();
			try {
				Thread.sleep(rand.nextInt(1000, 5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	double getTemperature() {
		return this.temperature;
	}

	void setTemperature(double temperature) {
		if (temperature < TEMP_LOWER_BOUND) {
			System.out.println(
					"Temperature is lower than " + TEMP_LOWER_BOUND + ". Will update to " + TEMP_LOWER_BOUND);
			temperature = TEMP_LOWER_BOUND;
		} else if (temperature > TEMP_UPPER_BOUND) {
			System.out.println(
					"Temperature is higher than " + TEMP_UPPER_BOUND + ". Will update to " + TEMP_UPPER_BOUND);
			temperature = TEMP_UPPER_BOUND;
		}
		this.temperature = temperature;
	}

	void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(getTemperature());
			System.out.println();
		}
	}
}
