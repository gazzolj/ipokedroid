package com.example.gazzol_j.ipokedroid.StatsPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gazzol_j.ipokedroid.EvolutionPackage.EvolutionsFragment;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.SkillsPackage.SkillsFragment;


/**
 * Created by gazzol_j on 28/03/2016.
 */
public class StatsActivity extends AppCompatActivity {
    static Pokemon pokemon;
    StatsActivity statActivity;
    PagerAdapter adapterViewPager;

    static public Pokemon getPokemon(){
        return (pokemon);
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 3;
        private String[] titles = new String[]{
                "Stats", "Skills", "Evolution"
        };

        public PagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return StatsFragment.newInstance();
                case 1:
                    return SkillsFragment.newInstance();
                case 2:
                    return EvolutionsFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (titles[position]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        Intent intent = getIntent();
        pokemon = (Pokemon)intent.getSerializableExtra("pokemon");
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        statActivity = this;
    }
}