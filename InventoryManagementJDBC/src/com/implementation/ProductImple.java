package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bean.Product;
import com.connect.DBConnectionInventory;
import com.dao.ProductDao;

public class ProductImple implements ProductDao{
	Scanner sc= new Scanner (System.in);
	Product pd= new Product();
	Connection conn=null;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public ProductImple() {
		conn=DBConnectionInventory.getConnect();
		try {
			st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int checkIsEmpty() {
		int count=0;
		try {
			rs=st.executeQuery("select count(*) from product");
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
		
	}
	@Override
	public void addProduct() {
		System.out.println("enter the number of Product you want add");
		int n=sc.nextInt();
		int m=0;
		try {
			pst=conn.prepareStatement("insert into product values(?,?,?,?)");
			for(int i=1;i<=n;i++) {
				System.out.println("enter the Product id");
				pd.setPid(sc.nextInt());
				pst.setInt(1,pd.getPid());
				System.out.println("enter the Product name");
				pd.setPname(sc.next());	
				pst.setString(2,pd.getPname());
				System.out.println("enter the category id");
				pd.setCid(sc.nextInt());
				pst.setInt(3,pd.getCid());
				System.out.println("enter the Product price");
				pd.setPrice(sc.nextInt());
				pst.setInt(4,pd.getPrice());
				m=pst.executeUpdate();
			}
			if(m>0) {
				System.out.println("Product Added");
			}else {
				System.out.println("Not Added");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteProduct() {
		if(checkIsEmpty()>0) {
			System.out.println("enter the Product id");
			int pid=sc.nextInt();
			boolean productID=false;
			try {
				rs=st.executeQuery("select * from product");
				while(rs.next()) {
					if(rs.getInt(1)==pid) {
						pst=conn.prepareStatement("delete from product where pid=?");
						pst.setInt(1, pid);
						if(pst.executeUpdate()>0) {
							System.out.println("Product Deleted...");
						}else {
							System.out.println("Not deleted");
						}
						productID=true;
						break;
					}
				}
				if(productID==false) {
					System.out.println("Wrong Product Id");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Product table is empty");
		}
	}

	@Override
	public void updateProduct() {
		if(checkIsEmpty()>0) {
			System.out.println("enter the Product id");
			int pid=sc.nextInt();
			String productID="Wrong Product Id";
			try {
				rs=st.executeQuery("select * from product");
				while(rs.next()) {
					if(rs.getInt(1)==pid) {
						pst=conn.prepareStatement("update product set price=? where pid=?");
						System.out.println("enter the new Product price");
						int price=sc.nextInt();
						pst.setInt(1, price);
						pst.setInt(2, pid);
						if(pst.executeUpdate()>0) {
							System.out.println("Product price updated...");
						}else {
							System.out.println("Not updated");
						}
						productID="correct";
						break;
					}
				}
				if(productID.contains("Wrong")) {
					System.out.println(productID);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Product table is empty");
		}
	
	}

	@Override
	public void getProductById() {
		if(checkIsEmpty()>0) {
			System.out.println("enter the Product id");
			int pid=sc.nextInt();
			boolean productID= false;
			try {
				rs=st.executeQuery("select * from product");
				while(rs.next()) {
					if(rs.getInt(1)==pid) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
						rs.getInt(3)+" "+rs.getInt(4));
						productID=true;
						break;
					}
					
				}
				if(productID==false) {
					System.out.println("Wrong Product Id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Product table is empty");
		}
	
	}

	@Override
	public void displayAllProduct() {
		if(checkIsEmpty()>0) {
			try {
				rs=st.executeQuery("select * from product");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
							rs.getInt(3)+" "+rs.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Product table is empty");
		}
	}
}
