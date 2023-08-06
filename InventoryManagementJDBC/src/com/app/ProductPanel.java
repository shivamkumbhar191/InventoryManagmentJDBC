package com.app;

import java.util.Scanner;

import com.implementation.ProductImple;

public class ProductPanel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ProductImple pi=new ProductImple();
		char ch=' ';
		do {
			System.out.println("-------------Product Panel-------------------");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product Price");
			System.out.println("4. Display all Products");
			System.out.println("5. Search Product by id");
			System.out.println("6. Exit Product Panel");
			System.out.println("enter the choice");
			int c=sc.nextInt();
			switch(c) {
			case 1:pi.addProduct();
			break;
			case 2:pi.deleteProduct();
			break;
			case 3:pi.updateProduct();
			break;
			case 4:pi.displayAllProduct();
			break;
			case 5:pi.getProductById();
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

