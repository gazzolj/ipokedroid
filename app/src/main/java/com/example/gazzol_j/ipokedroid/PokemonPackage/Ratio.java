package com.example.gazzol_j.ipokedroid.PokemonPackage;

import java.io.Serializable;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Ratio implements Serializable
{
    private String female;

    private String male;

    public String getFemale ()
    {
        return female;
    }

    public void setFemale (String female)
    {
        this.female = female;
    }

    public String getMale ()
    {
        return male;
    }

    public void setMale (String male)
    {
        this.male = male;
    }
}