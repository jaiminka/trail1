package data;

import utilities.Xls_Reader;

public class SignInData {
	Xls_Reader d = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dataFiles\\amazon.xlsx"); 
	
	public String wromgEmail  =d.getCellData("data1", 1, 3);
	public String wrongPhoneNumber = d.getCellData("data1", 1, 4);
	public String correctPhoneNumber = d.getCellData("data1", 1, 5);
	public String correctPassword = d.getCellData("data1", 1, 6);
	public String wrongPassword = d.getCellData("data1", 1, 7);
	public String wrongEmailErr = d.getCellData("data1", 1, 8);
	public String emptyEmailErr = d.getCellData("data1", 1, 9);
	public String wrongPasswordErr = d.getCellData("data1", 1, 10);
	public String correctEmail = d.getCellData("data1", 1, 11);
	public String searchItem = d.getCellData("data1", 4, 3);
}
