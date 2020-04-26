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

public class BakingParams implements java.lang.Cloneable,
                                     java.io.Serializable
{
    public BakingSide side;

    public Home.Temperature temperature;

    public int durationMins;

    public BakingParams()
    {
        this.side = BakingSide.UP;
        this.temperature = new Home.Temperature();
    }

    public BakingParams(BakingSide side, Home.Temperature temperature, int durationMins)
    {
        this.side = side;
        this.temperature = temperature;
        this.durationMins = durationMins;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        BakingParams r = null;
        if(rhs instanceof BakingParams)
        {
            r = (BakingParams)rhs;
        }

        if(r != null)
        {
            if(this.side != r.side)
            {
                if(this.side == null || r.side == null || !this.side.equals(r.side))
                {
                    return false;
                }
            }
            if(this.temperature != r.temperature)
            {
                if(this.temperature == null || r.temperature == null || !this.temperature.equals(r.temperature))
                {
                    return false;
                }
            }
            if(this.durationMins != r.durationMins)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Home::Kitchen::BakingParams");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, side);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temperature);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, durationMins);
        return h_;
    }

    public BakingParams clone()
    {
        BakingParams c = null;
        try
        {
            c = (BakingParams)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        BakingSide.ice_write(ostr, this.side);
        Home.Temperature.ice_write(ostr, this.temperature);
        ostr.writeInt(this.durationMins);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.side = BakingSide.ice_read(istr);
        this.temperature = Home.Temperature.ice_read(istr);
        this.durationMins = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, BakingParams v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public BakingParams ice_read(com.zeroc.Ice.InputStream istr)
    {
        BakingParams v = new BakingParams();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<BakingParams> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, BakingParams v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<BakingParams> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(BakingParams.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final BakingParams _nullMarshalValue = new BakingParams();

    /** @hidden */
    public static final long serialVersionUID = 214581522041937009L;
}