package devices;

import Home.Device;
import Home.PowerState;
import com.zeroc.Ice.Current;

public class DeviceImpl implements Device {

    protected PowerState powerState = PowerState.OFF;

    @Override
    public PowerState getPowerState(Current current) {
        return powerState;
    }

    @Override
    public void setPowerState(PowerState powerState, Current current) {
        this.powerState = powerState;
    }
}
