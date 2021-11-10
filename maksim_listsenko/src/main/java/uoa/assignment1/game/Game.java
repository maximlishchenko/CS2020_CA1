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
        System.out.printf("%s is moving %s%n", map.characters[0].sayName(), input);
        GameLogic.moveCharacter(input, map, map.characters[0]);

        for (int i = 1; i < map.characters.length; i++) {
            if (map.characters[i].getHealth() > 0) {
                Monster monster = (Monster)map.characters[i];
                String decision = monster.decideMove();
                System.out.printf("%s is moving %s%n", map.characters[i].sayName(), decision);
                GameLogic.moveCharacter(decision, map, map.characters[i]);
            }
        }

        if (map.characters[0].getHealth() > 0) {
            int deadMonsterCount = 0;
            for (int i = 1; i < map.characters.length; i++) {
                if (map.characters[i].getHealth() <= 0) {
                    deadMonsterCount += 1;
                }
            }

            if (deadMonsterCount >= (map.characters.length - 1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
   
}