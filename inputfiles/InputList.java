package inputfiles;

/*
* Class name - InputList
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
* Description - Class which takes parameter of InputList
*/


public class InputList{
	String name;
	String type;
	double price;
	double quantity;
	
	public InputList(String inputName,
	String inputType,
	double inputPrice,
	double inputQuantity) {
		
		this.name = inputName;
		this.price = inputPrice;
		this.type = inputType;
		this.quantity = inputQuantity;
		
	}
	
	
}