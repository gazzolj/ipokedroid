package com.example.gazzol_j.ipokedroid.EvolutionPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Evolution;
import com.example.gazzol_j.ipokedroid.R;

import java.util.List;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class EvolutionListAdapter extends ArrayAdapter<Evolution> {
    private LayoutInflater inflater;
    private List<Evolution> evolutions;

    public EvolutionListAdapter(Context context, int layout, List<Evolution> evolution) {
        super(context, layout, evolution);
        this.evolutions = evolution;
        if (context != null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Evolution evolution = evolutions.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.evolution_row, parent, false);
        }
        TextView lvl = (TextView) convertView.findViewById(R.id.evolution_lvl);
        TextView name = (TextView) convertView.findViewById(R.id.evolution_name);
        ImageView image = (ImageView) convertView.findViewById(R.id.evolution_image);

        if (evolution.getLvl() == null && evolution.getCondition() == null){
            lvl.setText("lvl : 1");
        }
        else if (evolution.getLvl() == null && evolution.getCondition() != null){
            lvl.setText(evolution.getCondition());
        }
        else {
            lvl.setText("lvl : " + evolution.getLvl());
        }
        name.setText(evolution.getName());

        String imgName = "pokemon_" + evolution.getId();
        int resID = getContext().getResources().getIdentifier(imgName, "drawable", getContext().getPackageName());
        image.setImageResource(resID);
        return (convertView);
    }
}