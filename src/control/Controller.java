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

    private boolean menu() {

    	boolean salir = false;
		boolean accionCorrecta = false;

		while (!accionCorrecta && !salir)
		{
			System.out.println(prompt);

			String action = scanner.nextLine();
			String[] command = action.trim().toLowerCase().split(" ");

			switch(command[0])  {

				case "h":
				case "help": {
					System.out.println(helpMsg);
					break;
				}
				case "e":
				case "exit": {
					salir = true;
					break;
				}

				case "a":
				case "add": {
					if (game.addSlayer(Integer.parseInt(command[1]), Integer.parseInt(command[2])))
						accionCorrecta = true;

					break;

				}

				case "n":
				case "none":
				case "":	{
					accionCorrecta = true;
					break;
				}




			}
		}

		return salir;
	}
    
    public void run() {

    	boolean salir = false;
    	// Bucle del juego
		do {
			game.summonVampires();
			System.out.printf("Ciclo: %d, Monedas: %d, Vampiros Restantes: %d, Vampiros en tablero : %d", game.getCiclo(), game.getPlayer().getMonedas(), game.getBoard().getVampRestantes(), game.getBoard().getVampTablero() );
			System.out.println(this.game.printGame());
			salir = menu();
			game.moveVampires();
			game.incrementarMonedas();

		}while (!game.isFinished() && !salir);

		System.out.println(this.game.printGame());
		System.out.println("Game over");


    }

}

