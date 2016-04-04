package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.PokedexPackage.MainActivity;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class PokemonChooseFragment extends Fragment {
    private static final String nbMaxString = "/6";
    List<Integer> selectedPokemon = new ArrayList<>(6);
    List<Pokemon> pokemons;

    public static PokemonChooseFragment newInstance() {
        return new PokemonChooseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemons = MainActivity.getActivity().getPokedex();
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState){
            View view = inflater.inflate(R.layout.pokemon_team_choose, container, false);

            final EditText name = (EditText) view.findViewById(R.id.team_choose_name);
            final TextView selectedNbText = (TextView) view.findViewById(R.id.selected_pokemons_nb);
            final GridView images = (GridView) view.findViewById(R.id.pokemon_choose_image);
            final FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.validate_button);

            button.hide();
            ImageAdapter adapter = new ImageAdapter(getContext(), R.layout.pokemon_team_choose, pokemons);
            images.setAdapter(adapter);

            images.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    boolean selected = false;

                    for (Integer i : selectedPokemon) {
                        if (i == position) {
                            selected = true;
                            break;
                        }
                    }

                    if (!selected && selectedPokemon.size() != 6) {
                        selectedPokemon.add(position);
                        view.setBackgroundColor(getContext().getColor(R.color.bluePokedex));
                    } else {
                        selectedPokemon.remove((Integer) position);
                        view.setBackgroundColor(getContext().getColor(R.color.transparent));
                    }
                    String holder = selectedPokemon.size() + nbMaxString;
                    selectedNbText.setText(holder);
                    if (selectedPokemon.size() == 6) {
                        button.show();
                    } else {
                        button.hide();
                    }
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PokemonTeam[] poke = new PokemonTeam[6];
                    for (int i = 0; i != 6; ++i) {
                        poke[i] = new PokemonTeam(pokemons.get(selectedPokemon.get(i)));
                    }
                    ((TeamBuilderActivity) getActivity()).getPokeTeam().setPokemons(poke);
                    if (!name.getText().toString().isEmpty())
                        ((TeamBuilderActivity) getActivity()).getPokeTeam().setName(name.getText().toString());
                    ((TeamBuilderActivity) getActivity()).saveTeamToDb();
                }
            });

            return view;
        }

        private class ImageAdapter extends ArrayAdapter<Pokemon> {
            LayoutInflater inflater;
            List<Pokemon> pokemons;

            public ImageAdapter(Context context, int resource, List<Pokemon> objects) {
                super(context, resource, objects);
                pokemons = objects;
                if (context != null)
                    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Pokemon pokemon = pokemons.get(position);

                if (convertView == null)
                    convertView = inflater.inflate(R.layout.evolution_gridview_adapter, parent, false);

                ImageView image = (ImageView) convertView.findViewById(R.id.evolution_gridview_image);
                TextView name = (TextView) convertView.findViewById(R.id.evolution_gridview_text);
                String pokepic = "pokemon_" + pokemon.getId();
                int resID = getContext().getResources().getIdentifier(pokepic, "drawable", getContext().getPackageName());
                image.setImageResource(resID);
                convertView.setBackgroundColor(getContext().getColor(R.color.transparent));
                for (Integer i : selectedPokemon) {
                    if (i == position) {
                        convertView.setBackgroundColor(getContext().getColor(R.color.bluePokedex));
                        break;
                    }
                }
                name.setText(pokemon.getName());

                return convertView;
            }
        }
}