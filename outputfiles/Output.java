/*
* Class name - Output
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
* Description - Display the required output
*/

package outputfiles;

import java.util.ArrayList;

public class Output{
	public void DisplayResult(ArrayList<OutputList> myList) {
		for(OutputList x : myList){	
			System.out.println("NAME : " + x.name + ", " 
					+ "PRICE : " + String.format("%.2f", x.price) + ", " 
					+ "SALESTAX : " + String.format("%.2f", x.tax) + ", " 
					+ "FINALPRICE : " + String.format("%.2f", x.taxandPrice));
			}

	}
}