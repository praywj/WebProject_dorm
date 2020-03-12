package com.entity;

public class Search {
	private String dat;
	private String sno;
	private String name;
	private String tno;
	private String dno;
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	@Override
	public String toString() {
		return "Search [dat=" + dat + ", sno=" + sno + ", name=" + name + ", tno=" + tno + ", dno=" + dno + "]";
	}
	
}
