package PokemonDAO;

import DbConnection.DbConnection;
import Models.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonDAO {

    public void convertDbDataToModel() throws SQLException {
        DbConnection db = new DbConnection();
        Connection connection = db.getConnection();

        String query = " SELECT Pokemons.PokemonID, Pokemons.Species, Pokemons.Type, Pokemons.Level, CaughtPokemons.HuntNotes, Pokemons.HidingArea " +
                "FROM Pokemons JOIN CaughtPokemons ON Pokemons.PokemonID=CaughtPokemons.PokemonID";

        PreparedStatement preparedSelect = connection.prepareStatement(query);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next()){
            int id = rs.getInt("PokemonID");
            String species = rs.getString("Species");
            String type = rs.getString("Type");
            int level = rs.getInt("Level");
            String huntNotes = rs.getString("HuntNotes");
            String hiding_area = rs.getString("HidingArea");
            List<String> hidingAreaString = new ArrayList<>(Arrays.asList(hiding_area.split("\\D+")));
            List<Integer> hidingArea = convertStringListToIntegers(hidingAreaString);

            Pokemon pok = new Pokemon(id, species, type, level, huntNotes, hidingArea);
            Pokemon.addPokemonToList(pok);
        }
    }

    public List<Integer> convertStringListToIntegers(List<String> strList){
        List<Integer> hidingArea = new ArrayList<>();
        int i;
        for(String str : strList){
            if(str.matches("\\d+")){
                i = Integer.parseInt(str);
                hidingArea.add(i);
            }
        }
        return hidingArea;
    }
}