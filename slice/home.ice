
#ifndef HOME_ICE
#define HOME_ICE

module Home
{
    enum PowerState { ON, OFF };
    enum TempUnit { CELSIUS, FAHRENHEIT };

    struct Temperature{
        double value;
        TempUnit unit;
    };

    struct TimeOfDay{
        short hour;
        short minute;
    };

    struct AutoStartParams{
        TimeOfDay timeOfDay;
        int durationMins;
    };

    exception ErrorBase
    {
        string reason;
    };

    exception SwitchedOffError extends ErrorBase {};
    exception NotDefinedError extends ErrorBase {};

    exception TemperatureRangeError extends ErrorBase
    {
        double minTemp;
        double maxTemp;
        TempUnit unit;
    };

    exception TimeRangeError extends ErrorBase
    {
        short minHour;
        short maxHour;
        short minMinute;
        short maxMinute;
    };

    exception DurationError extends ErrorBase{
        int minDurationMins;
        int maxDurationMins;
    };

    interface Device{
        PowerState getPowerState();
        void setPowerState(PowerState powerState);
    };


    module AC{

        enum PollutionLevel { LOW, MEDIUM, HIGH };

        interface AirConditioner extends Device{
            void setTargetTemperature(Home::Temperature temp) throws Home::TemperatureRangeError;
            Home::Temperature getTargetTemperature();
            void setAutoStart(Home::AutoStartParams autoStartParams) throws Home::TimeRangeError, Home::DurationError;
            Home::AutoStartParams getAutoStartParams() throws Home::NotDefinedError;
        };

        interface AirConditionerPurifier extends AirConditioner{
            void setPollutionTreshLevel(PollutionLevel pollutionLevel);
            PollutionLevel getPollutionTreshLevel();
            bool isPurifyingOn() throws Home::SwitchedOffError;
        };

    };

    module Kitchen{

        interface Refrigerator extends Device{
            void setFridgeTemperature(Home::Temperature temperature) throws Home::TemperatureRangeError;
            Home::Temperature getFridgeTemperature() throws Home::SwitchedOffError;
            void setTempUnit(Home::TempUnit unit);
        };

        interface RefrigeratorWithFreezer extends Refrigerator{
            void setFreezerTemperature(Home::Temperature temperature) throws Home::SwitchedOffError,
                                                                             Home::TemperatureRangeError;
            Home::Temperature getFreezerTemperature() throws Home::SwitchedOffError;
            bool isTurboFreezingOn() throws Home::SwitchedOffError;
            void setTurboFreezing(bool turboFreezing) throws Home::SwitchedOffError;
        };

        exception FrequencyRangeError extends Home::ErrorBase{
            double minFreq;
            double maxFreq;
        };

        exception VolumeRangeError extends Home::ErrorBase{
            short minVolumeLevel;
            short maxVolumeLevel;
        };

        interface RefrigeratorWithRadio extends Refrigerator{
            void setFrequency(double freq) throws FrequencyRangeError;
            double getFrequency();
            Home::PowerState getRadioPowerState();
            void setRadioPowerState(Home::PowerState powerState);
            void setVolumeLevel(short level) throws VolumeRangeError;
            short getVolumeLevel();
        };

        enum BakingSide { UP, DOWN, BOTH };

        struct BakingParams{
            BakingSide side;
            Home::Temperature temperature;
            int durationMins;
        };

        interface Oven extends Device{
            void startBaking(BakingParams bakingParams) throws Home::SwitchedOffError,
                                                               Home::TemperatureRangeError,
                                                               Home::DurationError;
            bool isBakingNow() throws Home::SwitchedOffError;
            BakingParams getBakingParams() throws Home::NotDefinedError, Home::SwitchedOffError;
        };
    };
};

#endif
