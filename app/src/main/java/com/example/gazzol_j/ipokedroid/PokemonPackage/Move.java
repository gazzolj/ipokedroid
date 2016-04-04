package com.example.gazzol_j.ipokedroid.PokemonPackage;

import java.io.Serializable;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Move implements Serializable
{
    private String lvl;

    private String name;

    private String type;

    private String machine;

    public String getLvl ()
    {
        return lvl;
    }

    public void setLvl (String lvl)
    {
        this.lvl = lvl;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getMachine ()
    {
        return machine;
    }

    public void setMachine (String machine)
    {
        this.machine = machine;
    }
}
