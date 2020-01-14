/*
* Class name - OutputList
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
* Description - Class which takes parameter of OutputList
*/

package outputfiles;


public class OutputList{
	String name;
	double tax;
	double price;
	double taxandPrice;
	
	public OutputList(String name, 
			double price, 
			double tax, 
			double taxandPrice) {
		
		this.name = name;
		this.price = price;
		this.tax = tax;
		this.taxandPrice = taxandPrice;
		
	}	
	
}