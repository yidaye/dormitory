package com.yidaye.domitory.po;

public class Dorclean {

	private int id;           //自增id
	private String d_no;      //宿舍号
	private String b_no;      //楼栋号
	private String date;      //日期
	private String remark;    //备注
	private String sisuation; //卫生情况
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getD_no() {
		return d_no;
	}
	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getB_no() {
		return b_no;
	}
	public void setB_no(String b_no) {
		this.b_no = b_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSisuation() {
		return sisuation;
	}
	public void setSisuation(String sisuation) {
		this.sisuation = sisuation;
	}
	
	
	
}
