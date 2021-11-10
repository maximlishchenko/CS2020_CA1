package uoa.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
        if (!character.successfulDefense()) {
            int originalHealth = character.getHealth();
            character.setHealth(originalHealth - 50);
            System.out.printf("!!HIT!! %s successfully attacked %s%n", this.sayName(), character.sayName());
        } else {
            System.out.printf("!!MISS!! %s successfully defended attack from %s%n", character.sayName(), this.sayName());
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
