package com.app;

import java.util.Scanner;

public class InventoryApp {

	public static void main(String[] args) {
		char ch = ' ';
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("----------------------------------------------------");
			System.out.println("-------------Inventory Management System----------------");
			System.out.println("----------------------------------------------------");
			System.out.println("1. Customer Panel");
			System.out.println("2. Product Panel");
			System.out.println("3. Inventory Item Panel");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			int c= sc.nextInt();
			switch(c)
			{
			case 1: CategoryPanel.main(null);
			        break;
			case 2: ProductPanel.main(null);
	        		break;
			case 3: InventoryItemPanel.main(null);
			        break;
			case 4: System.exit(0);
	        break;
			default: System.out.println("Invalid in input");
			System.out.println("---------------------------");
			System.out.println("do you want to continue");
			ch= sc.next().charAt(0);
			}	
		}
		while(ch=='Y' || ch=='y');
		sc.close();

	}

}
