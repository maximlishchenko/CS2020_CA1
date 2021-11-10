package uoa.assignment1.game;

import java.util.Scanner;

public class RunGame {

    private static boolean gameOver = false;

	public static void main(String[] args) {
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        Game game = new Game(height, width);
        Scanner in = new Scanner(System.in);
        int round = 1;

        while (!gameOver) {
            System.out.printf("%nRound %d%n", round);
            String input = in.nextLine();
            gameOver = game.nextRound(input);
            System.out.println();
            for (int i = 0; i < game.getMap().characters.length; i++) {
                System.out.printf("Health %s:  %d%n", game.getMap().characters[i].sayName(), game.getMap().characters[i].getHealth());
            }
            System.out.println();
            if (gameOver) {
                if (game.getMap().characters[0].getHealth() <= 0) {
                    System.out.println("YOU HAVE DIED!");
                } else {
                    System.out.println("YOU HAVE WON!");
                }
            }
            game.getMap().printLayout();
            round += 1;
		}
	}

}
