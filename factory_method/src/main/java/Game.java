import map.CityMap;
import map.Map;
import map.WildernessMap;

import java.util.Random;

public class Game {
	public static void main(String[] args) {
		Map map = createMap();
		System.out.println("Map type: " + map.getClass().getSimpleName());
		map.display();
	}

	private static Map createMap() {
		Random random = new Random();
		return random.nextBoolean() ? new CityMap() : new WildernessMap();
	}
}
