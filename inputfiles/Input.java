package inputfiles;

/*
* Class name - Input
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 10-01-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 14-01-2020
*
* Description - Takes the required input
*/

import outputfiles.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Input {
	public static ArrayList<InputList> myInputList = new ArrayList<InputList>();
	Scanner input = new Scanner(System.in);
	
	
	public void takeInput() {
		
		
		int i = 0;
		
			while(i < 4) {
				
				String userCommand;
				String userInput;
				try {
					String[] read = input.nextLine().split(" ");
					userCommand = read[0];
					userInput = read[1];
				} 
				catch (Exception e1) {
					System.out.println("Please Enter Input with Command");
					continue;
				}
				
				UserCommandTypes userCommandObj = new UserCommandTypes();
				
				// validation
				
				try {
					userCommandObj.setValues(userCommand, userInput);
					i++;
				} 
				catch (NumberFormatException e) {
					continue;	
				}
				catch(NullPointerException e) {
					System.out.println("Ënter Valid Commands ");
					continue;
				}
				catch(IllegalArgumentException e) {
					continue;
				}
				catch(ArithmeticException ae) {
					continue;
				}
			}

		
		InputList inputListObj = new InputList(UserCommandTypes.name, 
				UserCommandTypes.type, 
				UserCommandTypes.price, 
				UserCommandTypes.quantity);
				
		myInputList.add(inputListObj);	
		
		
	}
	public boolean checkContinue(ArrayList<OutputList> myList) {
		System.out.println("Do you want to enter details of any other item (y/n): ");
		
		if(input.nextLine().charAt(0) == 'n') {
			Output outputObject = new Output();
			outputObject.DisplayResult(myList);
		
			return false;
		}
		else{
			
			return true;
		}
	
	}
}

