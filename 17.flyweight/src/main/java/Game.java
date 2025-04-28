import map.CityMap;
import map.Map;
import map.WildernessMap;

import java.util.Random;

public class Game {
	private static final Random random = new Random();

	public static void main(String[] args) {
		View.launch(View.class);
	}

	public static Map createMap() {
		return random.nextBoolean() ? new CityMap() : new WildernessMap();
	}
}
