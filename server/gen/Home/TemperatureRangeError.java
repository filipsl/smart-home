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

package Home;

public class TemperatureRangeError extends ErrorBase
{
    public TemperatureRangeError()
    {
        super();
        this.unit = TempUnit.CELSIUS;
    }

    public TemperatureRangeError(Throwable cause)
    {
        super(cause);
        this.unit = TempUnit.CELSIUS;
    }

    public TemperatureRangeError(String reason, double minTemp, double maxTemp, TempUnit unit)
    {
        super(reason);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.unit = unit;
    }

    public TemperatureRangeError(String reason, double minTemp, double maxTemp, TempUnit unit, Throwable cause)
    {
        super(reason, cause);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.unit = unit;
    }

    public String ice_id()
    {
        return "::Home::TemperatureRangeError";
    }

    public double minTemp;

    public double maxTemp;

    public TempUnit unit;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::Home::TemperatureRangeError", -1, false);
        ostr_.writeDouble(minTemp);
        ostr_.writeDouble(maxTemp);
        TempUnit.ice_write(ostr_, unit);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        minTemp = istr_.readDouble();
        maxTemp = istr_.readDouble();
        unit = TempUnit.ice_read(istr_);
        istr_.endSlice();
        super._readImpl(istr_);
    }

    /** @hidden */
    public static final long serialVersionUID = -1654883444019523280L;
}
