/*
 * Pseudo Code
 * ============
 * define input to read user inputs 
 * define integer temp and set to 0
 * define weight height unitType bmi as real numbers
 * define name bmiCat as sting and set to default
 * 
 * Get user input for unit type to read bmi 
 * 1 for imperial or 2 for metric
 * 
 * if metric is selected by user convert bmi in metric units
 * 		prompt user for weight in Kilograms
 * 		prompt user for height in centimeters
 * 		store values in weightM heightM
 * 
 * if Imperial is selected by user convert bmi in imperial units
 * 		prompt user for weight in pounds
 * 		prompt user for height in feet and inches
 * 		store values in weightI, heightI1, heightI2
 * 
 * calculate bmi value and store for bmi category
 * 
 * determine user bmi category based on bmi value
 * 
 * display bmi
 * display bmi category
 */

import java.util.Scanner;

public class BMICalculator
{
	/*
	BMI Categories: 
	Underweight = <18.5
	Normal weight = 18.5 - 24.9 
	Overweight = 25 - 29.9 
	Obesity = BMI of 30 or greater
	*/
	
	/*
	BMI Calculations:
	Imperial:
	703 * WeightInLBS / HeightInInches Squared
	
	Metric:
	WeightInKilograms / HeightInMeters Squared
	 */
	
	//Variables
	Scanner input = new Scanner( System.in );
	double weight, height, unitType, bmi;
	String bmiCat;
	
	public void readUserData()
	{
		readUnitType();
		readMeasurementData();
	}
	 
	private void readUnitType()
	{
		input = new Scanner( System.in );
		unitType = 0;
		
		while (unitType != 1 || unitType != 2)
		{
			System.out.print("Select unit type. Enter 1 for Imperial or 2 for Metric: ");
			unitType = input.nextInt();
			if (unitType ==1 || unitType == 2)
				break;
		}
	}
	
	private void readMeasurementData()
	{
		//Read Metric or Imperial
		if (unitType == 2)
		{
			readMetricData();
		}
		else readImperialData();
	}
	
	//Centimeters Kilograms
	private void readMetricData()
	{
		double weightM, heightM;
		input = new Scanner( System.in );
		
		System.out.print("Enter weight in Kilograms: ");
		weightM = input.nextDouble();
		if (weightM <1)
			System.exit(0);
		setWeight(weightM);
		
		System.out.print("Enter height in centimeters: ");
		heightM = input.nextDouble();
		if (heightM <1)
			System.exit(0); 
		setHeight(heightM/100);
		
		input.close();
	}
	
	//Feet inches pounds
	private void readImperialData()
	{
		double weightI, heightI1, heightI2;
		input = new Scanner( System.in );
		
		System.out.print("Enter weight in LBS: ");
		weightI = input.nextDouble();
		if (weightI <1)
			System.exit(0);
		setWeight(weightI/2.205);
		
		System.out.print("Enter height in feet first: ");
		heightI1 = input.nextInt();
		if (heightI1 <1)
			System.exit(0);
		heightI1 /= 3.281;
		
		System.out.print("Enter height in inches next: ");
		heightI2 = input.nextInt();
		if (heightI2 <0)
			System.exit(0);
		heightI2 /= 39.37;
		
		setHeight(heightI1 + heightI2);
		
		input.close();
	}
	 
	public void calculateBmi()
	{
		double weightC = getWeight();
		double heightC = getHeight();
		
		bmi = weightC / Math.pow(heightC, 2);
		
		calculateBmiCategory();
	}
	
	private String calculateBmiCategory()
	{
		if (bmi <18.5)
			return "Underweight";
		if (bmi >18.5 && bmi <24.9)
			return "Normal weight";
		if (bmi >25 && bmi <29.9)
			return "Overweight";
		if (bmi >=30)
			return "Obesity";
		else
			return "Obesity";
	}
	
	public void displayBmi()
	{
		System.out.println("\nBmi is: " + getBmi());
		System.out.println("Bmi category is: " + calculateBmiCategory());
		System.exit(0);
	}
	
	public double getWeight()
	{
		 return weight;
	}
	
	//Sets in Kilograms
	private void setWeight(double weightPassed)
	{
		 weight=weightPassed;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	//Sets in Meters
	private void setHeight(double heightPassed)
	{
		 height = heightPassed;
	}
	
	public double getBmi()
	{
		 return bmi;
	}
	
	public void getBmiCategory()
	{
		bmiCat = calculateBmiCategory();
	}
}