import logging
import os
import sys
import Ice

from Home.Kitchen import RefrigeratorPrx, RefrigeratorWithFreezerPrx, RefrigeratorWithRadioPrx, OvenPrx
from Home.AC import AirConditionerPrx, AirConditionerPurifierPrx
from Home import PowerState
from smart_home_commands import get_power_state, set_power_state, set_fridge_temp, set_temp_unit


class Command:
    def __init__(self, command, callback, desc, args_num):
        self.command = command
        self.callback = callback
        self.desc = desc
        self.args_num = args_num


class DeviceParams:
    def __init__(self, name, device_prx):
        self.name = name
        self.device_prx = device_prx
        self.commands = []


class SmartHomeClient:
    def __init__(self):
        self.is_running = True
        self.devices_params = []

    def init_device_params(self, communicator):
        base_commands = [Command('pstate', get_power_state, 'check power state', 0),
                         Command('set-pstate', set_power_state, 'set power state to ON or OFF: set OFF', 1)]

        fridge_commands = [
            Command('set-temp', set_fridge_temp, 'set fridge temperature with unit C or F: set-temp 6 C', 2),
            Command('get-temp', set_fridge_temp, 'get fridge temperature', 0),
            Command('set-unit', set_temp_unit, 'set device temperature unit C or F: set-unit C', 0)
        ]

        base = communicator.propertyToProxy('Fridge1.Proxy')
        self.devices_params.append(DeviceParams('Fridge1', device_prx=RefrigeratorPrx.uncheckedCast(base)))


        # TODO Implement methods below

        fridge_freezer_commands = [
            Command('set-f-temp', set_fridge_temp, 'set freezer temperature with unit C or F: set-temp 6 C', 2),
            Command('get-f-temp', set_fridge_temp, 'get freezer temperature', 0),
            Command('set-turbo', set_fridge_temp, 'set turbo freezing mode to ON or OFF: set-turbo ON', 1),
            Command('get-turbo', set_temp_unit, 'check state of turbo freezing mode', 0)
        ]

        base = communicator.propertyToProxy('FridgeF1.Proxy')
        self.devices_params.append(
            DeviceParams('FridgeF1', device_prx=RefrigeratorWithFreezerPrx.uncheckedCast(base)))

        fridge_radio_commands = [
            Command('set-f-temp', set_fridge_temp, 'set freezer temperature with unit C or F: set-temp 6 C', 2),
            Command('get-f-temp', set_fridge_temp, 'get freezer temperature', 0),
            Command('set-turbo', set_fridge_temp, 'set turbo freezing mode to ON or OFF: set-turbo ON', 1),
            Command('get-turbo', set_temp_unit, 'check state of turbo freezing mode', 0)
        ]

        base = communicator.propertyToProxy('FridgeR1.Proxy')
        self.devices_params.append(
            DeviceParams('FridgeR1', device_prx=RefrigeratorWithRadioPrx.uncheckedCast(base)))

        base = communicator.propertyToProxy('AC1.Proxy')
        self.devices_params.append(DeviceParams('AC1', device_prx=AirConditionerPrx.uncheckedCast(base)))

        base = communicator.propertyToProxy('ACP1.Proxy')
        self.devices_params.append(DeviceParams('ACP1', device_prx=AirConditionerPurifierPrx.uncheckedCast(base)))

        base = communicator.propertyToProxy('Oven1.Proxy')
        self.devices_params.append(DeviceParams('Oven1', device_prx=OvenPrx.uncheckedCast(base)))

    def print_devices(self):
        av_devices = 'Available devices: '
        for device_params in self.devices_params:
            av_devices += device_params.name + ' '
        logging.info(av_devices)

    def run_console(self):
        self.print_devices()
        prefix = ''
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
                        print('help - show help')
                        print('exit - shut down client')
                else:
                    pass
            # todo device control mode

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
