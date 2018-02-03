package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
private int pid;
	//This is a product name
	@Column(name="Product_NM")
private String pname;
private int pcost;

@ManyToOne
private Supplier suppier;

public Supplier getSuppier() {
	return suppier;
}
public void setSuppier(Supplier suppier) {
	this.suppier = suppier;
}
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
