package devices.kitchen;

import Home.*;
import Home.Kitchen.RefrigeratorWithFreezer;
import com.zeroc.Ice.Current;

public class RefrigeratorWithFreezerImpl extends RefrigeratorImpl implements RefrigeratorWithFreezer {
    @Override
    public void setFreezerTemperature(Temperature temperature, Current current) throws SwitchedOffError, TemperatureRangeError {

    }

    @Override
    public Temperature getFreezerTemperature(Current current) throws SwitchedOffError {
        return null;
    }

    @Override
    public boolean isTurboFreezingOn(Current current) throws SwitchedOffError {
        return false;
    }

    @Override
    public void setTurboFreezing(boolean turboFreezing, Current current) throws SwitchedOffError {

    }
}
