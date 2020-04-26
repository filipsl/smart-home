package devices.kitchen;

import Home.*;
import Home.Kitchen.Refrigerator;
import com.zeroc.Ice.Current;
import devices.DeviceImpl;
import server.Server;
import utils.TemperatureUtil;

public class RefrigeratorImpl extends DeviceImpl implements Refrigerator {

    protected Temperature fridgeTemperature = new Temperature(5, TempUnit.CELSIUS);

    @Override
    public void setFridgeTemperature(Temperature temperature, Current current) throws TemperatureRangeError {
        Server.logger.info("Set temperature for refrigerator");

        if (!TemperatureUtil.tempInRange(temperature, 2, 12, TempUnit.CELSIUS)) {
            if (temperature.unit == TempUnit.CELSIUS) {
                throw new TemperatureRangeError("Invalid temperature value.", 2, 12, TempUnit.CELSIUS);
            } else {
                throw new TemperatureRangeError("Invalid temperature value.",
                        TemperatureUtil.CtoF(2),
                        TemperatureUtil.CtoF(12),
                        TempUnit.FAHRENHEIT);
            }
        }
        this.fridgeTemperature = temperature;
    }

    @Override
    public Temperature getFridgeTemperature(Current current) throws SwitchedOffError {
        Server.logger.info("Get temperature of refrigerator");

        if (super.powerState == PowerState.OFF) {
            throw new SwitchedOffError("Refrigerator is switched off.");
        }
        return fridgeTemperature;
    }

    @Override
    public void setTempUnit(TempUnit unit, Current current) {
        Server.logger.info("Set temperature unit for refrigerator");
        TemperatureUtil.convertTemp(unit, fridgeTemperature);
    }
}
