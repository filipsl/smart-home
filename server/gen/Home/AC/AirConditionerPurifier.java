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

public interface AirConditionerPurifier extends AirConditioner
{
    void setPollutionTreshLevel(PollutionLevel pollutionLevel, com.zeroc.Ice.Current current);

    PollutionLevel getPollutionTreshLevel(com.zeroc.Ice.Current current);

    boolean isPurifyingOn(com.zeroc.Ice.Current current)
        throws Home.SwitchedOffError;

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Home::AC::AirConditioner",
        "::Home::AC::AirConditionerPurifier",
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
        return "::Home::AC::AirConditionerPurifier";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setPollutionTreshLevel(AirConditionerPurifier obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        PollutionLevel iceP_pollutionLevel;
        iceP_pollutionLevel = PollutionLevel.ice_read(istr);
        inS.endReadParams();
        obj.setPollutionTreshLevel(iceP_pollutionLevel, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getPollutionTreshLevel(AirConditionerPurifier obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        PollutionLevel ret = obj.getPollutionTreshLevel(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        PollutionLevel.ice_write(ostr, ret);
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
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_isPurifyingOn(AirConditionerPurifier obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        boolean ret = obj.isPurifyingOn(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getAutoStartParams",
        "getPollutionTreshLevel",
        "getPowerState",
        "getTargetTemperature",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "isPurifyingOn",
        "setAutoStart",
        "setPollutionTreshLevel",
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
                return AirConditioner._iceD_getAutoStartParams(this, in, current);
            }
            case 1:
            {
                return _iceD_getPollutionTreshLevel(this, in, current);
            }
            case 2:
            {
                return Home.Device._iceD_getPowerState(this, in, current);
            }
            case 3:
            {
                return AirConditioner._iceD_getTargetTemperature(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 5:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 6:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 7:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 8:
            {
                return _iceD_isPurifyingOn(this, in, current);
            }
            case 9:
            {
                return AirConditioner._iceD_setAutoStart(this, in, current);
            }
            case 10:
            {
                return _iceD_setPollutionTreshLevel(this, in, current);
            }
            case 11:
            {
                return Home.Device._iceD_setPowerState(this, in, current);
            }
            case 12:
            {
                return AirConditioner._iceD_setTargetTemperature(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}