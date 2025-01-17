package server;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;
import devices.DeviceImpl;
import devices.ac.AirConditionerImpl;
import devices.ac.AirConditionerPurifierImpl;
import devices.kitchen.OvenImpl;
import devices.kitchen.RefrigeratorImpl;
import devices.kitchen.RefrigeratorWithFreezerImpl;
import devices.kitchen.RefrigeratorWithRadioImpl;

import java.util.List;

public class MyServantLocator implements ServantLocator {

    private List<DeviceImpl> deviceImplList;
    private ObjectAdapter adapter;

    public MyServantLocator(List<DeviceImpl> deviceImplList, ObjectAdapter adapter) {
        this.deviceImplList = deviceImplList;
        this.adapter = adapter;
    }

    @Override
    public LocateResult locate(Current current) {
        String category = current.id.category;
        String name = current.id.name;

        DeviceImpl servant = null;

        if (category.equals("ac")) {
            switch (name) {
                case "ac1":
                case "ac2":
                    servant = new AirConditionerImpl();
                    break;
                case "ac-purifier1":
                    servant = new AirConditionerPurifierImpl();
                    break;
            }
        } else if (category.equals("kitchen")) {
            switch (name) {
                case "oven1":
                case "oven2":
                    servant = new OvenImpl();
                    break;
                case "fridge1":
                    servant = new RefrigeratorImpl();
                    break;
                case "fridge-radio1":
                    servant = new RefrigeratorWithRadioImpl();
                    break;
                case "fridge-freezer1":
                    servant = new RefrigeratorWithFreezerImpl();
                    break;
            }
        }

        if (servant != null) {
            adapter.add(servant, new Identity(name, category));
            deviceImplList.add(servant);
            Server.logger.info("ServantLocator initialized new servant - name: " + name + ", category " + category);
            return new LocateResult(servant, null);
        }
        return null;
    }

    @Override
    public void finished(Current current, Object object, java.lang.Object o) {

    }

    @Override
    public void deactivate(String s) {

    }
}
