import logging
import os
import sys
import Ice

from Home.Kitchen import RefrigeratorPrx, RefrigeratorWithFreezerPrx, RefrigeratorWithRadioPrx, OvenPrx
from Home.AC import AirConditionerPrx, AirConditionerPurifierPrx
from Home import PowerState

class DeviceParams:
    def __init__(self, name, device_prx):
        self.name = name
        self.device_prx = device_prx


class SmartHomeClient:
    def __init__(self):
        self.is_running = True
        self.devices_params = []

    def init_device_params(self, communicator):
        base = communicator.propertyToProxy('Fridge1.Proxy')
        self.devices_params.append(DeviceParams('Fridge1', device_prx=RefrigeratorPrx.uncheckedCast(base)))

        base = communicator.propertyToProxy('FridgeF1.Proxy')
        self.devices_params.append(
            DeviceParams('FridgeF1', device_prx=RefrigeratorWithFreezerPrx.uncheckedCast(base)))

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
        print('Available devices:', end=' ')
        for device_params in self.devices_params:
            print(device_params.name, end=' ')
        print()

    def run_console(self):
        self.print_devices()
        prefix = ''
        prompt_msg = '$ '
        while self.is_running:
            text = input(prefix + prompt_msg)
            if text:
                args = text.split()
                if args[0] == 'exit':
                    if prefix:
                        prefix = ''
                    else:
                        self.is_running = False
                elif args[0] == 'test':
                    print(self.devices_params[0].device_prx.getPowerState())
                    print(self.devices_params[0].device_prx.setPowerState(PowerState.ON))

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
