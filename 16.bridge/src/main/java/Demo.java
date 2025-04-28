import devices.Device;
import devices.SmartTv;
import devices.Tv;
import remotes.BasicRemote;
import remotes.SmartRemote;

public class Demo {
	public static void main(String[] args) {
		testDevice(new Tv());
		testDevice(new SmartTv(new Tv()));
	}

	public static void testDevice(Device device) {
		System.out.println("Tests with basic remote.");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();
		basicRemote.volumeUp();
		basicRemote.channelUp();
		device.printStatus();
		basicRemote.volumeDown();
		basicRemote.channelDown();
		device.printStatus();

		System.out.println("Tests with smart remote.");
		SmartRemote smartRemote = new SmartRemote(device);
		smartRemote.power();
		smartRemote.volumeUp();
		smartRemote.channelUp();
		smartRemote.voiceControl();
		device.printStatus();
		smartRemote.volumeDown();
		smartRemote.channelDown();
		device.printStatus();

		// Test SmartTv specific functionality if the device is a SmartTv
		if (device instanceof SmartTv smartTv) {
			System.out.println("Tests with SmartTv specific functionality.");
			smartTv.browseInternet();
			device.printStatus();
		}
	}
}
