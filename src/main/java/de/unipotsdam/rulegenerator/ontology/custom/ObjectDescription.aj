package de.unipotsdam.rulegenerator.ontology.custom;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

public aspect ObjectDescription {
	pointcut showDescription(WrappedIndividualImpl individual, Integer indent,
			Boolean deep) : call(void *.description(Integer, Boolean)) && target(individual) && args(indent, deep);

	public String WrappedIndividualImpl.getIndentSpace(Integer indent) {
		return new String(new char[indent * 4]).replace('\0', ' ');
	}

	before(WrappedIndividualImpl individual, Integer indent, Boolean deep): showDescription(individual, indent, deep) {
		System.out.println(individual.getIndentSpace(indent)+"<"+individual.getClass().getSimpleName().substring(2)+">");
	}

	after(WrappedIndividualImpl individual, Integer indent, Boolean deep): showDescription(individual, indent, deep) {
		System.out.println(individual.getIndentSpace(indent)+"</"+individual.getClass().getSimpleName().substring(2)+">");
	}
}