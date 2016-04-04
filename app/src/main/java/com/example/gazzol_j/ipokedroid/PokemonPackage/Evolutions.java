package com.example.gazzol_j.ipokedroid.PokemonPackage;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Evolution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Evolutions implements Serializable
{
    private List<Evolution> evolution;

    public List<Evolution> getEvolution ()
    {
        return evolution;
    }

    public void setEvolution ( List <Evolution> evolution)
    {
        this.evolution = evolution;
    }

    public Evolutions(){
        evolution = new ArrayList<>();
    }
}