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

public class FrequencyRangeError extends Home.ErrorBase
{
    public FrequencyRangeError()
    {
        super();
    }

    public FrequencyRangeError(Throwable cause)
    {
        super(cause);
    }

    public FrequencyRangeError(String reason, double minFreq, double maxFreq)
    {
        super(reason);
        this.minFreq = minFreq;
        this.maxFreq = maxFreq;
    }

    public FrequencyRangeError(String reason, double minFreq, double maxFreq, Throwable cause)
    {
        super(reason, cause);
        this.minFreq = minFreq;
        this.maxFreq = maxFreq;
    }

    public String ice_id()
    {
        return "::Home::Kitchen::FrequencyRangeError";
    }

    public double minFreq;

    public double maxFreq;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::Home::Kitchen::FrequencyRangeError", -1, false);
        ostr_.writeDouble(minFreq);
        ostr_.writeDouble(maxFreq);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        minFreq = istr_.readDouble();
        maxFreq = istr_.readDouble();
        istr_.endSlice();
        super._readImpl(istr_);
    }

    /** @hidden */
    public static final long serialVersionUID = -8285144239466439345L;
}
