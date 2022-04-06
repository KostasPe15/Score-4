import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//Dhmiourgia paikth kai eisagwgh onomatos
		System.out.println("This is Score4");
		Player p1 = new Player();
		Player p2 = new Player();
		System.out.print("Please enter the name of the 1st player: ");
		p1.name_read();
		System.out.print("Please enter the name of the 2nd player: ");
		do {p2.name_read();
			if(p2.getName().equals(p1.getName())) {
				System.out.println("Incorrect input");
				System.out.print("Please enter a valid name: ");
			}else
				break;
		}while(true);
				
		//Epilogh chip
		String answer=" ";
		String other=" ";
		boolean flag=true;
		do {System.out.print(p1.getName() + ", please select your chip(x or o): ");
			answer = keyboard.nextLine();
			if (answer.equals("x")) {
				flag = false;
				other = "o";  }
			if (answer.equals("o")) {
				flag = false;
				other = "x";  }
			if(flag==true)
				System.out.println("Incorrect input. Choose between x or o.");
		}while(flag);
		p1.chip_read(answer);
		p2.chip_read(other);
		p2.chip_print(p2);
		p1.chip_print(p1);
		
		//Eisagwgh grammwn - sthlwn kai dhmiourgia tou pinaka 
		int rows;
		int columns;
		do {System.out.print("Please enter the number of rows: ");
			rows = keyboard.nextInt();
			if(rows<4 || rows>15)
				System.out.println("Incorrect input.");
		}while(!(rows>=4 && rows<=15));
		do {System.out.print("Please enter the number of columns: ");
			columns= keyboard.nextInt();
			if(columns<4 || columns>15)
				 System.out.println("Incorrect input.");
		}while(!(columns>=4 && columns<=15));
		Table GameTable = new Table(rows,columns);
		GameTable.printTable();
		
		//Dhmiourgia tyxaias seiras twn paiktwn
		Player First = p2;
		Player Second = p1;
		Random arandom = new Random();
		boolean flag2 = arandom.nextBoolean();
		if(flag2) {
			First = p1;
			Second = p2;}
		System.out.println();
		
		//Enarksh paixnidou
		int k;
		for(k=1;k<=(rows*columns)/2;k++) {
			GameTable.insert(First);
			GameTable.printTable();
			if(GameTable.winner()) {
				System.out.println();
				System.out.println("GAME OVER. THE WINNER IS "+First.getName());
				break;}
			GameTable.insert(Second);
			GameTable.printTable();
			if(GameTable.winner()) {
				System.out.println();
				System.out.println("GAME OVER. THE WINNER IS "+Second.getName());
				break;}
		}
		System.out.println();
		if(k>(rows*columns)/2)
			System.out.println("GAME OVER. WE HAVE A DRAW");
		
	}
}