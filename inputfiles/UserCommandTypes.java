/*
* Class name - UserCommandTypes
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
* Description - Assign the value to the variables on the basis
* of user commands
* 
*/

package inputfiles;

import java.util.HashMap;
import java.util.Map;



enum UserCommandEnum{
	NAME("-name"),
	TYPE("-type"),
	PRICE("-price"),
	QUANTITY("-quantity");
	
	private String commandType;
	
	UserCommandEnum(String type){
		this.commandType = type;
	}
	
	public String getCommandType() {
		return commandType;
	}
	
	//Lookup Table
	
	private static final Map<String, UserCommandEnum> lookup = new HashMap<>();
	
	
	// populate the lookup table
	
	static {
		for(UserCommandEnum cmd : UserCommandEnum.values())
		{
			lookup.put(cmd.getCommandType(), cmd);
		}
	}
	
	public static UserCommandEnum get(String type) {
		return lookup.get(type);
	}
	}







public class UserCommandTypes{
	
	public static String name;
	public static String type;
	public static double price;
	public static double quantity = 1;
	
	
	public void setValues(String userCommand,String userInput){
		UserCommandEnum object = UserCommandEnum.get(userCommand);
		
		
		try {
			switch(object){
			case NAME:
				name = userInput;
				break;
			case PRICE:
				price = Double.parseDouble(userInput);
				if(price <= 0 ) {
					throw new ArithmeticException("");
				} 
				break;
			case TYPE:
				if(ItemType.isMember(userInput)) {
					type = userInput;
					break;
				}
				else {
					throw new IllegalArgumentException("");
				}
				
			case QUANTITY:
				quantity = Double.parseDouble(userInput);
				if(quantity <= 0 ) {	
					throw new ArithmeticException("");
				} 
				break;
			
			}
	}
		catch (NumberFormatException e) {
			System.out.println("Please Enter The Current input in  Valid DataType ");
			throw new NumberFormatException("");	
		}
		catch(ArithmeticException ae) {
			System.out.println("Please Enter Positive Number");
			throw new ArithmeticException("");
		}
		
		catch(IllegalArgumentException e) {
			System.out.println("Please Enter The Valid Type i.e. raw, imported, manufactured ");
			throw new IllegalArgumentException("");
		}
	}
	
}