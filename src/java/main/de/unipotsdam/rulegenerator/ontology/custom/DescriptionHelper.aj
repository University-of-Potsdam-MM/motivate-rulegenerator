package de.unipotsdam.rulegenerator.ontology.custom;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

public aspect DescriptionHelper {
	pointcut showDescription(WrappedIndividualImpl individual, Integer indent,
			Boolean deep) : execution(void WrappedIndividualImpl.description(*)) && target(individual) && args(indent, deep);

	public String WrappedIndividualImpl.getIndentSpace(Integer indent) {
		return new String(new char[indent * 4]).replace('\0', ' ');
	}
}