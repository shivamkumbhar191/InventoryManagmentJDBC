package com.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bean.Inventory;
import com.connect.DBConnectionInventory;
import com.dao.InventoryItemDao;

public class InventoryItemImple implements InventoryItemDao{
	Scanner sc= new Scanner (System.in);
	Inventory inv= new Inventory();
	Connection conn=null;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public InventoryItemImple() {
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
			rs=st.executeQuery("select count(*) from invitem");
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
		
	}
	@Override
	public void addInventoryItem() {
		System.out.println("enter the number of Inventory Item you want add");
		int n=sc.nextInt();
		int m=0;
		try {
			pst=conn.prepareStatement("insert into invitem values(?,?,?)");
			for(int i=1;i<=n;i++) {
				System.out.println("enter the Inventory Item id");
				inv.setIid(sc.nextInt());
				pst.setInt(1,inv.getIid());
				System.out.println("enter the Inventory Item quntity");
				inv.setQty(sc.nextInt());	
				pst.setInt(2,inv.getQty());
				System.out.println("enter the Product id");
				inv.setPid(sc.nextInt());
				pst.setInt(3,inv.getPid());
				m=pst.executeUpdate();
				
			}
			if(m>0) {
				System.out.println("Inventory Item Added");
			}else {
				System.out.println("Not Added");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteInventoryItem() {
		System.out.println("enter the Inventory Item id");
		int iid=sc.nextInt();
		boolean invID=false;
		try {
			rs=st.executeQuery("select * from invitem");
			while(rs.next()) {
				if(rs.getInt(1)==iid) {
					pst=conn.prepareStatement("delete from invitem where ivnid=?");
					pst.setInt(1, iid);
					if(pst.executeUpdate()>0) {
						System.out.println("Inventory Item Deleted...");
					}else {
						System.out.println("Not deleted");
					}
					invID=true;
					break;
				}
			}
			if(invID==false) {
				System.out.println("Wrong Inventory Item Id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateInventoryItem() {
		System.out.println("enter the Inventory Item id");
		int iid=sc.nextInt();
		String invID="Wrong Inventory Item Id";
		try {
			rs=st.executeQuery("select * from invitem");
			while(rs.next()) {
				if(rs.getInt(1)==iid) {
					pst=conn.prepareStatement("update invitem set qty=? where ivnid=?");
					System.out.println("enter the new Inventory Item Quntity");
					int qty=sc.nextInt();
					pst.setInt(1, qty);
					pst.setInt(2, iid);
					if(pst.executeUpdate()>0) {
						System.out.println("Inventory Item type updated...");
					}else {
						System.out.println("Not updated");
					}
					invID="correct";
					break;
				}
			}
			if(invID.contains("Wrong")) {
				System.out.println(invID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void getInventoryItemById() {
		System.out.println("enter the Inventory Item id");
		int iid=sc.nextInt();
		boolean invID= false;
		try {
			rs=st.executeQuery("select * from invitem");
			while(rs.next()) {
				if(rs.getInt(1)==iid) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
					invID=true;
					break;
				}
				
			}
			if(invID==false) {
				System.out.println("Wrong Inventory Item Id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void displayAllInventoryItem() {
		try {
			rs=st.executeQuery("select * from invitem");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
