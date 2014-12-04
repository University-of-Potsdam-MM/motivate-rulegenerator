package de.unipotsdam.rulegenerator.jaxrs.services;

import de.unipotsdam.rulegenerator.statistics.StatisticsFactory;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public class StatisticsService extends Service {
	public static String generateStatistics(String aBox, String ontologyId)
			throws Exception {
		// load received ontology
		loadOntology(aBox);
		// infer
		inferOntology();
		// create rule factory
		StatisticsFactory statisticsFactory = new StatisticsFactory(ontology);
		// generate statistics
		StatisticsList statisticsList = statisticsFactory.generateStatistics();

		return null;
	}
}