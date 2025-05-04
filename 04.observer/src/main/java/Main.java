public class Main {
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();

		ObservableWeather helsinkiObservableWeather = new ObservableWeather("Helsinki Observer");
		ObservableWeather tampereObservableWeather = new ObservableWeather("Tampere Observer");
		ObservableWeather ouluObservableWeather = new ObservableWeather("Oulu Observer");

		station.registerObserver(helsinkiObservableWeather);
		station.registerObserver(tampereObservableWeather);
		station.registerObserver(ouluObservableWeather);

		Thread weatherStationThread = new Thread(station);
		weatherStationThread.start();

		try {
			System.out.println("Running Weather Station Simulation with observers...");
			Thread.sleep(15000); // Run for 15 seconds

			System.out.println("\nRemoving Tampere Observer...\n");
			station.removeObserver(tampereObservableWeather);

			System.out.println("Continuing simulation with remaining observers...");
			Thread.sleep(15000); // Run for another 15 seconds

			System.out.println("\nSimulation finished.");
			System.exit(0);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}