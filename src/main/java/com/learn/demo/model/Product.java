package com.learn.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
import javax.persistence.Table;

//import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;

//@Data
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Table(name="PRODUCT_INFO")
 	
public class Product implements Serializable {
	
	public Product() {
	}
	@Id// (name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_gen")
	@SequenceGenerator(name = "sequence_gen", sequenceName = "sequence", allocationSize = 1)
	//@Column(name="ID")
  private Long ID;
	@Column(name="NAME_product")
  private String _name;
	@Column(name="PRICE")
  private double _price;
	@Column(name="URL")
  private String _url;
	public Product(Long iD, String _name, double _price, String _url) {
		super();
		ID = iD;
		this._name = _name;
		this._price = _price;
		this._url = _url;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public double get_price() {
		return _price;
	}
	public void set_price(double _price) {
		this._price = _price;
	}
	public String get_url() {
		return _url;
	}
	public void set_url(String _url) {
		this._url = _url;
	}
	
	
//	public Product() {
//		_id=0L;
//		_name="";
//		_price=0;
//		_url="";
//	}
  
}











//
//
//public class Product implements Serializable {
//@Id// (name="id")
////@GeneratedValue(strategy = GenerationType.IDENTITY)
//
////@Column(name="ID")
//private Long ID;
//@Column(name="NAME_product")
//private String _name;
//@Column(name="PRICE")
//private double _price;
//@Column(name="URL")
//private String _url;
