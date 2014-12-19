package de.unipotsdam.rulegenerator.statistics;

import java.util.ArrayList;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.statistics.assembly.CancelActionStatisticsAssembly;
import de.unipotsdam.rulegenerator.statistics.assembly.StatisticsAssembly;

public class StatisticsFactory {
	private OWLOntology ontology;
	private ArrayList<StatisticsAssembly> statisticsAssemblies = new ArrayList<StatisticsAssembly>();

	public StatisticsFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		this.statisticsAssemblies.add(new CancelActionStatisticsAssembly(ontology));
	}
	
	public StatisticsList generateStatistics(String query) throws Exception {
		StatisticsList statistics = new StatisticsList();
		
		for (StatisticsAssembly statisticsAssembly : this.statisticsAssemblies) {
			statistics.addReasons(statisticsAssembly.generateStatistics(query).getList());
		}

		return statistics;
	}
}
