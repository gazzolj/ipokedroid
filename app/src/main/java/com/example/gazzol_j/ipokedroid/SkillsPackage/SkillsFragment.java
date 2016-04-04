package com.example.gazzol_j.ipokedroid.SkillsPackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Move;
import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.StatsPackage.StatsActivity;

import java.util.List;

/**
 * Created by gazzol_j on 30/03/2016.
 */
public class SkillsFragment extends Fragment {

    public static SkillsFragment newInstance() {
        SkillsFragment skillsFragment = new SkillsFragment();
        return skillsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Move> move = StatsActivity.getPokemon().getMoves().getMove();
        View view = inflater.inflate(R.layout.skills_fragment, container, false);
        ListView listSkills = (ListView) view.findViewById(R.id.list_skills);
        SkillsListAdapter adapter = new SkillsListAdapter(getActivity(), view.getId(), move);
        listSkills.setAdapter(adapter);
        return view;
    }
}