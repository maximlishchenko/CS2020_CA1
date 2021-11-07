package uoa.assignment1.game;

import uoa.assignment1.character.Monster;

public class Game {
    

    
    Game (int height, int width) {
        Map map = new Map(height, width);
        map.printLayout();
    }
    			
    public Map getMap() {
        return null;
    }
    
    public boolean nextRound (String input) {
        return true;
    }
   
}