from Home import PowerState, TempUnit, Temperature, AutoStartParams, TimeOfDay
from Home.AC import PollutionLevel
from Home.Kitchen import BakingSide, BakingParams


def get_power_state(device, args):
    try:
        print(device.getPowerState())
    except Exception as e:
        print(e)


def set_power_state(device, args):
    pstate_str = args[1]
    try:
        if pstate_str == 'ON':
            device.setPowerState(PowerState.ON)
        elif pstate_str == 'OFF':
            device.setPowerState(PowerState.OFF)
        else:
            print('Unknown parameter {}'.format(pstate_str))
    except Exception as e:
        print(e)


def set_fridge_temp(device, args):
    value = args[1]
    unit_str = args[2]
    try:
        value = float(value)
        unit = TempUnit.CELSIUS
        if unit_str == 'C':
            unit = TempUnit.CELSIUS
        elif unit_str == 'F':
            unit = TempUnit.FAHRENHEIT
        else:
            print('Unknown unit {}'.format(unit_str))
        temp = Temperature(value, unit)
        device.setFridgeTemperature(temp)
    except Exception as e:
        print(e)


def get_fridge_temp(device, args):
    try:
        temp = device.getFridgeTemperature()
        print('Fridge temperature {:.2f} {}'.format(temp.value, temp.unit))
    except Exception as e:
        print(e)


def set_temp_unit(device, args):
    unit_str = args[1]
    try:
        if unit_str == 'C':
            unit = TempUnit.CELSIUS
            device.setTempUnit(unit)
        elif unit_str == 'F':
            unit = TempUnit.FAHRENHEIT
            device.setTempUnit(unit)
        else:
            print('Unknown unit {}'.format(unit_str))
    except Exception as e:
        print(e)


def set_freezer_temp(device, args):
    value = args[1]
    unit_str = args[2]
    try:
        value = float(value)
        unit = TempUnit.CELSIUS
        if unit_str == 'C':
            unit = TempUnit.CELSIUS
        elif unit_str == 'F':
            unit = TempUnit.FAHRENHEIT
        else:
            print('Unknown unit {}'.format(unit_str))
        temp = Temperature(value, unit)
        device.setFreezerTemperature(temp)
    except Exception as e:
        print(e)


def get_freezer_temp(device, args):
    try:
        temp = device.getFreezerTemperature()
        print('Freezer temperature {:.2f} {}'.format(temp.value, temp.unit))
    except Exception as e:
        print(e)


def set_turbo(device, args):
    mode = args[1]
    try:
        if mode == 'ON':
            device.setTurboFreezing(True)
        elif mode == 'OFF':
            device.setTurboFreezing(False)
        else:
            print('Unknown mode {}'.format(mode))
    except Exception as e:
        print(e)


def get_turbo(device, args):
    try:
        if device.isTurboFreezingOn():
            print('Turbo is ON')
        else:
            print('Turbo is OFF')
    except Exception as e:
        print(e)


def set_freq(device, args):
    value = args[1]
    try:
        value = float(value)
        device.setFrequency(value)
    except Exception as e:
        print(e)


def get_freq(device, args):
    try:
        value = device.getFrequency()
        print('Radio frequency is {:.2f} MHz'.format(value))

    except Exception as e:
        print(e)


def get_radio_power_state(device, args):
    try:
        print(device.getRadioPowerState())
    except Exception as e:
        print(e)


def set_radio_power_state(device, args):
    pstate_str = args[1]
    try:
        if pstate_str == 'ON':
            device.setRadioPowerState(PowerState.ON)
        elif pstate_str == 'OFF':
            device.setRadioPowerState(PowerState.OFF)
        else:
            print('Unknown parameter {}'.format(pstate_str))
    except Exception as e:
        print(e)


def set_radio_level(device, args):
    level = args[1]
    try:
        device.setVolumeLevel(int(level))
    except Exception as e:
        print(e)


def get_radio_level(device, args):
    try:
        print('Radio volume level {}'.format(device.getVolumeLevel()))
    except Exception as e:
        print(e)


def set_ac_temp(device, args):
    value = args[1]
    unit_str = args[2]
    try:
        value = float(value)
        unit = TempUnit.CELSIUS
        if unit_str == 'C':
            unit = TempUnit.CELSIUS
        elif unit_str == 'F':
            unit = TempUnit.FAHRENHEIT
        else:
            print('Unknown unit {}'.format(unit_str))
        temp = Temperature(value, unit)
        device.setTargetTemperature(temp)
    except Exception as e:
        print(e)


def get_ac_temp(device, args):
    try:
        temp = device.getTargetTemperature()
        print('AC target temperature {:.2f} {}'.format(temp.value, temp.unit))
    except Exception as e:
        print(e)


def set_auto(device, args):
    hour = args[1]
    minute = args[2]
    duration = args[3]
    try:
        hour = int(hour)
        minute = int(minute)
        duration = int(duration)

        time = TimeOfDay(hour, minute)
        params = AutoStartParams(time, duration)
        device.setAutoStart(params)
    except Exception as e:
        print(e)


def get_auto(device, args):
    try:
        params = device.getAutoStartParams()
        print("Start time: {:02d}:{:02d}  duration: {:} min".format(params.timeOfDay.hour, params.timeOfDay.minute,
                                                                    params.durationMins))
    except Exception as e:
        print(e)


def set_ac_level(device, args):
    level = args[1]
    try:
        if level == 'LOW':
            device.setPollutionTreshLevel(PollutionLevel.LOW)
        elif level == 'MEDIUM':
            device.setPollutionTreshLevel(PollutionLevel.MEDIUM)
        elif level == 'HIGH':
            device.setPollutionTreshLevel(PollutionLevel.HIGH)
        else:
            print('Unknown level {}'.format(level))
    except Exception as e:
        print(e)


def get_ac_level(device, args):
    try:
        thresh = device.getPollutionTreshLevel()
        print(thresh)
    except Exception as e:
        print(e)


def get_puri(device, args):
    try:
        if device.isPurifyingOn():
            print('Purifying is ON')
        else:
            print('Purifying is OFF')
    except Exception as e:
        print(e)


def start_baking(device, args):
    side = args[1]
    val = args[2]
    unit = args[3]
    duration = args[4]
    try:
        valid = True
        duration = int(duration)
        val = float(val)
        if side == 'UP':
            side = BakingSide.UP
        elif side == 'DOWN':
            side = BakingSide.DOWN
        elif side == 'BOTH':
            side = BakingSide.BOTH
        else:
            print('Unknown side {}'.format(side))
            valid = False

        if unit == 'C':
            unit = TempUnit.CELSIUS
        elif unit == 'F':
            unit = TempUnit.FAHRENHEIT
        else:
            print('Unknown unit {}'.format(unit))
            valid = False

        if valid:
            temp = Temperature(val, unit)
            baking_params = BakingParams(side, temp, duration)
            device.startBaking(baking_params)
    except Exception as e:
        print(e)


def is_baking(device, args):
    try:
        if device.isBakingNow():
            print('Baking is going on')
        else:
            print('Nothing is being baked right now')
    except Exception as e:
        print(e)


def get_baking(device, args):
    try:
        params = device.getBakingParams()
        print('Baking params: side {}, temperature {} {}, duration {} min'.format(params.side, params.temperature.value,
                                                                                  params.temperature.unit,
                                                                                  params.durationMins))
    except Exception as e:
        print(e)
