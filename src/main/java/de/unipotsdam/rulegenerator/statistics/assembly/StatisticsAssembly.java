package de.unipotsdam.rulegenerator.statistics.assembly;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public abstract class StatisticsAssembly {
	public OWLOntology ontology;
	public StatisticsList reasons = new StatisticsList();
	
	public StatisticsList generateStatistics() throws Exception {
		return reasons;
	}
}
