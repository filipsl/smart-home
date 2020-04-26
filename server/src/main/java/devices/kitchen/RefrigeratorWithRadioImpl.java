package devices.kitchen;

import Home.*;
import Home.Kitchen.FrequencyRangeError;
import Home.Kitchen.RefrigeratorWithRadio;
import Home.Kitchen.VolumeRangeError;
import com.zeroc.Ice.Current;
import server.Server;

public class RefrigeratorWithRadioImpl extends RefrigeratorImpl implements RefrigeratorWithRadio {

    private double freq = 97;
    private short level = 30;
    protected PowerState radioPowerState = PowerState.OFF;


    @Override
    public void setFrequency(double freq, Current current) throws FrequencyRangeError {
        Server.logger.info("Set radio frequency");

        if (freq < 88 || freq > 108)
            throw new FrequencyRangeError("Invalid frequency value.", 88, 108);
        this.freq = freq;
    }

    @Override
    public double getFrequency(Current current) {
        Server.logger.info("Get radio frequency");

        return freq;
    }

    @Override
    public PowerState getRadioPowerState(Current current) {
        Server.logger.info("Get radio power state");
        return radioPowerState;
    }

    @Override
    public void setRadioPowerState(PowerState powerState, Current current) {
        Server.logger.info("Set radio power state");

        radioPowerState = powerState;
    }

    @Override
    public void setVolumeLevel(short level, Current current) throws VolumeRangeError {
        Server.logger.info("Set radio volume level");

        if (level < 0 || level > 100)
            throw new VolumeRangeError("Invalid volume level value.", (short) 0, (short) 100);
        this.level = level;
    }

    @Override
    public short getVolumeLevel(Current current) {
        Server.logger.info("Get radio volume level");

        return level;
    }
}
