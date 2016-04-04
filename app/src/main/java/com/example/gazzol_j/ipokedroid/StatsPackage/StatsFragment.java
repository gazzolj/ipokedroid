package com.example.gazzol_j.ipokedroid.StatsPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;

/**
 * Created by gazzol_j on 30/03/2016.
 */
public class StatsFragment extends android.support.v4.app.Fragment {
    Pokemon pokemon;

    public static StatsFragment newInstance(){
        StatsFragment statFragment = new StatsFragment();
        return statFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemon = StatsActivity.getPokemon();

        View view = inflater.inflate(R.layout.stats_fragment, container, false);

        TextView name = (TextView) view.findViewById(R.id.pokemon_name);
        TextView description = (TextView) view.findViewById(R.id.pokemon_description);
        ImageView image = (ImageView) view.findViewById(R.id.pokemon_image);
        LinearLayout types = (LinearLayout) view.findViewById(R.id.pokemon_type);
        TextView atk = (TextView) view.findViewById(R.id.pokemon_atk);
        TextView def = (TextView) view.findViewById(R.id.pokemon_def);
        TextView hp = (TextView) view.findViewById(R.id.pokemon_hp);
        TextView sat = (TextView) view.findViewById(R.id.pokemon_sat);
        TextView sdf = (TextView) view.findViewById(R.id.pokemon_sdf);
        TextView spd = (TextView) view.findViewById(R.id.pokemon_spd);

        for (int i = 0; i != pokemon.getType().size(); i++) {
            String imgName = "type_" + pokemon.getType().get(i).toLowerCase();
            int resID = getResources().getIdentifier(imgName, "drawable", getActivity().getPackageName());
            ImageView img = new ImageView(getContext());
            img.setImageResource(resID);
            img.setPadding(10,10,10,10);
            types.addView(img);
        }

        name.setText(pokemon.getName());
        atk.setText("ATK : " + pokemon.getStats().getATK());
        def.setText("DEF : " + pokemon.getStats().getDEF());
        hp.setText("HP : " + pokemon.getStats().getHP());
        sat.setText("SAT : " + pokemon.getStats().getSAT());
        sdf.setText("SDF : " + pokemon.getStats().getSDF());
        spd.setText("SPD : " + pokemon.getStats().getSPD());

        description.setText(pokemon.getDescription());
        String imgName = "pokemon_" + pokemon.getId();
        int resID = getResources().getIdentifier(imgName, "drawable", getActivity().getPackageName());
        image.setImageResource(resID);
        return view;
    }
}