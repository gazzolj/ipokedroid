package com.example.gazzol_j.ipokedroid.EvolutionPackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Evolution;
import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.StatsPackage.StatsActivity;

import java.util.List;

/**
 * Created by gazzol_j on 30/03/2016.
 */
public class EvolutionsFragment extends Fragment{
    public static EvolutionsFragment newInstance(){
        EvolutionsFragment evolutionsFragment = new EvolutionsFragment();
        return evolutionsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Evolution> evolution = StatsActivity.getPokemon().getEvolutions().getEvolution();
        View view = inflater.inflate(R.layout.evolution_fragment, container, false);
        ListView listEvolutions = (ListView) view.findViewById(R.id.list_evolution);
        EvolutionListAdapter adapter = new EvolutionListAdapter(getActivity(), view.getId(), evolution);
        listEvolutions.setAdapter(adapter);
        return view;
    }
}
