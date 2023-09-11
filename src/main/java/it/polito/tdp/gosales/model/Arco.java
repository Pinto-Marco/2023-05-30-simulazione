package it.polito.tdp.gosales.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Arco implements Comparable<Arco>{
	
	Integer r1;
	Integer r2;
	Integer peso;
	List<Integer> product = new ArrayList<Integer>();
	public Arco(Integer r1, Integer r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Arco [r1=" + r1 + ", r2=" + r2 + ", peso=" + peso +"]";
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
	@Override
	public int compareTo(Arco o) {
		// TODO Auto-generated method stub
		return this.peso.compareTo(o.getPeso());
	}
	

	

}
