package kr.co.acorn.dto;

public class M_droneDto {
	private int m_d_no;
	private int d_no;
	private String reg_date;
	private int date_price;
	private String loc_no;
	private String start_date;
	private String end_date;
	
	
	public M_droneDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public M_droneDto(int m_d_no, int d_no, String reg_date, int date_price, String loc_no, String start_date,
			String end_date) {
		super();
		this.m_d_no = m_d_no;
		this.d_no = d_no;
		this.reg_date = reg_date;
		this.date_price = date_price;
		this.loc_no = loc_no;
		this.start_date = start_date;
		this.end_date = end_date;
	}


	public void setM_d_no(int m_d_no) {
		this.m_d_no = m_d_no;
	}
	public void setD_no(int d_no) {
		this.d_no = d_no;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setDate_price(int date_price) {
		this.date_price = date_price;
	}
	public void setLoc_no(String loc_no) {
		this.loc_no = loc_no;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getM_d_no() {
		return m_d_no;
	}
	public int getD_no() {
		return d_no;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getDate_price() {
		return date_price;
	}
	public String getLoc_no() {
		return loc_no;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	
	

}
