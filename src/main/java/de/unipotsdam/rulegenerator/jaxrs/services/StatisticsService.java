package de.unipotsdam.rulegenerator.jaxrs.services;

import de.unipotsdam.rulegenerator.statistics.StatisticsFactory;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public class StatisticsService extends Service {
	
	static String aBoxOld = "";
	static StatisticsFactory statisticsFactory;
	
	public static String generateStatistics(String aBox, String ontologyId)
			throws Exception {
		
		if (!aBoxOld.equals(aBox)) {
			// load received ontology
			loadOntology(aBox);
			// infer
			inferOntology();
			// create rule factory
			statisticsFactory = new StatisticsFactory(ontology);
			
			aBoxOld = aBox;
		}
				
		// generate statistics
		StatisticsList statisticsList = statisticsFactory.generateStatistics();

		return null;
	}
}