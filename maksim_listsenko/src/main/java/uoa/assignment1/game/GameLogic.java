package uoa.assignment1.game;

import java.util.Scanner;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if (input != "up" && input != "down" && input != "left" && input != "right") {
            System.out.println("Use only keywords up, down, left, right");
        }

        if (input == "up") {
            moveUp(character, gameMap);
        } else if (input == "down") {
            moveDown(character, gameMap);
        } else if (input == "left") {
            moveLeft(character, gameMap);
        } else if (input == "right") {
            moveRight(character, gameMap);
        }
	}

    private static void moveRight(GameCharacter character, Map gameMap) {
        gameMap.layout[character.row][character.column] = ".";
        character.column += 1;
        if (character instanceof Player) {
            gameMap.layout[character.row][character.column] = "*";
        } else {
            gameMap.layout[character.row][character.column] = "%";
        }
    }

    private static void moveLeft(GameCharacter character, Map gameMap) {
        gameMap.layout[character.row][character.column] = ".";
        character.column -= 1;
        if (character instanceof Player) {
            gameMap.layout[character.row][character.column] = "*";
        } else {
            gameMap.layout[character.row][character.column] = "%";
        }
    }

    private static void moveUp(GameCharacter character, Map gameMap) {
        gameMap.layout[character.row][character.column] = ".";
        character.row -= 1;
        if (character instanceof Player) {
            gameMap.layout[character.row][character.column] = "*";
        } else {
            gameMap.layout[character.row][character.column] = "%";
        }
    }

    private static void moveDown(GameCharacter character, Map gameMap) {
        gameMap.layout[character.row][character.column] = ".";
        character.row += 1;
        if (character instanceof Player) {
            gameMap.layout[character.row][character.column] = "*";
        } else {
            gameMap.layout[character.row][character.column] = "%";
        }
    }
}
