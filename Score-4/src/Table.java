import java.util.Scanner;

public class Table {
	private int rows;
	private int columns;
	private String[][] array;
	
	Scanner keyboard = new Scanner(System.in);
	
	//Kataskeuastes
	public Table() {
		rows=4;
		columns=4;
	}
	public Table(int rows,int columns) {
		this.rows=rows;
		this.columns=columns;
		this.array= new String[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int y=0;y<columns;y++) {
				array[i][y]="-";
			}
		}
	}
	
	//Ektypwsh pinaka
	public void printTable() {
		for(int i=0;i<rows;i++) {
			System.out.print("|");
			for(int y=0;y<columns;y++) {
				System.out.printf("%3s", array[i][y]);
			}
			System.out.println("  |");
		}
		for(int n=0;n<=3*columns+3;n++)
			System.out.print("-");
		System.out.println();
		System.out.print(" ");
		for(int k=1;k<=columns;k++)
			System.out.printf("%3s",k);
	}
	
	//Elegxos gia gemath sthlh
	public boolean fullColumn(int acolumn) {
		if(array[0][acolumn]!="-")
			return true;
		else
			return false;
	}
	
	//Eisagwgh chip sto tamplo
	public void insert(Player aPlayer) {
		int choice;
		System.out.println();
		do {System.out.print(aPlayer.getName()+", your turn. Select column: ");
			choice = keyboard.nextInt();
			if(choice<=0 || choice>columns)
				System.out.println("Incorrect input.");
		}while(choice<=0 || choice>columns);
		while(fullColumn(choice-1)) {
			System.out.print("This column is full. Select a different column: ");
			choice = keyboard.nextInt();}
		for(int j=rows-1;j>=0;j--) {
			if(array[j][choice-1]=="-") {
				array[j][choice-1]=aPlayer.getPlayer_chip();
				break;
			}	
		}
	}
	
	//Elegxos an yparxei nikhths
	public boolean winner() {
		//Orizontia periptwsh
		for(int i=0;i<rows;i++) {
			for(int y=0;y<=columns-4;y++) {
				if(((array[i][y]==array[i][y+1])&&(array[i][y+1]==array[i][y+2])&&(array[i][y+2]==array[i][y+3]))&&array[i][y]!="-") {
					return true;
				}
			}
		}
		//Katakorhfh periptwsh
		for(int i=0;i<columns;i++) {
			for(int y=0;y<=rows-4;y++) {
				if(((array[y][i]==array[y+1][i])&&(array[y+1][i]==array[y+2][i])&&(array[y+2][i]==array[y+3][i]))&&array[y][i]!="-") {
					return true;
				}
			}
		}
		//Diagwnia periptwsh no1
		for(int i=0;i<=columns-4;i++) {
			for(int y=rows-1;y>=3;y--) {
				if(((array[y][i]==array[y-1][i+1])&&(array[y-1][i+1]==array[y-2][i+2])&&(array[y-2][i+2]==array[y-3][i+3]))&&array[y][i]!="-") {
					return true;
				}
			}
		}
		//Diagwnia periptwsh no2
		for(int i=0;i<=rows-4;i++) {
			for(int y=0;y<=columns-4;y++) {
				if(((array[i][y]==array[i+1][y+1])&&(array[i+1][y+1]==array[i+2][y+2])&&(array[i+2][y+2]==array[i+3][y+3]))&&array[i][y]!="-") {
					return true;
				}
			}
		}
		return false;
	}
	
}
