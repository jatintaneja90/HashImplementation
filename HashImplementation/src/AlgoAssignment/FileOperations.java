package AlgoAssignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations implements TakeInput{
		private String data="";
		private String[] d;
		public String[] readFile(String fileName) {
		       try {
		         File file = new File(fileName);
		         String temp;
		         Scanner scanner = new Scanner(file);
		         while (scanner.hasNextLine()) {
		        	 
		        	temp = scanner.nextLine().toLowerCase();
		        	 if(!temp.equals(""))
		        		 data+=temp;
		           //System.out.println(scanner.nextLine());
		         }
		         scanner.close();
		       } catch (FileNotFoundException e) {
		         e.printStackTrace();
		       }
		       d=data.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
		       //System.out.println(data);
		       //System.out.println("Returning data to app class.");
		       return d;
		     }
		
		
		public void writeFile(String filename,String str){
			FileWriter fw = null;
			BufferedWriter bfw = null;
			try {
				fw = new FileWriter(filename);
				bfw = new BufferedWriter(fw);
				bfw.write(str);
				
				System.out.println("Content print successful.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					bfw.close();
					fw.close();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
}
