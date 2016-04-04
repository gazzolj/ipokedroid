package com.example.gazzol_j.ipokedroid.PokedexPackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.StatsPackage.StatsActivity;

import java.util.List;

/**
 * Created by gazzol_j on 15/03/2016.
 */

public class PokemonListAdapter extends ArrayAdapter<Pokemon> {
    private LayoutInflater inflater;
    private List<Pokemon> pokemons;

    public PokemonListAdapter(Context context, int layout, List<Pokemon> pokemons){
        super(context, layout, pokemons);
        this.pokemons = pokemons;
        if (context != null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Pokemon pokemon = pokemons.get(position);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.pokemon_row, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.pokemon_name);
        TextView id = (TextView) convertView.findViewById(R.id.pokemon_id);
        ImageView image = (ImageView) convertView.findViewById(R.id.pokemon_image);

        name.setText(pokemon.getName());
        id.setText(pokemon.getId());
        String imgName = "pokemon_" + pokemon.getId();
        int resID = getContext().getResources().getIdentifier(imgName, "drawable", getContext().getPackageName());
        image.setImageResource(resID);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), StatsActivity.class);
                intent.putExtra("pokemon", pokemon);
                getContext().startActivity(intent);

            }
        });
        return (convertView);
    }
}
