package uoa.assignment1.game;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Monster;
import uoa.assignment1.character.Player;

public class Map {

    public String [][] layout;
    public GameCharacter characters [] = new GameCharacter[4];
 
    Map (int height, int width) {
        this.layout = new String[height][width];
        initialiseArray();
        Player player = new Player("Player");
        player.row = height - 1;
        player.column = width - 1;
        characters[0] = player;
        Monster monster1 = new Monster("Monster1");
        monster1.row = 0;
        monster1.column = width - 1;
        characters[1] = monster1;
        Monster monster2 = new Monster("Monster2");
        monster2.row = height - 1;
        monster2.column = 0;
        characters[2] = monster2;
        Monster monster3 = new Monster("Monster3");
        monster3.row = 0;
        monster3.column = 0;
        characters[3] = monster3;
    }

    private void initialiseArray() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if ((i == 0 && j == 0) || (i == 0 & j == (layout[i].length - 1)) || (i == (layout.length - 1) && j == 0)) {
                    layout[i][j] = "%";
                } else if (i == (layout.length -1) && j == (layout[i].length - 1)) {
                    layout[i][j] = "*";
                } else {
                    layout[i][j] = ".";
                }
            }
        }
    }

    public void printLayout() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println();
        }
    }
}
