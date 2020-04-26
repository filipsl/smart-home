package devices.kitchen;

import Home.*;
import Home.Kitchen.BakingParams;
import Home.Kitchen.Oven;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;
import utils.TemperatureUtil;

public class OvenImpl extends DeviceImpl implements Oven {

    private BakingParams bakingParams = null;
    private long startTime; //For the purpose of simulation

    @Override
    public void startBaking(BakingParams bakingParams, Current current) throws DurationError, SwitchedOffError, TemperatureRangeError {

        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Oven is switched off.");
        }

        if (!TemperatureUtil.tempInRange(bakingParams.temperature, 50, 250, TempUnit.CELSIUS)) {
            if (bakingParams.temperature.unit == TempUnit.CELSIUS) {
                throw new TemperatureRangeError("Invalid temperature value.", 50, 250, TempUnit.CELSIUS);
            } else {
                throw new TemperatureRangeError("Invalid temperature value.",
                        TemperatureUtil.CtoF(50),
                        TemperatureUtil.CtoF(250),
                        TempUnit.FAHRENHEIT);
            }
        }

        if (bakingParams.durationMins < 1 || bakingParams.durationMins > 1000) {
            throw new DurationError("Invalid duration.", 1, 1000);
        }
        this.bakingParams = bakingParams;
        //Simulate work
        startTime = System.nanoTime();
    }

    @Override
    public boolean isBakingNow(Current current) throws SwitchedOffError {

        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Oven is switched off.");
        }

        if (bakingParams == null) {
            return false;
        }

        //Simulate elapsing time
        long stopTime = System.nanoTime();
        long elapsed_seconds = (stopTime - startTime) / 1000000000;

        //For simulation count duration minutes as seconds
        if (elapsed_seconds <= bakingParams.durationMins) {
            return true;
        }

        bakingParams = null;

        return false;
    }

    @Override
    public BakingParams getBakingParams(Current current) throws NotDefinedError, SwitchedOffError {

        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Oven is switched off.");
        }

        if (bakingParams == null) {
            throw new NotDefinedError("Baking parameters were not defined.");
        }

        //Simulate elapsing time
        long stopTime = System.nanoTime();
        long elapsed_seconds = (stopTime - startTime) / 1000000000;

        //For simulation count duration minutes as seconds
        if (elapsed_seconds <= bakingParams.durationMins) {
            return bakingParams;
        } else {
            bakingParams = null;
            throw new NotDefinedError("Baking parameters were not defined.");
        }
    }
}
