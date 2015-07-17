package de.unipotsdam.rulegenerator.jaxrs.services;

import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.RuleFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class RuleGeneratorService.
 */
public class RuleGeneratorService extends Service {
	/**
	 * Generate adaptation rules.
	 * 
	 * @return the adaptation rule list
	 * @throws Exception
	 */
	public static AdaptationRuleList generateAdaptationRules(String aBox,
			String ontologyId) throws Exception {
		// load received ontology
		loadOntology(aBox);
		// infer
		inferOntology();
		// create rule factory
		RuleFactory ruleFactory = new RuleFactory(ontology);
		// generate rules
		AdaptationRuleList adaptationRuleList = ruleFactory.generateRules();

		return adaptationRuleList;
	}
}
