package devices;

import Home.Device;
import Home.PowerState;
import com.zeroc.Ice.Current;

public class DeviceImpl implements Device {
    @Override
    public PowerState getPowerState(Current current) {
        return null;
    }

    @Override
    public void setPowerState(PowerState powerState, Current current) {

    }
}
