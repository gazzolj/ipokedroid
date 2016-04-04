package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.R;

import java.util.List;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class TeamListAdapter extends ArrayAdapter<Team> {
        private LayoutInflater inflater;
        private List<Team> teams;

        public TeamListAdapter(Context context, int resource, List<Team> objects) {
            super(context, resource, objects);
            if (context != null)
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            teams = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Team team = teams.get(position);
            if (convertView == null)
                convertView = inflater.inflate(R.layout.team_row, parent, false);

            ImageView trainerPic = (ImageView) convertView.findViewById(R.id.trainer_picture);
            TextView teamName = (TextView) convertView.findViewById(R.id.team_name);
            ImageView pokemonOne = (ImageView) convertView.findViewById(R.id.team_pokemon1);
            ImageView pokemonTwo = (ImageView) convertView.findViewById(R.id.team_pokemon2);
            ImageView pokemonThree = (ImageView) convertView.findViewById(R.id.team_pokemon3);
            ImageView pokemonFour = (ImageView) convertView.findViewById(R.id.team_pokemon4);
            ImageView pokemonFive = (ImageView) convertView.findViewById(R.id.team_pokemon5);
            ImageView pokemonSix = (ImageView) convertView.findViewById(R.id.team_pokemon6);

            teamName.setText(team.getName());
            int resID = getContext().getResources().getIdentifier(team.getTrainer().getPicture(), "drawable", getContext().getPackageName());
            trainerPic.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[0].getPicName(), "drawable", getContext().getPackageName());
            pokemonOne.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[1].getPicName(), "drawable", getContext().getPackageName());
            pokemonTwo.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[2].getPicName(), "drawable", getContext().getPackageName());
            pokemonThree.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[3].getPicName(), "drawable", getContext().getPackageName());
            pokemonFour.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[4].getPicName(), "drawable", getContext().getPackageName());
            pokemonFive.setImageResource(resID);
            resID = getContext().getResources().getIdentifier(team.getPokemons()[5].getPicName(), "drawable", getContext().getPackageName());
            pokemonSix.setImageResource(resID);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getContext(), TeamViewerActivity.class);
                    i.putExtra("team", team);
                    getContext().startActivity(i);
                }
            });

            return convertView;
        }
}
