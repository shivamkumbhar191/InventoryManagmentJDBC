package com.bean;

public class Inventory {
	private int iid;
	private int qty;
	private int pid;
	
	public Inventory() {
		super();
	}
	public Inventory(int iid, int qty, int pid) {
		super();
		this.iid = iid;
		this.qty = qty;
		this.pid = pid;
	}	
	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Inventory [iid=" + iid + ", qty=" + qty + ", pid=" + pid + "]";
	}
	
}
