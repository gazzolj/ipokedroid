package com.example.gazzol_j.ipokedroid.PokemonPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 14/03/2016.
 */
public class Pokemon implements Serializable
{
    private String weight;

    private String species;

    private Stats stats;

    private Moves moves;

    private List<String> type;

    private List<String> eggGroup;

    private Evolutions evolutions;

    private String id;

    private String exp;

    private String height;

    private Ratio ratio;

    private String description;

    private String name;

    private String ability;

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    public String getSpecies ()
    {
        return species;
    }

    public void setSpecies (String species)
    {
        this.species = species;
    }

    public Stats getStats ()
    {
        return stats;
    }

    public void setStats (Stats stats)
    {
        this.stats = stats;
    }

    public Moves getMoves ()
    {
        return moves;
    }

    public void setMoves (Moves moves)
    {
        this.moves = moves;
    }

    public List <String> getType ()
    {
        return type;
    }

    public void setType (List <String> type)
    {
        this.type = type;
    }

    public List <String> getEggGroup ()
{
    return eggGroup;
}

    public void setEggGroup (List <String> eggGroup)
{
    this.eggGroup = eggGroup;
}

    public Evolutions getEvolutions ()
    {
        return evolutions;
    }

    public void setEvolutions (Evolutions evolutions)
    {
        this.evolutions = evolutions;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getExp ()
    {
        return exp;
    }

    public void setExp (String exp)
    {
        this.exp = exp;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public Ratio getRatio ()
    {
        return ratio;
    }

    public void setRatio (Ratio ratio)
    {
        this.ratio = ratio;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAbility ()
    {
        return ability;
    }

    public void setAbility (String ability)
    {
        this.ability = ability;
    }

    public Pokemon(){
        type = new ArrayList<>();
        eggGroup = new ArrayList<>();
    }
}
