package uoa.assignment1.game;

import uoa.assignment1.character.Monster;

public class Game {

    public Map map;

    Game (int height, int width) {
        Map map = new Map(height, width);
        this.map = map;
        map.printLayout();
    }

    public Map getMap() {
        return map;
    }

    public boolean nextRound(String input) {
        GameLogic.moveCharacter(input, map, map.characters[0]);

        for (int i = 1; i < map.characters.length; i++) {
            Monster monster = (Monster)map.characters[i];
            String decision = monster.decideMove();
            GameLogic.moveCharacter(decision, map, map.characters[i]);
        }

        System.out.println();

        for (int i = 0; i < map.characters.length; i++) {
                System.out.printf("Health %s:  %d%n", map.characters[i].sayName(), map.characters[i].getHealth());
            }

        System.out.println();

        int deadMonsterCount = 0;
        for (int i = 1; i < map.characters.length; i++) {
            if (map.characters[i].getHealth() <= 0) {
                deadMonsterCount += 1;
            }
        }
        if (deadMonsterCount >= (map.characters.length - 1)) {
            System.out.println("YOU HAVE WON!");
            return true;
        } else if (map.characters[0].getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            return true;
        } else {
            return false;
        }
    }
}
