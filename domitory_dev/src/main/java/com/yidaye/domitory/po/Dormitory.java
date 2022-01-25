package com.yidaye.domitory.po;

public class Dormitory {

	private int d_id;         //自增id
	private String d_no;      //宿舍号
	private String d_remark;   //备注
	private String d_pepole;  //宿舍人数
	private String d_relpepo; //入住人数
	private String b_no;      //楼栋号
	
	
	public String getD_remark() {
		return d_remark;
	}
	public void setD_remark(String d_remark) {
		this.d_remark = d_remark;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_no() {
		return d_no;
	}
	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getD_pepole() {
		return d_pepole;
	}
	public void setD_pepole(String d_pepole) {
		this.d_pepole = d_pepole;
	}
	public String getD_relpepo() {
		return d_relpepo;
	}
	public void setD_relpepo(String d_relpepo) {
		this.d_relpepo = d_relpepo;
	}
	public String getB_no() {
		return b_no;
	}
	public void setB_no(String b_no) {
		this.b_no = b_no;
	}

	
	
}
