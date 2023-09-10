package it.polito.tdp.gosales.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Arco {
	
	Integer r1;
	Integer r2;
	List<Integer> product = new ArrayList<Integer>();
	public Arco(Integer r1, Integer r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}
	@Override
	public String toString() {
		return "Arco [r1=" + r1 + ", r2=" + r2 + ", peso=" +"]";
	}
	public Integer getR1() {
		return r1;
	}
	public Integer getR2() {
		return r2;
	}
	public List<Integer> getProduct() {
		return product;
	}
	public void AddAllProduct(Set<Integer> product) {
		this.product.addAll(product);
	}
	

	

}
