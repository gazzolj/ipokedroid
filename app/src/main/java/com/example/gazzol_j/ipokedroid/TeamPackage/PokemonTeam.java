package com.example.gazzol_j.ipokedroid.TeamPackage;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;

import java.io.Serializable;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class PokemonTeam implements Serializable{
    private String name;
    private String picName;
    private int lvl;
    private int exp;

    public PokemonTeam() {
    }

    public PokemonTeam(Pokemon pokemon) {
        name = pokemon.getName();
        picName = "pokemon_" + pokemon.getId();
        lvl = 1;
        exp = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
