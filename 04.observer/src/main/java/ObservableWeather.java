public record ObservableWeather(String name) implements Observer {

	@Override
	public void update(double temperature) {
		System.out.println("Weather name: " + name);
		System.out.printf("Temperature: %.1f°C%n", temperature);
	}
}
