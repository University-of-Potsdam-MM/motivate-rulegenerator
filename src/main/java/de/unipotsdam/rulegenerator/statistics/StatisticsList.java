package de.unipotsdam.rulegenerator.statistics;

import java.util.ArrayList;
import java.util.List;

import org.semanticweb.owlapi.model.OWLOntology;

public class StatisticsList {
	public OWLOntology ontology;
	private List<Reason> list = new ArrayList<Reason>();
	
	public List<Reason> getList() {
		return list;
	}
	
	public void setList(List<Reason> list) {
		this.list = list;
	}
	
	public void addReason(Reason reason) {
		this.list.add(reason);
	}
	
	public void addReasons(List<Reason> reasons) {
		for (Reason reason : reasons) {
			this.addReason(reason);
		}
	}
}
