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

public interface RefrigeratorWithRadioPrx extends RefrigeratorPrx
{
    default void setFrequency(double freq)
        throws FrequencyRangeError
    {
        setFrequency(freq, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setFrequency(double freq, java.util.Map<String, String> context)
        throws FrequencyRangeError
    {
        try
        {
            _iceI_setFrequencyAsync(freq, context, true).waitForResponseOrUserEx();
        }
        catch(FrequencyRangeError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setFrequencyAsync(double freq)
    {
        return _iceI_setFrequencyAsync(freq, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setFrequencyAsync(double freq, java.util.Map<String, String> context)
    {
        return _iceI_setFrequencyAsync(freq, context, false);
    }

    /**
     * @hidden
     * @param iceP_freq -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setFrequencyAsync(double iceP_freq, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setFrequency", null, sync, _iceE_setFrequency);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeDouble(iceP_freq);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setFrequency =
    {
        FrequencyRangeError.class
    };

    default double getFrequency()
    {
        return getFrequency(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getFrequency(java.util.Map<String, String> context)
    {
        return _iceI_getFrequencyAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getFrequencyAsync()
    {
        return _iceI_getFrequencyAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getFrequencyAsync(java.util.Map<String, String> context)
    {
        return _iceI_getFrequencyAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getFrequencyAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getFrequency", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    default Home.PowerState getRadioPowerState()
    {
        return getRadioPowerState(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Home.PowerState getRadioPowerState(java.util.Map<String, String> context)
    {
        return _iceI_getRadioPowerStateAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Home.PowerState> getRadioPowerStateAsync()
    {
        return _iceI_getRadioPowerStateAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Home.PowerState> getRadioPowerStateAsync(java.util.Map<String, String> context)
    {
        return _iceI_getRadioPowerStateAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Home.PowerState> _iceI_getRadioPowerStateAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Home.PowerState> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getRadioPowerState", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Home.PowerState ret;
                     ret = Home.PowerState.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default void setRadioPowerState(Home.PowerState powerState)
    {
        setRadioPowerState(powerState, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setRadioPowerState(Home.PowerState powerState, java.util.Map<String, String> context)
    {
        _iceI_setRadioPowerStateAsync(powerState, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> setRadioPowerStateAsync(Home.PowerState powerState)
    {
        return _iceI_setRadioPowerStateAsync(powerState, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setRadioPowerStateAsync(Home.PowerState powerState, java.util.Map<String, String> context)
    {
        return _iceI_setRadioPowerStateAsync(powerState, context, false);
    }

    /**
     * @hidden
     * @param iceP_powerState -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setRadioPowerStateAsync(Home.PowerState iceP_powerState, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setRadioPowerState", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     Home.PowerState.ice_write(ostr, iceP_powerState);
                 }, null);
        return f;
    }

    default void setVolumeLevel(short level)
        throws VolumeRangeError
    {
        setVolumeLevel(level, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setVolumeLevel(short level, java.util.Map<String, String> context)
        throws VolumeRangeError
    {
        try
        {
            _iceI_setVolumeLevelAsync(level, context, true).waitForResponseOrUserEx();
        }
        catch(VolumeRangeError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setVolumeLevelAsync(short level)
    {
        return _iceI_setVolumeLevelAsync(level, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setVolumeLevelAsync(short level, java.util.Map<String, String> context)
    {
        return _iceI_setVolumeLevelAsync(level, context, false);
    }

    /**
     * @hidden
     * @param iceP_level -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setVolumeLevelAsync(short iceP_level, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setVolumeLevel", null, sync, _iceE_setVolumeLevel);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeShort(iceP_level);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setVolumeLevel =
    {
        VolumeRangeError.class
    };

    default short getVolumeLevel()
    {
        return getVolumeLevel(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default short getVolumeLevel(java.util.Map<String, String> context)
    {
        return _iceI_getVolumeLevelAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getVolumeLevelAsync()
    {
        return _iceI_getVolumeLevelAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Short> getVolumeLevelAsync(java.util.Map<String, String> context)
    {
        return _iceI_getVolumeLevelAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> _iceI_getVolumeLevelAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Short> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getVolumeLevel", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     short ret;
                     ret = istr.readShort();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorWithRadioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorWithRadioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorWithRadioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorWithRadioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static RefrigeratorWithRadioPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static RefrigeratorWithRadioPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, RefrigeratorWithRadioPrx.class, _RefrigeratorWithRadioPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (RefrigeratorWithRadioPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_adapterId(String newAdapterId)
    {
        return (RefrigeratorWithRadioPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (RefrigeratorWithRadioPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (RefrigeratorWithRadioPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_invocationTimeout(int newTimeout)
    {
        return (RefrigeratorWithRadioPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_connectionCached(boolean newCache)
    {
        return (RefrigeratorWithRadioPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (RefrigeratorWithRadioPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_secure(boolean b)
    {
        return (RefrigeratorWithRadioPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (RefrigeratorWithRadioPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_preferSecure(boolean b)
    {
        return (RefrigeratorWithRadioPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (RefrigeratorWithRadioPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (RefrigeratorWithRadioPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_collocationOptimized(boolean b)
    {
        return (RefrigeratorWithRadioPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_twoway()
    {
        return (RefrigeratorWithRadioPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_oneway()
    {
        return (RefrigeratorWithRadioPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_batchOneway()
    {
        return (RefrigeratorWithRadioPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_datagram()
    {
        return (RefrigeratorWithRadioPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_batchDatagram()
    {
        return (RefrigeratorWithRadioPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_compress(boolean co)
    {
        return (RefrigeratorWithRadioPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_timeout(int t)
    {
        return (RefrigeratorWithRadioPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_connectionId(String connectionId)
    {
        return (RefrigeratorWithRadioPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default RefrigeratorWithRadioPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (RefrigeratorWithRadioPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::Home::Kitchen::RefrigeratorWithRadio";
    }
}