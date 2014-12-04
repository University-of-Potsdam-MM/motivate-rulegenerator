package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.ontology.Action;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAction;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultSituation;

public class MyAction extends DefaultAction implements Action {
	public MyAction(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Situation
	
	public Boolean hasSituation() {
		return this.getSituationCount() > 0;
	}
	
	public Integer getSituationCount() {
		return this.getSituations().toArray().length;
	}
	
	public WrappedIndividualImpl getSituation() {
		return (WrappedIndividualImpl) this.getSituations().toArray()[0];
	}
	
	public Collection<? extends WrappedIndividualImpl> getSituations() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASSITUATION, DefaultSituation.class);
	}
}
