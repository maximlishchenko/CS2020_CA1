package uoa.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
        if (character.successfulDefense() == false) {
            int originalHealth = character.getHealth();
            character.setHealth(originalHealth - 50);
        }
    }

	
	public
	boolean successfulDefense() {
        Random random = new Random();
        int roll = random.nextInt(10);
        if (roll < 3) {
            return true;
        } else {
            return false;
        }
	}

}
