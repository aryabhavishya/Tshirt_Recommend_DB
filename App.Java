package com.naehas.hibernatesample;
public class App 
{
	// Creating Class Members About User Input
	String outputpreference;
	String colour;
	String gender;
	String size;


	public String getOutputpreference() {
		return outputpreference;
	}


	public void setOutputpreference(String outputpreference) {
		this.outputpreference = outputpreference;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}

	public static void main(String[] args)
	{
		
		// Creating Object Of CsvFile this method scans and stores data of csv file into database
		CSVFile csv=new CSVFile();
		csv.parseForCsvFiles("C:\\Users\\ASUS\\Downloads\\Stores");
		
		// Taking Input From the user
		UserInput ui=new UserInput();
		ui.takeInput();

	}
}
