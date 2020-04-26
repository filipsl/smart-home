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

package Home.AC;

public interface AirConditioner extends Home.Device
{
    void setTargetTemperature(Home.Temperature temp, com.zeroc.Ice.Current current)
        throws Home.TemperatureRangeError;

    Home.Temperature getTargetTemperature(com.zeroc.Ice.Current current);

    void setAutoStart(Home.AutoStartParams autoStartParams, com.zeroc.Ice.Current current)
        throws Home.DurationError,
               Home.TimeRangeError;

    Home.AutoStartParams getAutoStartParams(com.zeroc.Ice.Current current)
        throws Home.NotDefinedError;

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Home::AC::AirConditioner",
        "::Home::Device",
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
        return "::Home::AC::AirConditioner";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setTargetTemperature(AirConditioner obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Home.Temperature iceP_temp;
        iceP_temp = Home.Temperature.ice_read(istr);
        inS.endReadParams();
        obj.setTargetTemperature(iceP_temp, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getTargetTemperature(AirConditioner obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        Home.Temperature ret = obj.getTargetTemperature(current);
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
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setAutoStart(AirConditioner obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Home.AutoStartParams iceP_autoStartParams;
        iceP_autoStartParams = Home.AutoStartParams.ice_read(istr);
        inS.endReadParams();
        obj.setAutoStart(iceP_autoStartParams, current);
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
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getAutoStartParams(AirConditioner obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        Home.AutoStartParams ret = obj.getAutoStartParams(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        Home.AutoStartParams.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getAutoStartParams",
        "getPowerState",
        "getTargetTemperature",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "setAutoStart",
        "setPowerState",
        "setTargetTemperature"
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
                return _iceD_getAutoStartParams(this, in, current);
            }
            case 1:
            {
                return Home.Device._iceD_getPowerState(this, in, current);
            }
            case 2:
            {
                return _iceD_getTargetTemperature(this, in, current);
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
                return _iceD_setAutoStart(this, in, current);
            }
            case 8:
            {
                return Home.Device._iceD_setPowerState(this, in, current);
            }
            case 9:
            {
                return _iceD_setTargetTemperature(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}