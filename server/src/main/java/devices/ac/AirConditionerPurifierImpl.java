package devices.ac;

import Home.*;
import Home.AC.AirConditionerPurifier;
import Home.AC.PollutionLevel;
import com.zeroc.Ice.Current;

public class AirConditionerPurifierImpl extends AirConditionerImpl implements AirConditionerPurifier {


    @Override
    public void setPollutionTreshLevel(PollutionLevel pollutionLevel, Current current) {

    }

    @Override
    public PollutionLevel getPollutionTreshLevel(Current current) {
        return null;
    }

    @Override
    public boolean isPurifyingOn(Current current) throws SwitchedOffError {
        return false;
    }

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
