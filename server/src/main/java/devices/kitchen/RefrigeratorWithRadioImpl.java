package devices.kitchen;

import Home.*;
import Home.Kitchen.FrequencyRangeError;
import Home.Kitchen.RefrigeratorWithRadio;
import Home.Kitchen.VolumeRangeError;
import com.zeroc.Ice.Current;

public class RefrigeratorWithRadioImpl extends RefrigeratorImpl implements RefrigeratorWithRadio {
    @Override
    public void setFrequency(double freq, Current current) throws FrequencyRangeError {

    }

    @Override
    public double getFrequency(Current current) {
        return 0;
    }

    @Override
    public PowerState getRadioPowerState(Current current) {
        return null;
    }

    @Override
    public void setRadioPowerState(PowerState powerState, Current current) {

    }

    @Override
    public void setVolumeLevel(short level, Current current) throws VolumeRangeError {

    }

    @Override
    public short getVolumeLevel(Current current) {
        return 0;
    }
}
