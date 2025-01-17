//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.3
//
// <auto-generated>
//
// Generated from file `home.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Home.Kitchen;

public interface RefrigeratorWithFreezer extends Refrigerator
{
    void setFreezerTemperature(Home.Temperature temperature, com.zeroc.Ice.Current current)
        throws Home.SwitchedOffError,
               Home.TemperatureRangeError;

    Home.Temperature getFreezerTemperature(com.zeroc.Ice.Current current)
        throws Home.SwitchedOffError;

    boolean isTurboFreezingOn(com.zeroc.Ice.Current current)
        throws Home.SwitchedOffError;

    void setTurboFreezing(boolean turboFreezing, com.zeroc.Ice.Current current)
        throws Home.SwitchedOffError;

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Home::Device",
        "::Home::Kitchen::Refrigerator",
        "::Home::Kitchen::RefrigeratorWithFreezer",
        "::Ice::Object"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::Home::Kitchen::RefrigeratorWithFreezer";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setFreezerTemperature(RefrigeratorWithFreezer obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Home.Temperature iceP_temperature;
        iceP_temperature = Home.Temperature.ice_read(istr);
        inS.endReadParams();
        obj.setFreezerTemperature(iceP_temperature, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getFreezerTemperature(RefrigeratorWithFreezer obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        Home.Temperature ret = obj.getFreezerTemperature(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        Home.Temperature.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_isTurboFreezingOn(RefrigeratorWithFreezer obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        boolean ret = obj.isTurboFreezingOn(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setTurboFreezing(RefrigeratorWithFreezer obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        boolean iceP_turboFreezing;
        iceP_turboFreezing = istr.readBool();
        inS.endReadParams();
        obj.setTurboFreezing(iceP_turboFreezing, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getFreezerTemperature",
        "getFridgeTemperature",
        "getPowerState",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "isTurboFreezingOn",
        "setFreezerTemperature",
        "setFridgeTemperature",
        "setPowerState",
        "setTempUnit",
        "setTurboFreezing"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return _iceD_getFreezerTemperature(this, in, current);
            }
            case 1:
            {
                return Refrigerator._iceD_getFridgeTemperature(this, in, current);
            }
            case 2:
            {
                return Home.Device._iceD_getPowerState(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 5:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 6:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 7:
            {
                return _iceD_isTurboFreezingOn(this, in, current);
            }
            case 8:
            {
                return _iceD_setFreezerTemperature(this, in, current);
            }
            case 9:
            {
                return Refrigerator._iceD_setFridgeTemperature(this, in, current);
            }
            case 10:
            {
                return Home.Device._iceD_setPowerState(this, in, current);
            }
            case 11:
            {
                return Refrigerator._iceD_setTempUnit(this, in, current);
            }
            case 12:
            {
                return _iceD_setTurboFreezing(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
