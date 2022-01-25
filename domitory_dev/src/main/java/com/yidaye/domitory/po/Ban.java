package com.yidaye.domitory.po;

public class Ban {

	
	
	private int b_id;          //自增id
	private String b_no;       //楼栋号
	private String b_sex;      //楼栋类型
	private String b_pepole;   //楼栋人数
	private String b_hight;    //楼层
	private String b_hight_dor;//每层宿舍数
	private String d_pepole;   //宿舍人数
	private String b_remark;   //备注
	private String b_money;    //费用
	private String b_relpepo;  //入住人数
	
	
	
	public String getB_relpepo() {
		return b_relpepo;
	}
	public void setB_relpepo(String b_relpepo) {
		this.b_relpepo = b_relpepo;
	}
	public String getB_hight_dor() {
		return b_hight_dor;
	}
	public void setB_hight_dor(String b_hight_dor) {
		this.b_hight_dor = b_hight_dor;
	}
	public String getD_pepole() {
		return d_pepole;
	}
	public void setD_pepole(String d_pepole) {
		this.d_pepole = d_pepole;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_no() {
		return b_no;
	}
	public void setB_no(String b_no) {
		this.b_no = b_no;
	}
	public String getB_sex() {
		return b_sex;
	}
	public void setB_sex(String b_sex) {
		this.b_sex = b_sex;
	}
	public String getB_pepole() {
		return b_pepole;
	}
	public void setB_pepole(String b_pepole) {
		this.b_pepole = b_pepole;
	}
	public String getB_hight() {
		return b_hight;
	}
	public void setB_hight(String b_hight) {
		this.b_hight = b_hight;
	}
	public String getB_remark() {
		return b_remark;
	}
	public void setB_remark(String b_remark) {
		this.b_remark = b_remark;
	}
	public String getB_money() {
		return b_money;
	}
	public void setB_money(String b_money) {
		this.b_money = b_money;
	}
	
	
}
