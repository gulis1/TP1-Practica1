package control;

import java.util.Random;
import java.util.Scanner;

import logic.Game;
import view.GamePrinter;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner scanner;
    private GamePrinter printer;

    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    
    public void run() {

		do {
			game.getBoard().summonVampires(game.getLevel());
			System.out.println(this.game.printGame());
			game.getBoard().getVampireList().move();
		}while (!game.getBoard().getVampireList().alguienEnFinal());

		System.out.println(this.game.printGame());
		System.out.println("Game over");


    }

}

