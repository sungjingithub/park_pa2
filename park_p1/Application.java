import java.util.Scanner;

public class Application
{
	public static void main(String[] args)
	{
		//Variables
		int number;
		String result;
		Scanner input = new Scanner( System.in );

		//Get input and close scanner
		System.out.print("Type 4 digit integer to encrypt: ");
		number = input.nextInt();
		//input.close();
		
		//Encrypt number
		result = Encrypter.encrypt(number);
		System.out.println(result);
		
		//Get input and close scanner
		//input = new Scanner( System.in );
		System.out.print("Type 4 digit encrypted integer to decrypt: ");
		number = input.nextInt();
		input.close();
		
		//Decrpyt number
		result = Decrypter.decrypt(number);
		
		System.out.println(result);
		
		System.out.println("\nEnd of Program.");
	}
}