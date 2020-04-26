package utils;

import Home.TempUnit;
import Home.Temperature;

public class TemperatureUtil {

    public static double FtoC(double temperature) {
        return ((temperature - 32) * 5) / 9;
    }

    public static double CtoF(double temperature) {
        return 9 * temperature / 5 + 32;
    }

    public static boolean tempInRange(Temperature temperature, double min, double max, TempUnit tempUnit) {
        if (min <= max) {
            if (tempUnit == temperature.unit) {
                return temperature.value >= min && temperature.value <= max;
            } else if (temperature.unit == TempUnit.FAHRENHEIT) {
                min = CtoF(min);
                max = CtoF(max);
                return temperature.value >= min && temperature.value <= max;
            } else {
                min = FtoC(min);
                max = FtoC(max);
                return temperature.value >= min && temperature.value <= max;
            }
        }
        return false;
    }
}
