package process;

import java.util.List;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class StringFinder {
	
	String strGen="";
	
	public String generateStr(String str, List<Character> charList) throws Exception{
		
		if(str.equals("")){
 			strGen = charList.get(0)+""; //Initialize String
		}else{
			strGen = genString(str, charList, str.length()); //Get the next string
		}
		
		return strGen;
	}
	
	
	private String genString(String str, List<Character> charList, int size) throws Exception{

		Character ch = str.charAt(str.length()-1);
		int index = charList.indexOf(ch);
		try{
			strGen = strGen.substring(0, str.length()-1)+charList.get(++index); //Get next character from character locale 
																				//for last letter of currently genertaed string
		}catch(Exception e){ //Reached till end of locale
			System.out.println("Finished string search of length "+ str.length() +
					/*". Now will search for length "+(str.length()+1) +*/ ". Last string searched is "+str);
			
			//Temp code for limiting search
			/*if(str.length()+1>3){
				Logger.getLogger(this.getClass()).log(Level.ALL, "Size exceeded");
				throw new Exception("Size exceeded");
			}*/
			strGen= generateNextStr(str, charList, size);
		}
		return strGen;
	}

	private String generateNextStr(String str, List<Character> charList, int size){
		
		String newStr = "";
		
		char[] charArray = str.toCharArray();
		boolean needsIncrement = true;
		int index = 0;
		for(int i = charArray.length-1; i>=0; i--){
			if(charArray[i]!=charList.get(charList.size()-1)){
				needsIncrement = false;
				index = i;
				break;
			}
		}
		
		if(needsIncrement){
			newStr = incrementSize(charList, size); 
		}else{
			newStr = generateNextKey(index, charList, size, charArray);
		}
		
		return newStr;
	}
	
	


	private String generateNextKey(int index, List<Character> charList, int size, char[] charArray) {
		
		StringBuilder str = new StringBuilder("");
		Character ch = charArray[index];
		int indexInLocale = charList.indexOf(ch);
		charArray[index] = charList.get(++indexInLocale);
		for(int i = 0; i<=index;i++){
			str.append(charArray[i]);
		}
		for(int i = index+1; i<size;i++){
			str.append(charList.get(0));
		}
		return str.toString();
	}


	private String incrementSize(List<Character> charList, int currentSize){
		//Returns new string with one size increased and having text from 1st letter of locale
		int newSize= currentSize+1;
		String newStr = "";
		for(int i =0; i<newSize; i++){
			newStr+=charList.get(0);
		}
		
		return newStr;
	}
	
}
