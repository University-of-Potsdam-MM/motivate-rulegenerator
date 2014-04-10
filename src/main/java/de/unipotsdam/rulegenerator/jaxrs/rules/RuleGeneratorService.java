package de.unipotsdam.rulegenerator.jaxrs.rules;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LocalActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.objects.AdaptationRule;
import de.unipotsdam.rulegenerator.objects.Fact;
import de.unipotsdam.rulegenerator.objects.LocalAction;
import de.unipotsdam.rulegenerator.objects.Situation;
import de.unipotsdam.rulegenerator.objects.Trigger;

// TODO: Auto-generated Javadoc
/**
 * The Class RuleGeneratorService.
 */
public class RuleGeneratorService {

	/**
	 * Generate fake rule.
	 *
	 * @return the adaptation rule
	 */
	public AdaptationRule generateFakeRule() {
		AdaptationRule rule = new AdaptationRule("AR_1");
		// set triggering mode
		rule.setTriggeringMode(new Trigger(TriggeringMode.ON_ENTRY));
		// facts for the rule
		Fact firstFact = new Fact("CI_CURRENT_TEMPERATURE", FactOperator.IS,
				"20", LogicalOperator.OR);
		Fact secondFact = new Fact("CI_LOCATION_LATITUDE", FactOperator.IS,
				"52.23123", LogicalOperator.AND);
		secondFact.setLeftParanthesis(true);
		Fact thirdFact = new Fact("CI_LOCATION_LONGITUDE", FactOperator.IS,
				"13.23224", LogicalOperator.AND);
		Fact fourthFact = new Fact("CI_DISTANCE_FROM_TARGET_LOCATION",
				FactOperator.LESS_THEN, "100");
		fourthFact.setRightParanthesis(true);
		// add situation with facts
		rule.setSituation(new Situation(new Fact[] { firstFact, secondFact,
				thirdFact, fourthFact }));
		// set action
		rule.setAction(new LocalAction(LocalActionOperator.SHOW, "NG_123"));

		System.out.println(rule.description());

		return rule;
	}
}
