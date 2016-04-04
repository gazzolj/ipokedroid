package com.example.gazzol_j.ipokedroid.TeamPackage.sql;

import android.provider.BaseColumns;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public final class DbContracts {
    DbContracts() {}

    public static class TeamTable implements BaseColumns {
        public static final String TABLE_NAME = "teams";

        public static final String NAME = "name";
        public static final String TRAINER_ID = "trainerId";
        public static final String POKEMON_ONE = "pokemonOne";
        public static final String POKEMON_TWO = "pokemonTwo";
        public static final String POKEMON_THREE = "pokemonThree";
        public static final String POKEMON_FOUR = "pokemonFour";
        public static final String POKEMON_FIVE = "pokemonFive";
        public static final String POKEMON_SIX = "pokemonSIx";
    }

    public static class TrainerTable implements BaseColumns {
        public static final String TABLE_NAME = "trainers";

        public static final String NAME = "name";
        public static final String PICNAME = "picname";
    }

    public static class PokemonTable implements BaseColumns {
        public static String TABLE_NAME = "pokemons";

        public static final String NAME = "name";
        public static final String PICNAME = "picname";
        public static final String LVL = "lvl";
        public static final String EXP = "exp";
    }
}
