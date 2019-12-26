package kr.co.acorn.dto;

public class DronDto {
	private int no;
	private String dname;
	private String dprice;
	private String dland;
	public DronDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DronDto(int no, String dname, String dprice, String dland) {
		super();
		this.no = no;
		this.dname = dname;
		this.dprice = dprice;
		this.dland = dland;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * @return the dprice
	 */
	public String getDprice() {
		return dprice;
	}
	/**
	 * @param dprice the dprice to set
	 */
	public void setDprice(String dprice) {
		this.dprice = dprice;
	}
	/**
	 * @return the dland
	 */
	public String getDland() {
		return dland;
	}
	/**
	 * @param dland the dland to set
	 */
	public void setDland(String dland) {
		this.dland = dland;
	}
	
}
