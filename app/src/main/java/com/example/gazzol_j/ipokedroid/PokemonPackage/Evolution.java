package com.example.gazzol_j.ipokedroid.PokemonPackage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Evolution implements Serializable
{
    private String id;

    private String name;

    private String lvl;
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
}