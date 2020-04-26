package utils;

public class TemperatureConverter {

    public static double FtoC(double temperature) {
        return ((temperature - 32) * 5) / 9;
    }

    public static double CtoF(double temperature) {
        return 9 * temperature / 5 + 32;
    }

}
