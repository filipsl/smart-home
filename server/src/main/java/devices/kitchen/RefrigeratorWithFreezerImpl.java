package devices.kitchen;

import Home.*;
import Home.Kitchen.RefrigeratorWithFreezer;
import com.zeroc.Ice.Current;
import utils.TemperatureUtil;

public class RefrigeratorWithFreezerImpl extends RefrigeratorImpl implements RefrigeratorWithFreezer {

    protected Temperature freezerTemperature = new Temperature(-10, TempUnit.CELSIUS);
    private boolean turboFreezing = false;


    @Override
    public void setFreezerTemperature(Temperature temperature, Current current) throws SwitchedOffError, TemperatureRangeError {
        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Refrigerator is switched off.");
        }
        if (!TemperatureUtil.tempInRange(temperature, -25, -2, TempUnit.CELSIUS)) {
            if (temperature.unit == TempUnit.CELSIUS) {
                throw new TemperatureRangeError("Invalid temperature value.", -25, -2, TempUnit.CELSIUS);
            } else {
                throw new TemperatureRangeError("Invalid temperature value.",
                        TemperatureUtil.CtoF(-25),
                        TemperatureUtil.CtoF(-2),
                        TempUnit.FAHRENHEIT);
            }
        }
        this.freezerTemperature = temperature;
    }

    @Override
    public Temperature getFreezerTemperature(Current current) throws SwitchedOffError {
        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Refrigerator is switched off.");
        }
        return freezerTemperature;
    }

    @Override
    public boolean isTurboFreezingOn(Current current) throws SwitchedOffError {
        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Refrigerator is switched off.");
        }
        return turboFreezing;
    }

    @Override
    public void setTurboFreezing(boolean turboFreezing, Current current) throws SwitchedOffError {
        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Refrigerator is switched off.");
        }

        this.turboFreezing = turboFreezing;
    }

    @Override
    public void setTempUnit(TempUnit unit, Current current) {
        super.setTempUnit(unit, current);
        TemperatureUtil.convertTemp(unit, freezerTemperature);
    }
}
