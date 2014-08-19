package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Set;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.OWLClassExpression;

public aspect WrappedIndividualAspects {
	public Set<OWLClassExpression> WrappedIndividualImpl.getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}
	
	public String WrappedIndividualImpl.getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}
}
