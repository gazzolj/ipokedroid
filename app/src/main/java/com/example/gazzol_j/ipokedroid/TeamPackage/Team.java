package com.example.gazzol_j.ipokedroid.TeamPackage;


import java.io.Serializable;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class Team implements Serializable {
    String name = "Unamed team";
    Trainer trainer = new Trainer();
    PokemonTeam[] pokemons = new PokemonTeam[6];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public PokemonTeam[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(PokemonTeam[] pokemons) {
        this.pokemons = pokemons;
    }
}
