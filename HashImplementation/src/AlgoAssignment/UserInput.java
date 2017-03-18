package AlgoAssignment;

import java.util.Scanner;

public class UserInput implements TakeInput {
	private String data="";
	private String[] d;
	public String[] readFile(String fileName){
		Scanner scan=new Scanner(System.in);
		data=scan.nextLine();
		d=data.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
		scan.close();
		return d;
	}
}
