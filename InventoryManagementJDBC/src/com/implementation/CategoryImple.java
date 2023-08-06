package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bean.Category;
import com.connect.DBConnectionInventory;
import com.dao.CategoryDao;

public class CategoryImple implements CategoryDao{
	Scanner sc= new Scanner (System.in);
	Category cg= new Category();
	Connection conn=null;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public CategoryImple() {
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
			rs=st.executeQuery("select count(*) from category");
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
		
	}
	@Override
	public void addCategory() {
		System.out.println("enter the number of Category you want add");
		int n=sc.nextInt();
		int m=0;
		try {
			pst=conn.prepareStatement("insert into category values(?,?)");
			for(int i=1;i<=n;i++) {
				System.out.println("enter the category id");
				cg.setCid(sc.nextInt());
				pst.setInt(1,cg.getCid());
				System.out.println("enter the category type");
				cg.setCtype(sc.next());	
				pst.setString(2,cg.getCtype());
				m=pst.executeUpdate();
				
			}
			if(m>0) {
				System.out.println("Category Added");
			}else {
				System.out.println("Not Added");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteCategory() {
		System.out.println("enter the category id");
		int cid=sc.nextInt();
		boolean catID=false;
		try {
			rs=st.executeQuery("select * from category");
			while(rs.next()) {
				if(rs.getInt(1)==cid) {
					pst=conn.prepareStatement("delete from category where cid=?");
					pst.setInt(1, cid);
					if(pst.executeUpdate()>0) {
						System.out.println("Category Deleted...");
					}else {
						System.out.println("Not deleted");
					}
					catID=true;
					break;
				}
			}
			if(catID==false) {
				System.out.println("Wrong category Id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCategory() {
		System.out.println("enter the category id");
		int cid=sc.nextInt();
		String catId="Wrong category Id";
		try {
			rs=st.executeQuery("select * from category");
			while(rs.next()) {
				if(rs.getInt(1)==cid) {
					pst=conn.prepareStatement("update category set ctype=? where cid=?");
					System.out.println("enter the new category type");
					String ctype=sc.next();
					pst.setString(1, ctype);
					pst.setInt(2, cid);
					if(pst.executeUpdate()>0) {
						System.out.println("category type updated...");
					}else {
						System.out.println("Not updated");
					}
					catId="correct";
					break;
				}
			}
			if(catId.contains("Wrong")) {
				System.out.println(catId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void getCategoryById() {
		System.out.println("enter the category id");
		int cid=sc.nextInt();
		boolean catId= false;
		try {
			rs=st.executeQuery("select * from category");
			while(rs.next()) {
				if(rs.getInt(1)==cid) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
					catId=true;
					break;
				}
				
			}
			if(catId==false) {
				System.out.println("Wrong category Id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void displayAllCategory() {
		try {
			rs=st.executeQuery("select * from category");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
