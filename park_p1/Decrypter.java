/*
 * pseudocode
 * ============
 * define integer array for storing new numeric digits
 * define integer named temp and set to 0
 * define integer named num and set to 0
 * define string str and set to default
 * 
 * converts integer numbers into string array
 * adds 0(s) to make it 4 digits for user input integer
 * 
 * for loop to convert user input of 4 digit integer into string
 * 
 * build test to store numbers for decryption by perform following
 *   adds 7 to each digit
 *   finds remainder of each digit when divided by 10
 *   store decrypted number in test variable
 *   switch 1st and 3rd digit in user input integer
 *   switch 2nd and 4th digit in user input integer
 * 
 * converts decrypted number to a string to variable named str
 * return decrypted number stored in str
 */

public class Decrypter
{
	public static String decrypt(int num2)
	{
		//Variables
		int[] newNum = new int[4];
		int temp=0;
		int num=0;
		String str = "";
		
		//Split the integer into a string
		String split = String.valueOf(num2);
		for(int i=0; i<(4 - split.length()); i++)
		{
			split  = "0" + split;
		}
				
		//Get numbers in string
		for (int i=0; i<4; i++)
		{
			newNum[i] = num + Character.getNumericValue(split.charAt(i));
		}
		
		//Swap numbers around
		temp = newNum[1];
		newNum[1] = newNum[3];
		newNum[3] = temp;
		temp = newNum[0];
		newNum[0] = newNum[2];
		newNum[2] = temp;
		
		//Decrpyt numbers
		for (int i=0; i<4; i++)
		{
			int test = newNum[i] - 7;
			if (test < 0)
			{
				test = 10 - Math.abs(test);
			}
			newNum[i] = test;
		}
		
		//Convert num array into a string
		for (int i=0; i<4; i++)
		{
		    str += Integer.toString(newNum[i]);
		}
		
		return str;
	}
}