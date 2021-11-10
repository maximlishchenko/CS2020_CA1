package uoa.assignment1.game;

import java.util.Scanner;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
        String[] options = {"up", "down", "left", "right"};
        boolean valid = false;
        for (String item : options) {
            if (input.equals(item)) {
                valid = true;
            }
        }

        if (valid) {
            if (input.equals("up") && character.getHealth() > 0) {
                moveUp(character, gameMap);
            } else if (input.equals("down") && character.getHealth() > 0) {
                moveDown(character, gameMap);
            } else if (input.equals("left") && character.getHealth() > 0) {
                moveLeft(character, gameMap);
            } else if (input.equals("right") && character.getHealth() > 0) {
                moveRight(character, gameMap);
            }
        } else {
            System.out.println("Use only keywords up, down, left, right");
        }
	}

    private static void moveRight(GameCharacter character, Map gameMap) {
        System.out.printf("%s is moving right%n", character.sayName());
        if (character.column >= (gameMap.layout[character.row].length - 1)) {
            System.out.println("You can't go right. You lose a move");
        } else if (!gameMap.layout[character.row][character.column + 1].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") &&
                ((gameMap.layout[character.row][character.column + 1].equals("%")) || (gameMap.layout[character.row][character.column + 1].equals("x")))) {
                System.out.println("Monster already there so can't move");
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row][character.column + 1].equals("%")) {
                int i = 1;
                while (i < gameMap.characters.length) {
                    if ((character.row == gameMap.characters[i].row) && ((character.column + 1) == gameMap.characters[i].column)) {
                        break;
                    }
                    i++;
                }
                character.hurtCharacter(gameMap.characters[i]);
                if (gameMap.characters[i].getHealth() <= 0) {
                    gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
                }
            } else if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row][character.column + 1].equals("*")) {
                character.hurtCharacter(gameMap.characters[0]);
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row][character.column + 1].equals("x")) {
                System.out.println("Character already dead");
            }
        } else {
            gameMap.layout[character.row][character.column] = ".";
            character.column += 1;
            if (character instanceof Player) {
                gameMap.layout[character.row][character.column] = "*";
            } else {
                gameMap.layout[character.row][character.column] = "%";
            }
        }
    }

    private static void moveLeft(GameCharacter character, Map gameMap) {
        System.out.printf("%s is moving left%n", character.sayName());
        if (character.column <= 0) {
            System.out.println("You can't go left. You lose a move");
        } else if (!gameMap.layout[character.row][character.column - 1].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") &&
                ((gameMap.layout[character.row][character.column - 1].equals("%")) || (gameMap.layout[character.row][character.column - 1].equals("x")))) {
                System.out.println("Monster already there so can't move");
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row][character.column - 1].equals("%")) {
                int i = 1;
                while (i < gameMap.characters.length) {
                    if ((character.row == gameMap.characters[i].row) && ((character.column - 1) == gameMap.characters[i].column)) {
                        break;
                    }
                    i++;
                }
                character.hurtCharacter(gameMap.characters[i]);
                if (gameMap.characters[i].getHealth() <= 0) {
                    gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
                }
            } else if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row][character.column - 1].equals("*")) {
                character.hurtCharacter(gameMap.characters[0]);
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row][character.column - 1].equals("x")) {
                System.out.println("Character already dead");
            }
        } else {
            gameMap.layout[character.row][character.column] = ".";
            character.column -= 1;
            if (character instanceof Player) {
                gameMap.layout[character.row][character.column] = "*";
            } else {
                gameMap.layout[character.row][character.column] = "%";
            }
        }
    }

    private static void moveUp(GameCharacter character, Map gameMap) {
        System.out.printf("%s is moving up%n", character.sayName());
        if (character.row <= 0) {
            System.out.println("You can't go up. You lose a move");
        } else if (!gameMap.layout[character.row - 1][character.column].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") &&
                ((gameMap.layout[character.row - 1][character.column].equals("%")) || (gameMap.layout[character.row - 1][character.column].equals("x")))) {
                System.out.println("Monster already there so can't move");
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row - 1][character.column].equals("%")) {
                int i = 1;
                while (i < gameMap.characters.length) {
                    if (((character.row - 1) == gameMap.characters[i].row) && (character.column == gameMap.characters[i].column)) {
                        break;
                    }
                    i++;
                }
                character.hurtCharacter(gameMap.characters[i]);
                if (gameMap.characters[i].getHealth() <= 0) {
                    gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
                }
            } else if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row - 1][character.column].equals("*")) {
                character.hurtCharacter(gameMap.characters[0]);
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row - 1][character.column].equals("x")) {
                System.out.println("Character already dead");
            }
        } else {
            gameMap.layout[character.row][character.column] = ".";
            character.row -= 1;
            if (character instanceof Player) {
                gameMap.layout[character.row][character.column] = "*";
            } else {
                gameMap.layout[character.row][character.column] = "%";
            }
        }
    }

    private static void moveDown(GameCharacter character, Map gameMap) {
        System.out.printf("%s is moving down%n", character.sayName());
        if (character.row >= (gameMap.layout.length - 1)) {
            System.out.println("You can't go down. You lose a move");
        } else if (!gameMap.layout[character.row + 1][character.column].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") &&
                ((gameMap.layout[character.row + 1][character.column].equals("%")) || (gameMap.layout[character.row + 1][character.column].equals("x")))) {
                System.out.println("Monster already there so can't move");
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row + 1][character.column].equals("%")) {
                int i = 1;
                while (i < gameMap.characters.length) {
                    if (((character.row + 1) == gameMap.characters[i].row) && (character.column == gameMap.characters[i].column)) {
                        break;
                    }
                    i++;
                }
                character.hurtCharacter(gameMap.characters[i]);
                if (gameMap.characters[i].getHealth() <= 0) {
                    gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
                }
            } else if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row + 1][character.column].equals("*")) {
                character.hurtCharacter(gameMap.characters[0]);
            } else if (gameMap.layout[character.row][character.column].equals("*") && gameMap.layout[character.row + 1][character.column].equals("x")) {
                System.out.println("Character already dead");
            }
        } else {
            gameMap.layout[character.row][character.column] = ".";
            character.row += 1;
            if (character instanceof Player) {
                gameMap.layout[character.row][character.column] = "*";
            } else {
                gameMap.layout[character.row][character.column] = "%";
            }
        }
    }
}
