package de.unipotsdam.rulegenerator.jaxrs.services;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

import de.unipotsdam.rulegenerator.enums.EnumUtils;
import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LocalActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.rules.AdaptationRule;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.Fact;
import de.unipotsdam.rulegenerator.rules.LocalAction;
import de.unipotsdam.rulegenerator.rules.Situation;
import de.unipotsdam.rulegenerator.rules.Trigger;

// TODO: Auto-generated Javadoc
/**
 * The Class RuleGeneratorService.
 */
public class RuleGeneratorService {

	/**
	 * Generate fake rule.
	 * 
	 * @param index
	 *            the index
	 * @return the adaptation rule
	 */
	public static AdaptationRule generateFakeRule(Integer index) {
		SecureRandom rand = new SecureRandom();
		AdaptationRule rule = new AdaptationRule("AR_" + index);
		// set triggering mode
		rule.setTrigger(new Trigger(EnumUtils.randomEnum(TriggeringMode.class)));
		// facts for the rule
		ArrayList<Fact> facts = new ArrayList<Fact>();
		for (int i = 0; i < rand.nextInt((5 - 1) + 1) + 1; i++) {
			Fact newFact = new Fact("CI_FAKE_INFORMATION",
					EnumUtils.randomEnum(FactOperator.class),
					String.valueOf(rand.nextInt((100 - 1) + 1) + 1),
					EnumUtils.randomEnum(LogicalOperator.class));
			facts.add(newFact);
		}
		// add situation with facts
		rule.setSituation(new Situation(EnumUtils
				.randomEnum(LogicalOperator.class), facts));
		// set action
		rule.setAction(new LocalAction(LocalActionOperator.SHOW, "NG_123"));

		return rule;
	}

	/**
	 * Generate adaptation rules.
	 * 
	 * @return the adaptation rule list
	 */
	public static AdaptationRuleList generateAdaptationRules() {
		AdaptationRule rule = RuleGeneratorService.generateFakeRule(1);
		AdaptationRule rule2 = RuleGeneratorService.generateFakeRule(2);

		AdaptationRuleList adaptationRuleList = new AdaptationRuleList();
		adaptationRuleList.setList(new ArrayList<AdaptationRule>(Arrays.asList(
				rule, rule2)));

		return adaptationRuleList;
	}
}
