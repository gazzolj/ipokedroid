package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.R;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class TeamViewerActivity extends AppCompatActivity {
    Team team;
    Typeface font;
    ImageView trainerPic;
    TextView trainerName;
    ImageView pokemonOnePic;
    TextView pokemonOneName;
    TextView pokemonOneLvl;
    ImageView pokemonTwoPic;
    TextView pokemonTwoName;
    TextView pokemonTwoLvl;
    ImageView pokemonThreePic;
    TextView pokemonThreeName;
    TextView pokemonThreeLvl;
    ImageView pokemonFourPic;
    TextView pokemonFourName;
    TextView pokemonFourLvl;
    ImageView pokemonFivePic;
    TextView pokemonFiveName;
    TextView pokemonFiveLvl;
    ImageView pokemonSixPic;
    TextView pokemonSixName;
    TextView pokemonSixLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_details);

        team = (Team) getIntent().getSerializableExtra("team");

        fetchGraphicalElement();
        setGraphicalElement();
        changeFonts();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(team.getName());
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000A0")));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchGraphicalElement(){
        trainerPic = (ImageView) findViewById(R.id.detail_trainer_picture);
        trainerName = (TextView) findViewById(R.id.detail_trainer_name);

        pokemonOnePic = (ImageView) findViewById(R.id.detail_pokemon1_picture);
        pokemonOneName = (TextView) findViewById(R.id.detail_pokemon1_name);
        pokemonOneLvl = (TextView) findViewById(R.id.detail_pokemon1_lvl);

        pokemonTwoPic = (ImageView) findViewById(R.id.detail_pokemon2_picture);
        pokemonTwoName = (TextView) findViewById(R.id.detail_pokemon2_name);
        pokemonTwoLvl = (TextView) findViewById(R.id.detail_pokemon2_lvl);

        pokemonThreePic = (ImageView) findViewById(R.id.detail_pokemon3_picture);
        pokemonThreeName = (TextView) findViewById(R.id.detail_pokemon3_name);
        pokemonThreeLvl = (TextView) findViewById(R.id.detail_pokemon3_lvl);

        pokemonFourPic = (ImageView) findViewById(R.id.detail_pokemon4_picture);
        pokemonFourName = (TextView) findViewById(R.id.detail_pokemon4_name);
        pokemonFourLvl = (TextView) findViewById(R.id.detail_pokemon4_lvl);

        pokemonFivePic = (ImageView) findViewById(R.id.detail_pokemon5_picture);
        pokemonFiveName = (TextView) findViewById(R.id.detail_pokemon5_name);
        pokemonFiveLvl = (TextView) findViewById(R.id.detail_pokemon5_lvl);

        pokemonSixPic = (ImageView) findViewById(R.id.detail_pokemon6_picture);
        pokemonSixName = (TextView) findViewById(R.id.detail_pokemon6_name);
        pokemonSixLvl = (TextView) findViewById(R.id.detail_pokemon6_lvl);
    }

    private void setGraphicalElement(){
        String concat;
        int pokemonNb = 0;

        trainerPic.setImageResource(getResources().getIdentifier(team.getTrainer().getPicture(), "drawable", getPackageName()));
        trainerName.setText(team.getTrainer().getName());

        pokemonOnePic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonOneName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonOneLvl.setText(concat);
        pokemonNb++;

        pokemonTwoPic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonTwoName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonTwoLvl.setText(concat);
        pokemonNb++;

        pokemonThreePic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonThreeName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonThreeLvl.setText(concat);
        pokemonNb++;

        pokemonFourPic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonFourName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonFourLvl.setText(concat);
        pokemonNb++;

        pokemonFivePic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonFiveName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonFiveLvl.setText(concat);
        pokemonNb++;

        pokemonSixPic.setImageResource(getResources().getIdentifier(team.getPokemons()[pokemonNb].getPicName(), "drawable", getPackageName()));
        pokemonSixName.setText(team.getPokemons()[pokemonNb].getName());
        concat = "Lvl." + team.getPokemons()[pokemonNb].getLvl();
        pokemonSixLvl.setText(concat);
    }

    private void changeFonts() {
        trainerName.setTypeface(font);

        pokemonOneName.setTypeface(font);
        pokemonOneLvl.setTypeface(font);

        pokemonTwoName.setTypeface(font);
        pokemonTwoLvl.setTypeface(font);

        pokemonThreeName.setTypeface(font);
        pokemonThreeLvl.setTypeface(font);

        pokemonFourName.setTypeface(font);
        pokemonFourLvl.setTypeface(font);

        pokemonFiveName.setTypeface(font);
        pokemonFiveLvl.setTypeface(font);

        pokemonSixName.setTypeface(font);
        pokemonSixLvl.setTypeface(font);
    }
}