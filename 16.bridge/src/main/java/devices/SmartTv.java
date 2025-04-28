package devices;

public class SmartTv extends Tv {

	public SmartTv(Device device) {
		super.device = device;
	}

	public void browseInternet() {
		System.out.println("Smart TV: browsing the internet");
	}
}
