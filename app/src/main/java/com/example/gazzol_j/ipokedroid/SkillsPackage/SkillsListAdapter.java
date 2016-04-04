package com.example.gazzol_j.ipokedroid.SkillsPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Move;
import com.example.gazzol_j.ipokedroid.R;

import java.util.List;

/**
 * Created by gazzol_j on 30/03/2016.
 */
public class SkillsListAdapter extends ArrayAdapter<Move> {
    private LayoutInflater inflater;
    private List<Move> moves;

    public SkillsListAdapter(Context context, int layout, List<Move> move) {
        super(context, layout, move);
        this.moves = move;
        if (context != null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Move move = moves.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.skills_row, parent, false);
        }
        TextView lvl = (TextView) convertView.findViewById(R.id.skills_lvl);
        TextView name = (TextView) convertView.findViewById(R.id.skills_name);

        if (move.getType().equals("level-up")) {
            lvl.setText("lvl : " + move.getLvl());
        }
        else {
            lvl.setText("TM/HM");
        }
        name.setText(move.getName());
        return (convertView);
    }
}