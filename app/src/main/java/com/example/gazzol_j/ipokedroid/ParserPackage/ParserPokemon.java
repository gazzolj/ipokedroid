package com.example.gazzol_j.ipokedroid.ParserPackage;

import android.util.Xml;

import com.example.gazzol_j.ipokedroid.PokemonPackage.Pokemon;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Evolution;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Evolutions;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Move;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Moves;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Ratio;
import com.example.gazzol_j.ipokedroid.PokemonPackage.Stats;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gazzol_j on 14/03/2016.
 */

public class ParserPokemon {
    private Pokemon readPokemon(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "pokemon");
        Pokemon pokemon = new Pokemon();
        pokemon.setId(parser.getAttributeValue(ns, "id"));
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            switch (name) {
                case "name":
                    pokemon.setName(readProperty(parser, "name"));

                    break;
                case "weight":
                    pokemon.setWeight(readProperty(parser, "weight"));

                    break;
                case "species":
                    pokemon.setSpecies(readProperty(parser, "species"));

                    break;
                case "exp":
                    pokemon.setExp(readProperty(parser, "exp"));

                    break;
                case "height":
                    pokemon.setHeight(readProperty(parser, "height"));

                    break;
                case "description":
                    pokemon.setDescription(readProperty(parser, "description"));

                    break;
                case "ability":
                    pokemon.setAbility(readProperty(parser, "ability"));

                    break;
                case "type":
                    pokemon.getType().add(readProperty(parser, "type"));

                    break;
                case "egg-group":
                    pokemon.getEggGroup().add(readProperty(parser, "egg-group"));

                    break;
                case "stats":
                    pokemon.setStats(readStats(parser));

                    break;
                case "ratio":
                    pokemon.setRatio(readRatio(parser));

                    break;
                case "moves":
                    pokemon.setMoves(readMoves(parser));

                    break;
                case "evolutions":
                    pokemon.setEvolutions(readEvolutions(parser));

                    break;
                default:
                    skip(parser);

                    break;
            }
        }
        return pokemon;
    }

    private Evolution readEvolution(XmlPullParser parser) throws XmlPullParserException, IOException {
        Evolution evolution = new Evolution();

        parser.require(XmlPullParser.START_TAG, ns, "evolution");
        evolution.setId(parser.getAttributeValue(ns, "id"));
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            switch (name) {
                case "name":
                    evolution.setName(readProperty(parser, "name"));
                    break;

                case "lvl":
                    evolution.setLvl(readProperty(parser, "lvl"));
                    break;
                case "condition":
                    evolution.setCondition(readProperty(parser, "condition"));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return evolution;
    }

    private Evolutions readEvolutions(XmlPullParser parser) throws XmlPullParserException, IOException {
        Evolutions evolutions = new Evolutions();

        parser.require(XmlPullParser.START_TAG, ns, "evolutions");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("evolution")) {
                evolutions.getEvolution().add(readEvolution(parser));
            }
            else
                skip(parser);
        }
        return evolutions;
    }


    private Move readMove(XmlPullParser parser) throws XmlPullParserException, IOException {
         Move move = new Move();

        parser.require(XmlPullParser.START_TAG, ns, "move");
        move.setType(parser.getAttributeValue(ns, "type"));
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            switch (name) {
                case "name":
                    move.setName(readProperty(parser, "name"));
                    break;

                case "machine":
                    move.setMachine(readProperty(parser, "machine"));
                    break;

                case "lvl":
                    move.setLvl(readProperty(parser, "lvl"));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return move;
    }

    private Moves readMoves(XmlPullParser parser) throws XmlPullParserException, IOException {
        Moves moves = new Moves();

        parser.require(XmlPullParser.START_TAG, ns, "moves");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("move")) {
                moves.getMove().add(readMove(parser));
            }
            else
                skip(parser);
        }
        return moves;
    }

    private Ratio readRatio(XmlPullParser parser) throws XmlPullParserException, IOException {
        Ratio ratio = new Ratio();

        parser.require(XmlPullParser.START_TAG, ns, "ratio");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            switch (name) {
                case "male":
                    ratio.setMale(readProperty(parser, "male"));
                    break;
                case "female":
                    ratio.setFemale(readProperty(parser, "female"));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return ratio;
    }

    private Stats readStats(XmlPullParser parser) throws XmlPullParserException, IOException {
        Stats stats = new Stats();

        parser.require(XmlPullParser.START_TAG, ns, "stats");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            switch (name) {
                case "SDF":
                    stats.setSDF(readProperty(parser, "SDF"));
                    break;
                case "DEF":
                    stats.setDEF(readProperty(parser, "DEF"));
                    break;
                case "SAT":
                    stats.setSAT(readProperty(parser, "SAT"));
                    break;
                case "SPD":
                    stats.setSPD(readProperty(parser, "SPD"));
                    break;
                case "HP":
                    stats.setHP(readProperty(parser, "HP"));
                    break;
                case "ATK":
                    stats.setATK(readProperty(parser, "ATK"));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return stats;
    }

    private List<Pokemon> readPokedex(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<Pokemon> pokemons = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "pokedex");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("pokemon")) {
                pokemons.add(readPokemon(parser));
            } else {
                skip(parser);
            }
        }
        return pokemons;
    }

    private static final String ns = null;

    public List<Pokemon> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readPokedex(parser);
        } finally {
            in.close();
        }
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    private String readProperty(XmlPullParser parser, String property) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, property);
        String prop = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, property);
        return prop;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String text = "";
        if (parser.next() == XmlPullParser.TEXT) {
            text = parser.getText();
            parser.nextTag();
        }
        return text;
    }
}
