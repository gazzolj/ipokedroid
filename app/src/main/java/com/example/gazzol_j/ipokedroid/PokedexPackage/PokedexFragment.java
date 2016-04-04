package com.example.gazzol_j.ipokedroid.PokedexPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;

import java.util.List;

/**
 * Created by gazzol_j on 15/03/2016.
 */
public class PokedexFragment extends android.support.v4.app.Fragment{

    public static PokedexFragment newInstance(){
        PokedexFragment pokedexFragment = new PokedexFragment();
        return pokedexFragment;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Pokemon> pokedex = MainActivity.getPokedex();
        View view = inflater.inflate(R.layout.list_pokemon, container, false);
        ListView listPokemon = (ListView) view.findViewById(R.id.list_pokemon);
        PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), view.getId(), pokedex);
        listPokemon.setAdapter(adapter);
        return view;
    }
}
