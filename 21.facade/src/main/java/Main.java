public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Joke:");
			String jokeText =
					APIClientFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
			System.out.println(jokeText);

			System.out.println();

			String exchangeRates =
					APIClientFacade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates");
			System.out.println("Exchange Rates:");
			for (String currency : exchangeRates.split(",")) {
				if (currency.contains("{")) {
					currency = currency.replace("{", "");
				}
				if (currency.contains("}")) {
					currency = currency.replace("}", "");
				}
				String currencyName = currency.split(":")[0];
				String currencyValue = currency.split(":")[1];
				System.out.println(currencyName + ": " + currencyValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
