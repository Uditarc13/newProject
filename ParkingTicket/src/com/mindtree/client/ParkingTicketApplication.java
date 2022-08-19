package com.mindtree.client;
import com.mindtree.entity.*;
import java.util.Scanner;

public class ParkingTicketApplication 
{
	static Scanner sc = new Scanner(System.in);
	static Scanner s1= new Scanner(System.in);
	public static void main(String[] args)
	{
		
		System.out.println("Enter number of cars already present in the parking lot: ");
		int noOfCarsGiven=sc.nextInt();
		int carsPresent=isValidInput(noOfCarsGiven);
		Parking[] parkingTickets= new Parking[100];
		parkingTickets=enterrecord(parkingTickets,carsPresent);
		System.out.println("Check if parking slots are available: ");
		if(carsPresent<100)
		{
			System.out.println("The parking slots that are available :");
			int choice;
			do
			{
				
				choice = displayMenu();
				
				
				switch(choice)
				{
				case 1:
					System.out.println("Parking slot allocated");
					parkingTickets=addCars(parkingTickets,carsPresent);
					carsPresent=carsPresent+1;
					break;
					
				case 2:
					System.out.println("Get the vehicle number of the car that exits: ");
					String vehicleNumber=s1.nextLine();
					boolean isPresent=false;
					for(int i=0;i<parkingTickets.length;i++)
					{
						if(parkingTickets[i]!=null)
						{
							if(vehicleNumber.compareTo(parkingTickets[i].getVehicleNumber())==0)
							{
								isPresent=true;
								break;
							}
						}
						
					}
					parkingTickets=parkingFeeDetails(parkingTickets);
					if(isPresent==true)
					{
					carsPresent=carsPresent-1;
					}
					break;
					
				case 3: break;
				default: System.out.println("Please enter proper choice");
						break;
					
			}
		}while(choice!=3);
		}
		else
		{
			System.out.println("The parking slots are not available");
		}
		
	}
	public static int displayMenu() {
		int choice;
		System.out.println("Choose the operations you want to perfrorm");
		System.out.println("Option 1: A cars enters and its details");
		System.out.println("Option 2: Get the parking fee for a car");
		System.out.println("Option 3: Exit");
		System.out.println("Please Enter your choice");
		choice=sc.nextInt();
		return choice;
	}
	public static int isValidInput(int input)
	{
		Scanner sc=new Scanner(System.in);
		boolean validinput=true;
		while(validinput)
		{
			if(input<0)
			{
				System.out.println("The number of customers cannot be negative.Please enter again:");
				input=sc.nextInt();
			}
			else
			{
				validinput=false;
			}
		}
		
		return input;
	}
	public static Parking[] enterrecord(Parking[] customers, int carsPresent)
	{
		Scanner sc= new Scanner(System.in);
		
		
		for(int i=0;i<carsPresent;i++)
		{
			System.out.println("----------------------------------------------------------");
			customers[i]= new Parking();
			System.out.println("Enter the vehicle number of the customer");
			String vehicleNumberInput=sc.nextLine();
			String vehicleNumber=isValidVehicleNumber(vehicleNumberInput,customers,i);
			customers[i].setVehicleNumber(vehicleNumber);
			
			System.out.println("Enter the entry time  customer:");
			String entryTimeinput=sc.nextLine();
			String entryTime=isValidTime(entryTimeinput);
			customers[i].setEntryTime(entryTime);
			 
			
			System.out.println("----------------------------------------------------------");
			
			
		}
		return customers;
	
}
	
	public static Parking[] addCars(Parking[] customers, int carsPresent)
	{
		Scanner sc= new Scanner(System.in);
		
		
		for(int i=carsPresent;i<=carsPresent;i++)
		{
			System.out.println("----------------------------------------------------------");
			customers[i]= new Parking();
			System.out.println("Enter the vehicle number of the customer");
			String vehicleNumberInput=sc.nextLine();
			String vehicleNumber=isValidVehicleNumber(vehicleNumberInput,customers,i);
			customers[i].setVehicleNumber(vehicleNumber);
			
			System.out.println("Enter the entry time  customer:");
			String entryTimeinput=sc.nextLine();
			String entryTime=isValidTime(entryTimeinput);
			customers[i].setEntryTime(entryTime);
			 
			
			System.out.println("----------------------------------------------------------");
			
			
		}
		return customers;
	
}
	
	public static String isValidVehicleNumber(String input,Parking[] customers, int presentnumber)
	{
		Scanner sc=new Scanner(System.in);
		boolean validinput=true;
		while(validinput)
		{
			if(input.length()<=0)
			{
				System.out.println("The vehicle number cannot be negative or zero.Please enter again:");
				input=sc.nextLine();
			}
			else
			{
				String noGiven=input;
				String number="";
				for(int i=0;i<presentnumber;i++)
				{
				 number =customers[i].getVehicleNumber();
				
				if(number.compareTo(noGiven)==0)
				{
					System.out.println("This vehicle number is already present. Please enter again");
					input= sc.nextLine();
					break;
				}
				}
				if(noGiven.compareTo(input)==0)
				{
				validinput=false;
				}
			}
		}
		
		return input;
	}
	
	public static String isValidTime(String input)
	{
		Scanner sc= new Scanner(System.in);
		boolean validInput=true;
		int hour=(input.charAt(0)-'0')*10+(input.charAt(1)-'0');
		int minute=(input.charAt(3)-'0')*10+(input.charAt(4)-'0');
		while(validInput)
		{
			
			if(input.length()!=5)
			{
			
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(input.charAt(2)!=':')
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(hour<=0||hour>24)
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(minute<0||minute>59)
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
				
			else
			{
				validInput=false;
			}
			
			hour=(input.charAt(0)-'0')*10+(input.charAt(1)-'0');
			minute=(input.charAt(3)-'0')*10+(input.charAt(4)-'0');
		
		}
		return input;
	}
	
	public static String isValidExit(String input, String entryTime)
	{
		Scanner sc= new Scanner(System.in);
		boolean validInput=true;
		
		
		int entryHour=(entryTime.charAt(0)-'0')*10+(entryTime.charAt(1)-'0');
		int entryMinute=(entryTime.charAt(3)-'0')*10+(entryTime.charAt(4)-'0');
		int hour=(input.charAt(0)-'0')*10+(input.charAt(1)-'0');
		int minute=(input.charAt(3)-'0')*10+(input.charAt(4)-'0');
		while(validInput)
		{
			
			if(input.length()!=5)
			{
			
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(input.charAt(2)!=':')
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(hour<=0||hour>24)
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
			else if(minute<0||minute>59)
			{
				System.out.println(" The given time is not valid. Please try again");
				input=sc.nextLine();
			}
				
			else
			{
				if (entryHour>=hour&&entryMinute>=minute)
				{
					System.out.println(" The given time is not valid. Please try again");
					input=sc.nextLine();
				}
				else
				{
				validInput=false;
				}
			}
			
			hour=(input.charAt(0)-'0')*10+(input.charAt(1)-'0');
			minute=(input.charAt(3)-'0')*10+(input.charAt(4)-'0');
		
		}
		return input;
	}
	
	public static Parking[] parkingFeeDetails(Parking[] customers)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vehicle number of the car");
		String vehicleNumber=sc.nextLine();
		int car=0;
		boolean isPresent=false;
		for(int i=0;i<customers.length;i++)
		{
			if(customers[i]!=null)
			{
				if(vehicleNumber.compareTo(customers[i].getVehicleNumber())==0)
				{
					isPresent=true;
					System.out.println("The car is present in the lot");
					car=i;
					break;
				}
			}
			
		}
		if(isPresent==false)
		{
			System.out.println("The car is not present in the lot");
			return customers;
		}
		
		else
		{
			String entryTime=customers[car].getEntryTime();
			System.out.println("Enter the exit time of the car: ");
			String exitTimeGiven=sc.nextLine();
			String exitTime=isValidExit(exitTimeGiven,entryTime);
			int entryHour=(entryTime.charAt(0)-'0')*10+(entryTime.charAt(1)-'0');
			int entryMinute=(entryTime.charAt(3)-'0')*10+(entryTime.charAt(4)-'0');
			int hour=(exitTime.charAt(0)-'0')*10+(exitTime.charAt(1)-'0');
			int minute=(exitTime.charAt(3)-'0')*10+(exitTime.charAt(4)-'0');
			double parkingTime=0;
			if(entryHour==hour)
			{
				parkingTime=(minute-entryMinute)/60;
			}
			else
			{
				int hourDiff=hour-entryHour;
				int minuteDiff=(minute-entryMinute);
				if(minuteDiff<0)
				{
					hourDiff=hourDiff-1;
					minuteDiff=60-minuteDiff;
				}
				parkingTime=hourDiff+(minuteDiff/60);
			}
			if(parkingTime<2)
			{
				System.out.println("The parking fee is Rs. 50");
			}
			else
			{
				double parkingFee=50;
				double time=parkingTime-2;
				while(time>=0)
				{
					parkingFee=parkingFee+30;
					time=time-1;
				}
				System.out.println("The parking fee of the customer is "+parkingFee);
			}
			
			customers[car]=null;
			
			while((car+1)<customers.length && customers[car+1]!=null)
			{
				
				customers[car]=customers[car+1];
				car=car+1;
				
			
				
			}
			
			customers[car]=null;
			return customers;
			
		}
	}
}
