package com.app;

import java.util.Scanner;

import com.implementation.CategoryImple;

public class CategoryPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		CategoryImple cm=new CategoryImple();
		String msg="Category table is empty";
		char ch=' ';
		do {
			System.out.println("-------------Category Panel-------------------");
			System.out.println("1. Add Category");
			System.out.println("2. Delete Category");
			System.out.println("3. Update Category type");
			System.out.println("4. Display all Category");
			System.out.println("5. Search Category by id");
			System.out.println("6. Exit Category Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:cm.addCategory();
			break;
			case 2:
				if(cm.checkIsEmpty()>0) {
					cm.deleteCategory();
				}else {
					System.out.println(msg);
				}
			break;
			case 3:
				if(cm.checkIsEmpty()>0) {
					cm.updateCategory();
				}else {
					System.out.println(msg);
				}
			break;
			case 4:
				if(cm.checkIsEmpty()>0) {
					cm.displayAllCategory();
				}else {
					System.out.println(msg);
				}
			break;
			case 5:
				if(cm.checkIsEmpty()>0) {
					cm.getCategoryById();
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

