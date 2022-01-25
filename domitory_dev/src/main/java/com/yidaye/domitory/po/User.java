package com.yidaye.domitory.po;

public class User {

  private int u_id;//用户自增id
  private String u_no;//学号
  private String u_pass;//密码
  private String u_name;//姓名
  private String u_coll;//学院
  private String u_gra;//年级
  private String u_class;//班级
  private String u_sub;//专业
  private String u_phone;//联系电话
  private String u_sex;//性别
  private String b_no;//楼栋号
  private String d_no;//宿舍号
  private String bed_no;//
  

public String getBed_no() {
	return bed_no;
}
public void setBed_no(String bed_no) {
	this.bed_no = bed_no;
}
public String getB_no() {
	return b_no;
}
public void setB_no(String b_no) {
	this.b_no = b_no;
}
public String getD_no() {
	return d_no;
}
public void setD_no(String d_no) {
	this.d_no = d_no;
}
public String getU_sex() {
	return u_sex;
}
public void setU_sex(String u_sex) {
	this.u_sex = u_sex;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getU_no() {
	return u_no;
}
public void setU_no(String u_no) {
	this.u_no = u_no;
}
public String getU_pass() {
	return u_pass;
}
public void setU_pass(String u_pass) {
	this.u_pass = u_pass;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_coll() {
	return u_coll;
}
public void setU_coll(String u_coll) {
	this.u_coll = u_coll;
}
public String getU_gra() {
	return u_gra;
}
public void setU_gra(String u_gra) {
	this.u_gra = u_gra;
}
public String getU_class() {
	return u_class;
}
public void setU_class(String u_class) {
	this.u_class = u_class;
}
public String getU_sub() {
	return u_sub;
}
public void setU_sub(String u_sub) {
	this.u_sub = u_sub;
}
public String getU_phone() {
	return u_phone;
}
public void setU_phone(String u_phone) {
	this.u_phone = u_phone;
}
@Override
public String toString() {
	return "User [u_id=" + u_id + ", u_no=" + u_no + ", u_pass=" + u_pass + ", u_name=" + u_name + ", u_coll=" + u_coll
			+ ", u_gra=" + u_gra + ", u_class=" + u_class + ", u_sub=" + u_sub + ", u_phone=" + u_phone + ", u_sex="
			+ u_sex + ", b_no=" + b_no + ", d_no=" + d_no + ", bed_no=" + bed_no + "]";
}
  
  
}
