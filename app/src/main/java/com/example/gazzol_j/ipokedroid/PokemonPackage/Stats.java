package com.example.gazzol_j.ipokedroid.PokemonPackage;

import java.io.Serializable;

public class Stats implements Serializable
{
    private String SDF;

    private String DEF;

    private String SAT;

    private String SPD;

    private String HP;

    private String ATK;

    public String getSDF ()
    {
        return SDF;
    }

    public void setSDF (String SDF)
    {
        this.SDF = SDF;
    }

    public String getDEF ()
    {
        return DEF;
    }

    public void setDEF (String DEF)
    {
        this.DEF = DEF;
    }

    public String getSAT ()
    {
        return SAT;
    }

    public void setSAT (String SAT)
    {
        this.SAT = SAT;
    }

    public String getSPD ()
    {
        return SPD;
    }

    public void setSPD (String SPD)
    {
        this.SPD = SPD;
    }

    public String getHP ()
    {
        return HP;
    }

    public void setHP (String HP)
    {
        this.HP = HP;
    }

    public String getATK ()
    {
        return ATK;
    }

    public void setATK (String ATK)
    {
        this.ATK = ATK;
    }
}