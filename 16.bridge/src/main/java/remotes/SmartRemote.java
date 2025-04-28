package remotes;

import devices.Device;

public class SmartRemote extends BasicRemote {

	public SmartRemote(Device device) {
		super.device = device;
	}

	public void voiceControl() {
		System.out.println("Remote: voice control");

	}
}
