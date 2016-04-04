package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.TeamPackage.sql.TeamDb;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class TeamBuilderActivity extends AppCompatActivity{
    private FragmentManager fragmentManager;
    private Team pokeTeam;
    TeamDb teamDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_builder_activity);
        pokeTeam = new Team();
        teamDb = new TeamDb(this);
        fragmentManager = getSupportFragmentManager();
        changeFragment(0);
    }

    public void changeFragment(int position) {
        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.fragment_emplacement, TrainerChooseFragment.newInstance()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.fragment_emplacement, PokemonChooseFragment.newInstance()).commit();
                break;
        }
    }

    public Team getPokeTeam() {
        return pokeTeam;
    }

    public void saveTeamToDb() {
        teamDb.insertTeam(pokeTeam);
        finish();
    }
}