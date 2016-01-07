package de.unipotsdam.rulegenerator.jaxrs.services;

import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.RuleFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

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
	public static AdaptationRuleList generateAdaptationRules(String aBox, String ontologyId) throws Exception {
		// load received ontology
		loadOntology(aBox);
		// infer
		inferOntology();
		// create rule factory
		RuleFactory ruleFactory = new RuleFactory(ontology);
		// generate and return rules
		return ruleFactory.generateRules();
	}

	public static String XMLFromAdaptationRules(AdaptationRuleList adaptationRuleList) {
		String xml;
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext context = JAXBContext
					.newInstance(AdaptationRuleList.class);
			Marshaller carMarshaller = context.createMarshaller();
			carMarshaller.marshal(adaptationRuleList, stringWriter);
			xml = stringWriter.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		return xml;
	}
}
