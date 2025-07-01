package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{




	public static void main(String [] args){
	
		Scanner scanner=new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		char repeat=0;
		String name,surname;
		System.out.println("Enter your name and surname");
		System.out.print("Name: ");
		name=scanner.next();
		System.out.print("Surname:");
		surname=scanner.next();
		int reMessage=0;
		do{
			
			int unitChoice=getUnitChoice(scanner);
			double weight=(unitChoice ==1)?getValidInput(scanner,"Enter your weight in kilograms: ",10,100)
					:getValidInput(scanner,"Enter your weight in pounds: ",22,1300);
			double height=(unitChoice ==1)?getValidInput(scanner,"Enter your height in meters: ",0.5,2.5)
					:getValidInput(scanner,"Enter your height in inches",20,100);
			double bmi=calculateBMI(unitChoice,weight,height);
			if(reMessage==0){
				System.out.println("Hi "+name+" "+surname+" your BMI is "+bmi+" and you are "+displayCategory(bmi)+"\nWould you like to recalculate your BMI");}
			else{System.out.println(name+" your new BMI is "+bmi+" and you are "+displayCategory(bmi)+"\nWould you like to recalculate your BMI");}
			repeat=askToRepeat(scanner);
			if(repeat=='y'||repeat=='Y'){reMessage++;}
			else if(repeat=='n'||repeat=='N'){
				System.out.println("Closing Calculator........\nClosed");
			}

			
		}while(repeat=='Y'||repeat=='y');
	}
	
	public static int getUnitChoice(Scanner scanner){

		int choice;
		
		while(true){
			System.out.println("Select a preferred unit:\n"
				+"1. Metric (kg, m)\n"
				+"2. Imperial(lbs, in)\n"
				+"Please select either option 1 or option 2");

		
			if(scanner.hasNextInt()){
			choice=scanner.nextInt();
				if(choice==1||choice==2){
					break;
				} else{
					System.out.println("Invalid choice.please enter either 1 or 2");
					}
			}else {
				System.out.println("Invalid input. Please enter a number (1 or 2)");
				scanner.next();
				}
		
		}
	return choice;
	}

	public static double getValidInput(Scanner scanner,String prompt,double min,double max){
		double value;
		
		while(true){
		System.out.println(prompt);
			if(scanner.hasNextDouble()){
				value=scanner.nextDouble();
				if(value>=min&& value<=max){
					break;
				}else {
					System.out.printf("Please enter a value between %.1f and %.1f.\n",min,max);
					}
			}else {
				System.out.println("Invalid input.Please enter a value");
				scanner.next();
				}
		}
	return value;
	}
	
	public static double calculateBMI(int unitChoice,double weight,double height){
	
		double totalBMI;
		
		if(unitChoice==1){
		totalBMI=weight/(height*height);
		}else {
			totalBMI=(703*weight)/(height*height);
			}



	return totalBMI;

	}
	
	public static String displayCategory(double bmi){

		if(bmi<18.5){
			if(bmi>=16.0){
				return "Underweight";
			}else{return "Severely Underweight";}

		}else if(bmi>=18.5&&bmi<40.0){
			if(bmi<=24.9){
				return "Normal";
			}else if(bmi>=25.0&&bmi<30.0){
				return "Overweight";
			}else if(bmi>=30.0&&bmi<35.0){
				return "Moderately Obese";
			}else{return "Severely Obese";}
			
		}else {return "Morbidly Obese";}
		
	}

	public static char askToRepeat(Scanner scanner){
	 char repeat;
		while(true){
		String doThey=scanner.next();
			repeat=doThey.charAt(0);
			System.out.println();
			if(repeat=='n'||repeat=='N') break;
			if(repeat=='Y'||repeat=='y') break;
			else System.out.print("Please answer Yes or No:");
		}
		return repeat;
	
		
		

	}


}