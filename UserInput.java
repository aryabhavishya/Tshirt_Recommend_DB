package com.naehas.HibernateSample;

import java.util.Scanner;

public class UserInput {
	public void takeInput()
	{
		App app=new App();
		Scanner sc=new Scanner(System.in);
		boolean flag = false;
		do
		{
			System.out.println("Enter Colour");
			app.setColour(sc.nextLine().toUpperCase());
			try
			{
				System.out.println("Enter Gender");
				app.setGender(sc.nextLine().toUpperCase());
				System.out.println("Enter Size");
				app.setSize(sc.nextLine().toUpperCase());
				System.out.println("Please Enter Your Preference of Sorting \n 1) Rating \n 2) Price");
				app.setOutputpreference(sc.nextLine().toUpperCase());
				if((app.gender.equals("M") || app.gender.equals("F") || app.gender.equals("U"))&&
						(app.size.equals("S") || app.size.equals("M") || app.size.equals("L")  || app.size.equals("XL") || app.size.equals("XXL") || app.size.equals("XXXL"))&&
						(app.outputpreference.equals("PRICE") || app.outputpreference.equals("RATING") || app.outputpreference.equals("BOTH")))
				{
					flag=false;
				}
				else
				{
					flag=true;
					throw new Exception();
				}
			}
			catch(Exception e)
			{
				System.out.println("Please Enter Valid Input!!!");
			}
		}while(flag);

		Sorting srt=new Sorting();
		srt.doSorting(app);
	}
}
