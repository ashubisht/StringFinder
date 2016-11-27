package mainpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import abstractedpack.CompareStr;
import process.StringFinder;

public class DefClass {
	public static void main(String[] args) {
		StringFinder finder = new StringFinder();
		List<Character> charList = new ArrayList<>();
		CompareStr compareStr = new CompareStr();
		
		char[] charLocale = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (char c : charLocale){
			charList.add(c);
		}
		
		String str = "";
		
		try{
			
			while(true){
				str = finder.generateStr(str, charList);
				if(compareStr.testStr(str)==true){
					break;
				}
				
			}
			
			System.out.println("Required string is: " + str);
			
		}catch(Exception e){
			Logger.getLogger(DefClass.class.getName()).log(Level.ALL, "Unable to find string");
			System.out.println("Unable to find string");
		}
		
		
	}
}
