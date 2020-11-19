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
	public static final String noCoinsMsg = String.format("Not enough coins");

    private Game game;
    private Scanner scanner;
    private GamePrinter printer;
    
//cosntructor
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
//bucle del menu que devuele a la acion seleccionada(si esta el comando es correcto).
    private boolean menu() {

    	boolean salir = false;
		boolean accionCorrecta = false;

		while (!accionCorrecta && !salir) {
			System.out.println(prompt);

			String action = scanner.nextLine();
			String[] command = action.trim().toLowerCase().split(" ");

			switch(command[0])  {

				case "h":
				case "help": {
					if (command.length == 1)
						System.out.println(helpMsg);
					else
						System.out.println(invalidCommandMsg);
					break;

				}
				case "e":
				case "exit": {
					if (command.length == 1)
						salir = true;
					else
						System.out.println(invalidCommandMsg);
					break;
				}

				case "a":
				case "add": {
					if (command.length == 1) {
						try {
							int error = game.addSlayer(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

							if (error == 0)
								accionCorrecta = true;

							else if (error == 1)
								System.out.println(invalidPositionMsg);

							else
								System.out.println(noCoinsMsg);

						}

						catch (Exception e) {
							System.out.println(invalidCommandMsg);
						}
					}

					else
						System.out.println(invalidCommandMsg);

					break;

				}

				case "reset":
				case "r": {
					if (command.length == 1) {
						game.reset();
						accionCorrecta = true;
					}


					else
						System.out.println(invalidCommandMsg);

					break;
				}


				case "n":
				case "none":
				case "":	{
					accionCorrecta = true;
					break;
				}

				default:
					System.out.println(unknownCommandMsg);

			}

		}

		return salir;
	}

	public void printmsg() {
		System.out.printf("Number of cycles: %d\nCoins: %d\nRemaining vampires: %d\nVampires on the board: %d\n", game.getCiclo(), game.getPlayer().getMonedas(), game.getBoard().getVampRestantes(), game.getBoard().getVampTablero());
	}
    
    public void run() {

    	boolean salir = false;
    	// Bucle del juego
		while (game.isFinished() == 0 && !salir){
			printmsg();
			System.out.println(this.game.printGame());
			game.update();
			salir = menu();


		}
       //ultimo estado del juego.
		printmsg();
		System.out.println(this.game.printGame());

		//mensaje del final.
		if (game.isFinished() == 1)
			System.out.println("Game over");

		else if (game.isFinished() == 2)
			System.out.println("You win");



    }

}

