package Application;

import Models.Pokemon;
import PokemonDAO.PokemonDAO;
import java.sql.SQLException;
import java.util.List;

public class Application {

    private Pokemon pokemon;
    private PokemonDAO pokemonDAO;

    public static void main(String[] args) {
        Application app = new Application();
        try{
            app.start();
        }catch (SQLException e){
            System.out.println("oho problem");
        }
    }

    private void start() throws SQLException{
        pokemonDAO = new PokemonDAO();
        pokemonDAO.convertDbDataToModel();
        List<Integer> firstPokArea = Pokemon.pokemonsList.get(0).getHidingArea();
        List<Integer> secondPokArea = Pokemon.pokemonsList.get(1).getHidingArea();
        calculateOverlapArea(firstPokArea, secondPokArea);
    }

    private int calculateOverlapArea(List<Integer> firstPokArea, List<Integer> secondPokArea){
        int x1 = 0;
        int x2 = 0;
        int y1;
        int y2;
        System.out.println(firstPokArea);
        System.out.println(secondPokArea);
        int x11 = firstPokArea.get(0);
        int y11 = firstPokArea.get(1);
        int x12 = firstPokArea.get(2);
        int y12 = firstPokArea.get(3);
        int x21 = secondPokArea.get(0);
        int x22 = secondPokArea.get(1);
        int y21 = secondPokArea.get(2);
        int y22 = secondPokArea.get(3);
        if(x21 >= x11 && x21 <= x12){
            x1 = x21;
        }else if(x11 >= x21 && x11 <= x22){
            x1 = x11;
        }
        if(x22 >= x11 && x22 <= x12){
            x2 = x22;
        }else if(x12 >= x21 && x12 <= x22){
            x2 = x12;
        }

        System.out.println("x1 --> " + x1 + "  " + "x2 --> " + x2);
        return 1;
    }
}
