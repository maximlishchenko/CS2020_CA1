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
            game.getMap().printLayout();
            round += 1;
		}
	}
}
