/*
 * pseudocode
 * ============
 * define integer array for storing new numeric digits
 * define integer temp and set to 0
 * define integer currentnum and set to 0
 * define string str and set to default
 * 
 * converts integer numbers into string array
 * adds 0(s) to make it 4 digits for user input integer
 * 
 * build currentnum to store numbers for encryption by perform following
 *   adds 7 to each digit
 *   finds remainder of each digit when divided by 10
 *   store encrypted number in currentnum variable
 *   switch 1st and 3rd digit in user input integer
 *   switch 2nd and 4th digit in user input integer
 * 
 * converts encrypted number to a string to variable named str
 * return encrypted number stored in str
 */

public class Encrypter
{
	public static String encrypt(int number)
	{
		//Variables
		int[] newNum = new int[4];
		int temp = 0;
		int currentNum = 0;
		String str = "";
		
		//Split the integer into a string
		String split = String.valueOf(number);
		if(split.length() == 1){
			split = "000" + split;
		}
		else
		{
			for(int i=0; i<(4 - split.length()); i++)
			{
				split  = "0" + split;
			}
		}
		
		//Loop through the number
		for (int i=0; i<4; i++)
		{
			currentNum = 0;
			currentNum += Character.getNumericValue(split.charAt(i));
			currentNum += 7;
			currentNum = currentNum % 10;
			
			//Store encrypted number
			newNum[i] = currentNum;
		}
		
		//Swap the numbers around
		temp = newNum[2];
		newNum[2] = newNum[0];
		newNum[0] = temp;
		temp = newNum[3];
		newNum[3] = newNum[1];
		newNum[1] = temp;
		
		//Convert num array into a string
		for (int i=0; i<4; i++)
		{
		    str = str + Integer.toString(newNum[i]);
		}
		
		return str;
	}
}