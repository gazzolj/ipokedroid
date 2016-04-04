package com.example.gazzol_j.ipokedroid.TeamPackage.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gazzol_j.ipokedroid.TeamPackage.PokemonTeam;
import com.example.gazzol_j.ipokedroid.TeamPackage.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class TeamDb extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Pokedex.db";
    String CREATE_TEAM_TABLE = "CREATE TABLE " + DbContracts.TeamTable.TABLE_NAME + " (" +
            DbContracts.TeamTable._ID + " INTEGER PRIMARY KEY," +
            DbContracts.TeamTable.NAME + " TEXT," +
            DbContracts.TeamTable.TRAINER_ID + " INTEGER," +
            DbContracts.TeamTable.POKEMON_ONE + " INTEGER," +
            DbContracts.TeamTable.POKEMON_TWO + " INTEGER," +
            DbContracts.TeamTable.POKEMON_THREE + " INTEGER," +
            DbContracts.TeamTable.POKEMON_FOUR + " INTEGER," +
            DbContracts.TeamTable.POKEMON_FIVE + " INTEGER," +
            DbContracts.TeamTable.POKEMON_SIX + " INTEGER" + " )";

    String CREATE_TRAINER_TABLE = "CREATE TABLE " + DbContracts.TrainerTable.TABLE_NAME + " (" +
            DbContracts.TrainerTable._ID + " INTEGER PRIMARY KEY," +
            DbContracts.TrainerTable.NAME + " TEXT," +
            DbContracts.TrainerTable.PICNAME + " TEXT" + " )";

    String CREATE_POKEMON_TABLE = "CREATE TABLE " + DbContracts.PokemonTable.TABLE_NAME + " (" +
            DbContracts.PokemonTable._ID + " INTEGER PRIMARY KEY," +
            DbContracts.PokemonTable.NAME + " TEXT," +
            DbContracts.PokemonTable.PICNAME + " TEXT," +
            DbContracts.PokemonTable.LVL + " INTEGER," +
            DbContracts.PokemonTable.EXP + " INTEGER" + " )";
    String[] pokemonsId = new String[]{
            DbContracts.TeamTable.POKEMON_ONE,
            DbContracts.TeamTable.POKEMON_TWO,
            DbContracts.TeamTable.POKEMON_THREE,
            DbContracts.TeamTable.POKEMON_FOUR,
            DbContracts.TeamTable.POKEMON_FIVE,
            DbContracts.TeamTable.POKEMON_SIX
    };


    public TeamDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TEAM_TABLE);
        db.execSQL(CREATE_TRAINER_TABLE);
        db.execSQL(CREATE_POKEMON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.TeamTable.TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.TrainerTable.TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.PokemonTable.TABLE_NAME + ";");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void clearTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.TeamTable.TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.TrainerTable.TABLE_NAME + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DbContracts.PokemonTable.TABLE_NAME + ";");
        db.execSQL(CREATE_TEAM_TABLE);
        db.execSQL(CREATE_TRAINER_TABLE);
        db.execSQL(CREATE_POKEMON_TABLE);
        db.close();
    }

    public boolean insertTeam(Team team) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues teamValues = new ContentValues();
        ContentValues trainerValues = new ContentValues();
        ContentValues pokemonValues;

        teamValues.put(DbContracts.TeamTable.NAME, team.getName());

        trainerValues.put(DbContracts.TrainerTable.NAME, team.getTrainer().getName());
        trainerValues.put(DbContracts.TrainerTable.PICNAME, team.getTrainer().getPicture());
        long trainerId = db.insert(DbContracts.TrainerTable.TABLE_NAME, null, trainerValues);
        teamValues.put(DbContracts.TeamTable.TRAINER_ID, trainerId);

        for (int i = 0; i != 6; i++) {
            pokemonValues = new ContentValues();
            pokemonValues.put(DbContracts.PokemonTable.NAME, team.getPokemons()[i].getName());
            pokemonValues.put(DbContracts.PokemonTable.PICNAME, team.getPokemons()[i].getPicName());
            pokemonValues.put(DbContracts.PokemonTable.LVL, team.getPokemons()[i].getLvl());
            pokemonValues.put(DbContracts.PokemonTable.EXP, team.getPokemons()[i].getExp());
            long pokemonId = db.insert(DbContracts.PokemonTable.TABLE_NAME, null, pokemonValues);
            teamValues.put(pokemonsId[i], pokemonId);
        }

        db.insert(DbContracts.TeamTable.TABLE_NAME, null, teamValues);
        db.close();
        return true;
    }

    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor teamCursor = db.query(DbContracts.TeamTable.TABLE_NAME, new String[]{
                        DbContracts.TeamTable.NAME,
                        DbContracts.TeamTable.TRAINER_ID,
                        DbContracts.TeamTable.POKEMON_ONE,
                        DbContracts.TeamTable.POKEMON_TWO,
                        DbContracts.TeamTable.POKEMON_THREE,
                        DbContracts.TeamTable.POKEMON_FOUR,
                        DbContracts.TeamTable.POKEMON_FIVE,
                        DbContracts.TeamTable.POKEMON_SIX},
                null, null, null, null, null, null);
        Cursor trainerCursor;
        Cursor pokemonCursor;
        teamCursor.moveToFirst();
        while (!teamCursor.isAfterLast()) {
            Team pokeTeam = new Team();
            pokeTeam.setName(teamCursor.getString(teamCursor.getColumnIndex(DbContracts.TeamTable.NAME)));

            long trainerId = teamCursor.getLong(teamCursor.getColumnIndex(DbContracts.TeamTable.TRAINER_ID));
            trainerCursor = db.query(DbContracts.TrainerTable.TABLE_NAME, new String[]{
                            DbContracts.TrainerTable.NAME,
                            DbContracts.TrainerTable.PICNAME},
                    DbContracts.TrainerTable._ID + " = ?", new String[]{String.valueOf(trainerId)}, null, null, null, null);

            trainerCursor.moveToFirst();
            pokeTeam.getTrainer().setName(trainerCursor.getString(trainerCursor.getColumnIndex(DbContracts.TrainerTable.NAME)));
            pokeTeam.getTrainer().setPicture(trainerCursor.getString(trainerCursor.getColumnIndex(DbContracts.TrainerTable.PICNAME)));
            trainerCursor.close();

            for (int i = 0; i != 6; ++i) {
                long pokemonId = teamCursor.getLong(teamCursor.getColumnIndex(pokemonsId[i]));
                pokemonCursor = db.query(DbContracts.PokemonTable.TABLE_NAME, new String[]{
                                DbContracts.PokemonTable.NAME,
                                DbContracts.PokemonTable.PICNAME,
                                DbContracts.PokemonTable.LVL,
                                DbContracts.PokemonTable.EXP},
                        DbContracts.PokemonTable._ID + " = ?", new String[]{String.valueOf(pokemonId)}, null, null, null, null);
                pokemonCursor.moveToFirst();
                pokeTeam.getPokemons()[i] = new PokemonTeam();
                pokeTeam.getPokemons()[i].setName(pokemonCursor.getString(pokemonCursor.getColumnIndex(DbContracts.PokemonTable.NAME)));
                pokeTeam.getPokemons()[i].setPicName(pokemonCursor.getString(pokemonCursor.getColumnIndex(DbContracts.PokemonTable.PICNAME)));
                pokeTeam.getPokemons()[i].setExp(pokemonCursor.getInt(pokemonCursor.getColumnIndex(DbContracts.PokemonTable.EXP)));
                pokeTeam.getPokemons()[i].setLvl(pokemonCursor.getInt(pokemonCursor.getColumnIndex(DbContracts.PokemonTable.LVL)));
                pokemonCursor.close();
            }
            teams.add(pokeTeam);
            teamCursor.moveToNext();
        }
        teamCursor.close();
        db.close();

        return teams;
    }
}