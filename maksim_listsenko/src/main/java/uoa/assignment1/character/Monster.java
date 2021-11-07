package uoa.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense() == false) {
            int originalHealth = character.getHealth();
            character.setHealth(originalHealth - 20);
        }
	}

	
	public boolean successfulDefense() {
        Random random = new Random();
        int roll = random.nextInt(2);
        if (roll == 1) {
            return true;
        } else {
            return false;
        }
	}


	
	public String decideMove () {
		
		return "move";
	}

}
