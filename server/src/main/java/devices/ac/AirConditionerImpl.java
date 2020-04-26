package devices.ac;

import Home.*;
import Home.AC.AirConditioner;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;

public class AirConditionerImpl extends DeviceImpl implements AirConditioner {
    @Override
    public void setTargetTemperature(Temperature temp, Current current) throws TemperatureRangeError {

    }

    @Override
    public Temperature getTargetTemperature(Current current) {
        return null;
    }

    @Override
    public void setAutoStart(AutoStartParams autoStartParams, Current current) throws DurationError, TimeRangeError {

    }

    @Override
    public AutoStartParams getAutoStartParams(Current current) throws NotDefinedError {
        return null;
    }

    @Override
    public PowerState getPowerState(Current current) {
        return null;
    }

    @Override
    public void setPowerState(PowerState powerState, Current current) {

    }
}
