package devices.kitchen;

import Home.*;
import Home.Kitchen.BakingParams;
import Home.Kitchen.Oven;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;

public class OvenImpl extends DeviceImpl implements Oven {



    @Override
    public void startBaking(BakingParams bakingParams, Current current) throws DurationError, SwitchedOffError, TemperatureRangeError {

    }

    @Override
    public boolean isBakingNow(Current current) throws SwitchedOffError {
        return false;
    }

    @Override
    public BakingParams getBakingParams(Current current) throws NotDefinedError, SwitchedOffError {
        return null;
    }
}
