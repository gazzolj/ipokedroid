package com.example.gazzol_j.ipokedroid.PokedexPackage;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gazzol_j.ipokedroid.ParserPackage.ParserPokemon;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.TeamPackage.TeamFragment;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<Pokemon> pokedex;
    static MainActivity mainActivity;
    FragmentPagerAdapter adapterViewPager;

    static public MainActivity getActivity(){
        return (mainActivity);
    }

    static public List<Pokemon> getPokedex(){
        return (pokedex);
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 2;
        private String[] titles = new String[] {
                "Pokedex", "Team"
        };
        public PagerAdapter(android.support.v4.app.FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public int getCount(){
            return NUM_ITEMS;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position){
            switch (position){
                case 0:
                    return PokedexFragment.newInstance();
                case 1:
                    return TeamFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position){
            return (titles[position]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        ParserPokemon parser = new ParserPokemon();
        mainActivity = this;
        try {
            pokedex = parser.parse(getResources().openRawResource(R.raw.pokedata));
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }
}
