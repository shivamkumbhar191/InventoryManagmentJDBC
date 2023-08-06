package com.app;

import java.util.Scanner;

import com.implementation.InventoryItemImple;

public class InventoryItemPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		InventoryItemImple im=new InventoryItemImple();
		String msg="Inventory Item table is empty";
		char ch=' ';
		do {
			System.out.println("-------------Inventory Item Panel-------------------");
			System.out.println("1. Add Inventory Item");
			System.out.println("2. Delete Inventory Item");
			System.out.println("3. Update Inventory Item quntity");
			System.out.println("4. Display all Inventory Items");
			System.out.println("5. Search Inventory Item by id");
			System.out.println("6. Exit Inventory Item Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:im.addInventoryItem();
			break;
			case 2:
				if(im.checkIsEmpty()>0) {
					im.deleteInventoryItem();
				}else {
					System.out.println(msg);
				}	
			break;
			case 3:
				if(im.checkIsEmpty()>0) {
					im.updateInventoryItem();
				}else {
					System.out.println(msg);
				}
			break;
			case 4:
				if(im.checkIsEmpty()>0) {
					im.displayAllInventoryItem();
				}else {
					System.out.println(msg);
				}
			break;
			case 5:
				if(im.checkIsEmpty()>0) {
					im.getInventoryItemById();
				}else {
					System.out.println(msg);
				}	
			break;
			case 6 : InventoryApp.main(null);
	        break;
			default :System.out.println("Invalid choice");
			}
			System.out.println("---------------------------");
			System.out.println("do you want to continue");
			ch= sc.next().charAt(0);
		}while(ch=='Y' || ch=='y');
		sc.close();
	}

}

