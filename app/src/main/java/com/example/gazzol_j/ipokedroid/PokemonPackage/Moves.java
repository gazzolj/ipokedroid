package com.example.gazzol_j.ipokedroid.PokemonPackage;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Move;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Moves implements Serializable
{
    private List<Move> move;

    public List<Move> getMove ()
    {
        return move;
    }

    public void setMove (List <Move> move)
    {
        this.move = move;
    }

    public Moves(){
        move = new ArrayList<>();
    }
}