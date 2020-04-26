package devices.ac;

import Home.*;
import Home.AC.AirConditioner;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;
import server.Server;
import utils.TemperatureUtil;

public class AirConditionerImpl extends DeviceImpl implements AirConditioner {

    protected Temperature targetTemp = new Temperature(20, TempUnit.CELSIUS);
    protected AutoStartParams autoStartParams = null;
    protected long startTime; //For the purpose of simulation

    @Override
    public void setTargetTemperature(Temperature temp, Current current) throws TemperatureRangeError {
        Server.logger.info("Set target temperature");


        if (!TemperatureUtil.tempInRange(temp, 10, 20, TempUnit.CELSIUS)) {
            if (temp.unit == TempUnit.CELSIUS)
                throw new TemperatureRangeError("Invalid temperature value.", 10, 20, TempUnit.CELSIUS);
            else
                throw new TemperatureRangeError("Invalid temperature value.",
                        TemperatureUtil.CtoF(10),
                        TemperatureUtil.CtoF(20),
                        TempUnit.FAHRENHEIT);
        }
        targetTemp = temp;
    }

    @Override
    public Temperature getTargetTemperature(Current current) {
        Server.logger.info("Get target temperature");

        return targetTemp;
    }

    @Override
    public void setAutoStart(AutoStartParams autoStartParams, Current current) throws DurationError, TimeRangeError {
        Server.logger.info("Set automatic start parameters");

        if (autoStartParams.timeOfDay.hour < 0
                || autoStartParams.timeOfDay.hour > 23
                || autoStartParams.timeOfDay.minute < 0
                || autoStartParams.timeOfDay.minute > 59) {
            throw new TimeRangeError("Invalid start time.", (short) 0, (short) 23, (short) 0, (short) 59);
        }
        if (autoStartParams.durationMins < 1 || autoStartParams.durationMins > 1000) {
            throw new DurationError("Invalid duration.", 1, 1000);
        }
        this.autoStartParams = autoStartParams;
        //Simulate work
        startTime = System.nanoTime();
        super.powerState = PowerState.ON;
    }

    @Override
    public AutoStartParams getAutoStartParams(Current current) throws NotDefinedError {
        Server.logger.info("Get automatic start parameters");

        if (autoStartParams == null) {
            throw new NotDefinedError("Auto start parameters were not specified.");
        }

        //Simulate elapsing time
        long stopTime = System.nanoTime();
        long elapsed_seconds = (stopTime - startTime) / 1000000000;

        //For simulation count duration minutes as seconds
        if (autoStartParams.durationMins < elapsed_seconds) {
            autoStartParams = null;
            super.powerState = PowerState.OFF;
            throw new NotDefinedError("Auto start parameters were not specified.");
        }

        return autoStartParams;
    }
}
