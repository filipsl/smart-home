import logging
import os
import sys
import Ice

from Home.Kitchen import RefrigeratorPrx, RefrigeratorWithFreezerPrx, RefrigeratorWithRadioPrx, OvenPrx
from Home.AC import AirConditionerPrx, AirConditionerPurifierPrx

from smart_home_commands import get_power_state, set_power_state, set_fridge_temp, set_temp_unit, set_freezer_temp, \
    get_freezer_temp, set_turbo, get_turbo, set_freq, get_freq, set_radio_power_state, get_radio_power_state, \
    set_ac_temp, get_ac_temp, set_auto, get_auto, set_ac_level, get_ac_level, get_puri, start_baking, is_baking, \
    get_baking, get_fridge_temp, set_radio_level, get_radio_level


class Command:
    def __init__(self, command, callback, desc, args_num):
        self.command = command
        self.callback = callback
        self.desc = desc
        self.args_num = args_num


class DeviceParams:
    def __init__(self, name, device_prx, commands):
        self.name = name
        self.device_prx = device_prx
        self.commands = commands


class SmartHomeClient:
    def __init__(self):
        self.is_running = True
        self.devices_params = []

    def init_device_params(self, communicator):
        base_commands = [Command('pstate', get_power_state, 'check power state', 0),
                         Command('set-pstate', set_power_state, 'set power state to ON or OFF: set-pstate OFF', 1)]

        fridge_commands = [
            Command('set-temp', set_fridge_temp, 'set fridge temperature with unit C or F: set-temp 6 C', 2),
            Command('get-temp', get_fridge_temp, 'get fridge temperature', 0),
            Command('set-unit', set_temp_unit, 'set device temperature unit C or F: set-unit C', 1)
        ]

        commands = base_commands + fridge_commands
        base = communicator.propertyToProxy('Fridge1.Proxy')
        self.devices_params.append(DeviceParams('Fridge1', RefrigeratorPrx.uncheckedCast(base), commands))

        fridge_freezer_commands = [
            Command('set-f-temp', set_freezer_temp, 'set freezer temperature with unit C or F: set-temp 6 C', 2),
            Command('get-f-temp', get_freezer_temp, 'get freezer temperature', 0),
            Command('set-turbo', set_turbo, 'set turbo freezing mode to ON or OFF: set-turbo ON', 1),
            Command('get-turbo', get_turbo, 'check state of turbo freezing mode', 0)
        ]

        commands = base_commands + fridge_commands + fridge_freezer_commands
        base = communicator.propertyToProxy('FridgeF1.Proxy')
        self.devices_params.append(
            DeviceParams('FridgeF1', RefrigeratorWithFreezerPrx.uncheckedCast(base), commands))

        fridge_radio_commands = [
            Command('set-freq', set_freq, 'set radio frequency in MHz : set-freq 97', 1),
            Command('get-freq', get_freq, 'get radio frequency', 0),
            Command('pstate-radio', get_radio_power_state, 'check radio power state', 0),
            Command('set-pstate-radio', set_radio_power_state,
                    'set power state to ON or OFF for radio: set-pstate-radio OFF', 1),
            Command('set-level', set_radio_level,
                    'set volume level [range 0-100]', 1),
            Command('get-level', get_radio_level,
                    'get volume level of radio', 0),
        ]

        commands = base_commands + fridge_commands + fridge_radio_commands
        base = communicator.propertyToProxy('FridgeR1.Proxy')
        self.devices_params.append(
            DeviceParams('FridgeR1', RefrigeratorWithRadioPrx.uncheckedCast(base), commands))

        ac_commands = [
            Command('set-temp', set_ac_temp, 'set AC target temperature with unit C or F: set-temp 15 C', 2),
            Command('get-temp', get_ac_temp, 'get AC target temperature', 0),
            Command('set-auto', set_auto,
                    'set automatic start parameters HH MM duration_mins: set-auto 12 00 15', 3),
            Command('get-auto', get_auto, 'get automatic start parameters', 0)
        ]

        commands = base_commands + ac_commands
        base = communicator.propertyToProxy('AC1.Proxy')
        self.devices_params.append(DeviceParams('AC1', AirConditionerPrx.uncheckedCast(base), ac_commands))

        ac_purifier_commands = [
            Command('set-level', set_ac_level,
                    'set threshold level of air pollution [LOW, MEDIUM, HIGH]: set-level LOW', 1),
            Command('get-level', get_ac_level,
                    'get threshold level of air pollution required to turn on air purifier module', 0),
            Command('get-puri', get_puri,
                    'check if air purifier module is on', 0),
        ]

        commands = base_commands + ac_commands + ac_purifier_commands
        base = communicator.propertyToProxy('ACP1.Proxy')
        self.devices_params.append(DeviceParams('ACP1', AirConditionerPurifierPrx.uncheckedCast(base), commands))

        oven_commands = [
            Command('start-baking', start_baking,
                    'start baking - set side [UP, DOWN, BOTH], temperature with unit, duration in minutes: '
                    'start-baking UP 100 C 30',
                    4),
            Command('is-baking', is_baking,
                    'check if baking is going on in the oven', 0),
            Command('get-baking', get_baking,
                    'get baking parameters', 0),
        ]

        commands = base_commands + oven_commands
        base = communicator.propertyToProxy('Oven1.Proxy')
        self.devices_params.append(DeviceParams('Oven1', OvenPrx.uncheckedCast(base), commands))

    def get_devices_string(self):
        av_devices = 'Available devices: '
        for device_params in self.devices_params:
            av_devices += device_params.name + ' '
        return av_devices

    def print_devices(self):
        logging.info(self.get_devices_string())

    def run_console(self):
        self.print_devices()
        prefix = ''
        device_params = None
        prompt_msg = '$ '
        while self.is_running:
            text = input(prefix + prompt_msg)
            if text:
                args = text.split()
                if not prefix:
                    if args[0] == 'exit':
                        self.is_running = False
                    elif args[0] == 'help':
                        print('device_id - enter device control mode')
                        print('devices - show available devices')
                        print('help - show help')
                        print('exit - shut down client')
                    elif args[0] == 'devices':
                        print(self.get_devices_string())
                    else:
                        for dp in self.devices_params:
                            if dp.name == args[0]:
                                prefix = args[0]
                                device_params = dp
                else:
                    if args[0] == 'exit':
                        prefix = ''
                    elif args[0] == 'help':
                        for command in device_params.commands:
                            print(command.command, ' - ', command.desc)
                    elif args[0] == 'devices':
                        print(self.get_devices_string())
                    else:
                        command_found = False
                        for command in device_params.commands:
                            if command.command == args[0]:
                                if command.args_num == len(args) - 1:
                                    command.callback(device_params.device_prx, args)
                                else:
                                    print('Wrong number of parameters')
                                    print(command.command, ' - ', command.desc)
                                command_found = True
                                break
                        if not command_found:
                            print('Command not found')

    def run(self):
        logging.info('Starting smart home client...')
        with Ice.initialize(sys.argv) as communicator:
            self.init_device_params(communicator)
            self.run_console()


if __name__ == '__main__':
    try:
        logging.basicConfig(format='%(asctime)s %(message)s', datefmt='%m/%d/%Y %H:%M:%S', level=logging.DEBUG)
        alert_client = SmartHomeClient()
        alert_client.run()
        print('Smart home client shut down')
    except KeyboardInterrupt:
        print('Smart home client shut down')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
