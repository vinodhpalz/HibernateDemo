package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
private int pid;
	//This is a product name
private String pname;
private int pcost;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPcost() {
	return pcost;
}
public void setPcost(int pcost) {
	this.pcost = pcost;
}



}
