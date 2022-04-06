import java.util.Scanner;

public class Player {
	private String name;
	private String player_chip;
	
	Scanner keyboard = new Scanner(System.in);
	
	//Kataskeuasths
	public Player () {
		name = "";
	}
	
	//Eisagwgh onomatos
	public void name_read () {
		do {name=keyboard.nextLine();
			if(name.length()<2 || name.length()>20 || name.contains(" ")) {
				System.out.println("Incorrect input");
				System.out.print("Please enter a valid name: ");
			}
		}while(name.length()<2 || name.length()>20 || name.contains(" "));
	}	
	
	//Eisagwgh chip
	public void chip_read (String choice) {
		if (choice.contentEquals("x")) {
			player_chip = "x";
		}
		else {
			player_chip = "o";
		}
	}
	
	//Ektypwsh chip paikth
	public void chip_print (Player aname) {
		System.out.println(aname.name + ", your chip is: " + aname.player_chip);
	}

	//Getters
	public String getPlayer_chip() {
		return player_chip;
	}
	public String getName() {
		return name;
	}

}
