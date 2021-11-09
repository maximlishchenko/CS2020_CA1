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
            if (input == "up") {
                moveUp(character, gameMap);
            } else if (input == "down") {
                moveDown(character, gameMap);
            } else if (input == "left") {
                moveLeft(character, gameMap);
            } else if (input == "right") {
                moveRight(character, gameMap);
            }
        } else {
            System.out.println("Use only keywords up, down, left, right");
        }
	}

    private static void moveRight(GameCharacter character, Map gameMap) {
        if (character.column >= (gameMap.layout[character.row].length - 1)) {
            System.out.println("You can't go right. You lose a move.");
        } else if (!gameMap.layout[character.row][character.column + 1].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row][character.column + 1].equals("%")) {
                System.out.println("Monster already there so can't move");
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
        if (character.column <= 0) {
            System.out.println("You can't go left. You lose a move.");
        } else if (!gameMap.layout[character.row][character.column - 1].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row][character.column - 1].equals("%")) {
                System.out.println("Monster already there so can't move");
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
        if (character.row <= 0) {
            System.out.println("You can't go up. You lose a move.");
        } else if (!gameMap.layout[character.row - 1][character.column].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row - 1][character.column].equals("%")) {
                System.out.println("Monster already there so can't move");
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
        if (character.row >= (gameMap.layout.length - 1)) {
            System.out.println("You can't go down. You lose a move.");
        } else if (!gameMap.layout[character.row + 1][character.column].equals(".")) {
            if (gameMap.layout[character.row][character.column].equals("%") && gameMap.layout[character.row + 1][character.column].equals("%")) {
                System.out.println("Monster already there so can't move");
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
