package Game.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceManager {
	
	private static BufferedReader reader;
	
	public static ArrayList<String> readRoomFile (String filename){
		System.out.println("[ResourceManager]: reading " + filename);
		
		ArrayList<String> strings = new ArrayList <String>();
		try {
			reader = new BufferedReader(new FileReader(filename));
			
		}catch (FileNotFoundException e) {
			System.out.println("[ResourceManager]: Error! file " + filename + " not found!");
		}
 		try {
 			
 			String str = reader.readLine();
 			strings.add(str);
 			
 				while(str != null) {
 					str = reader.readLine();
 					strings.add(str);
 				}
 		}catch (IOException e) {
 			System.out.println("[ResourceManager]: IOEXception!");
 		}
 		return strings;
	}
	
}
