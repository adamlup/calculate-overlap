package Models;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private int id;
    private String species;
    private String type;
    private int level;
    private String huntNotes;
    private List<Integer> hidingArea;
    public static ArrayList<Pokemon> pokemonsList = new ArrayList<>();

    public Pokemon(int id, String species, String type, int level, String huntNotes, List<Integer> hidingArea) {
        this.id = id;
        this.species = species;
        this.type = type;
        this.level = level;
        this.huntNotes = huntNotes;
        this.hidingArea = hidingArea;
    }

    public List<Integer> getHidingArea() {
        return this.hidingArea;
    }

    public static void addPokemonToList(Pokemon pokemon){
        pokemonsList.add(pokemon);
    }

    public static ArrayList<Pokemon> getPokemonList(){
        return pokemonsList;
    }
}
