/*
* Class name - Assignment1
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
* Description - Calculates the tax based on the type of item
*/

import outputfiles.*;
import inputfiles.*;

public class Assignment1{
	public static void main(String[] args) {
		boolean run = true;
		
			while(run) {
				
				Input inputObj = new Input();
				inputObj.takeInput();
				run = inputObj.checkContinue(ItemDetails.myList);
		
			}
			
			ItemDetails itemDetailObj = new ItemDetails();
			itemDetailObj.setItemValues();
			
			Output outputObj = new Output();
			outputObj.DisplayResult(ItemDetails.myList);
		
	}
}