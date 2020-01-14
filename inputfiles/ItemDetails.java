/*
* Class name - ItemDetails
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

package inputfiles;


import outputfiles.OutputList;
import java.util.ArrayList;

enum ItemType{
	raw,
	manufactured,
	imported;

	public static boolean isMember(String type) {
		for(ItemType c : ItemType.values()) {
			if(c.name().equals(type)) {
				return true;
			}
		}
		
		return false;
	}

	}




public class ItemDetails{
	
	public static ArrayList<OutputList> myList = new ArrayList<OutputList>();
	
	private String itemName;
	private String itemType;
	private double itemPrice;
	private double itemQuantity;
	private double tax = 0;
	
	public String getitemName(){
		return itemName;
	}
	
	public String getitemType(){
		return itemType;
	}
	
	public double getitemPrice(){
		return itemPrice;
	}
	
	public double getitemQuantity(){
		return itemQuantity;
	}
	
	
	public void setItemValues() {		
		
		for(InputList x : Input.myInputList) {
			setitemName(x.name);
			setitemPrice(x.price);
			setitemQuantity(x.quantity);
			setitemType(x.type);
			
			tax = doCalculation();
			
			
			
			OutputList listObject = new OutputList(getitemName(), 
			getitemQuantity() * getitemPrice(), 
			tax, 
			(getitemQuantity() * getitemPrice()) + tax);		
	
			myList.add(listObject);
			
		}
	}
	
	public void setitemName(String name){
		this.itemName = name;
	}
	
	public void setitemType(String type){
		this.itemType = type;
	}
	
	public void setitemPrice(double price){
		this.itemPrice = price;
	}
	
	public void setitemQuantity(double quantity){
		this.itemQuantity = quantity;
	}
	
	public double calculateRawTax() {
		tax = itemQuantity * 12.5 * itemPrice / 100;
		return tax;
	}
	
	public double calculateImportedTax() {
		tax = (10 * itemPrice)/100;
		double  subCharge;
		
		if(tax + itemPrice <= 100) {
			subCharge = 5;	
		}
		
		else if(tax + itemPrice <= 200) {
			subCharge = 10;
		}
		
		else {
			subCharge = 5 * (tax + itemPrice) / 100;
		}
 		
		// for single item
		tax = tax + subCharge;
		
		// for n item quantities
		tax = tax * itemQuantity;
		
		return tax;
	}
	
	public double calculateManufacturedTax() {
		
		tax = (12.5 * itemPrice) /100
				+ 2*(itemPrice + 12.5 * itemPrice / 100)
				/100;
		 		tax = tax * itemQuantity;
		 		
		return tax;
	}
	
	public double doCalculation() {
		ItemType type = ItemType.valueOf(itemType);
		switch(type) {
		
			case raw:
				return calculateRawTax();
				
			case manufactured:
				return calculateManufacturedTax();
				
				
			case imported:
				return calculateImportedTax();
				
			default:
				return 0;
		}
	}
	
	
	
}