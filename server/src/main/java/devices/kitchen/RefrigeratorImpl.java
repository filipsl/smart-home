package devices.kitchen;

import Home.*;
import Home.Kitchen.Refrigerator;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;

public class RefrigeratorImpl extends DeviceImpl implements Refrigerator {
    @Override
    public void setFridgeTemperature(Temperature temperature, Current current) throws TemperatureRangeError {

    }

    @Override
    public Temperature getFridgeTemperature(Current current) throws SwitchedOffError {
        return null;
    }

    @Override
    public void setTempUnit(TempUnit unit, Current current) {

    }

    @Override
    public PowerState getPowerState(Current current) {
        return null;
    }

    @Override
    public void setPowerState(PowerState powerState, Current current) {

    }
}
