from Home import PowerState, TempUnit, Temperature


def get_power_state(device):
    try:
        print(device.getPowerState())
    except Exception as e:
        print(e)


def set_power_state(device, pstate_str):
    try:
        if pstate_str == 'ON':
            device.setPowerState(PowerState.ON)
        elif pstate_str == 'OFF':
            device.setPowerState(PowerState.OFF)
        else:
            print('Unknown parameter {}'.format(pstate_str))
    except Exception as e:
        print(e)


def set_fridge_temp(device, value, unit_str):
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


def get_fridge_temp(device):
    try:
        temp = device.getFridgeTemperature()
        print('Fridge temperature ', temp.value, temp.unit)
    except Exception as e:
        print(e)


def set_temp_unit(device, unit_str):
    try:
        unit = TempUnit.CELSIUS
        if unit_str == 'C':
            unit = TempUnit.CELSIUS
        elif unit_str == 'F':
            unit = TempUnit.FAHRENHEIT
        else:
            print('Unknown unit {}'.format(unit_str))
        device.setTempUnit(unit)
    except Exception as e:
        print(e)


