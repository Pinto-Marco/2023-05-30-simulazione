package it.polito.tdp.gosales.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.gosales.dao.GOsalesDAO;



public class Model {
	
	GOsalesDAO dao= new GOsalesDAO();
	List<Retailers> allRetailers;
	List<Retailers> retailers;
	List<Arco> archi;
	private Graph<Retailers, DefaultWeightedEdge> graph;
	HashMap<Integer, Retailers> retailersMap;
	
	
	
	public Model() {
		this.allRetailers=new ArrayList<Retailers>();
		this.allRetailers.addAll(this.dao.getAllRetailers());
		this.retailers=new ArrayList<Retailers>();
		this.archi=new ArrayList<Arco>();
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.retailersMap=new HashMap<Integer, Retailers>();
	}

	public List<Integer> getAnni() {
		// TODO Auto-generated method stub
		List<Integer> anni=new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			anni.add(2015+i);
		}
		return anni;
	}

	public List<String> getNazioni() {
		// TODO Auto-generated method stub
		List<String> nazioni=new ArrayList<String>();
		Set<String> nazioniSet=new HashSet<String>();
		for(Retailers r : this.allRetailers) {
			nazioniSet.add(r.getCountry());
		}
		for(String n : nazioniSet) {
			nazioni.add(n);
		}
		
		Collections.sort(nazioni);
		return nazioni;
	}

	public Boolean creaGrafo(Integer anno, String nazione, Integer inputNum) {
		
		this.retailers=this.getRetailers(nazione);
    	if (this.graph.vertexSet().size()==0) {

    		Graphs.addAllVertices(this.graph, retailers);
		
		
    		archi = this.dao.getAllArchi(this.retailersMap, anno, inputNum);
		
			for (Arco a : this.archi)
				Graphs.addEdgeWithVertices(this.graph,
						this.retailersMap.get(a.getR1()), this.retailersMap.get(a.getR2()),
						Double.parseDouble(String.valueOf(a.getPeso())));
    	}
		
		return null;
		// TODO Auto-generated method stub
		
	}


	private List<Retailers> getRetailers(String nazione) {
		List<Retailers> ritorno=new ArrayList<Retailers>();
		for(Retailers r: this.allRetailers) {
			if(r.getCountry().compareTo(nazione)==0) {
				ritorno.add(r);
				this.retailersMap.put(r.getCode(), r);
			}
				
		}
		// TODO Auto-generated method stub
		return ritorno;
	}

	public List<String> getVertici() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Arco> getArchi() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getComponenteConnessa(String rivenditore) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getSommaComponenteConnessa(String rivenditore) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
