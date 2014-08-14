package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ConstraintTail;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultConstraintTail;

public class MyConstraintTail extends DefaultConstraintTail implements
		ConstraintTail {

	public MyConstraintTail(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Type

	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	public String getSpecificTailType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (!iriFragment.equals("ConstraintTail")
					&& iriFragment.contains("ConstraintTail"))
				return iriFragment;
		}

		return "NO_VALUE";
	}
	
	// ContextInformation
	
	public Boolean hasContextInformation() {
		return this.getContextInformationCount() > 0;
	}

	public Integer getContextInformationCount() {
		return this.getContextInformation().toArray().length;
	}
	
	public Collection<MyMeasurableContextInformation> getContextInformation() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
                Vocabulary.OBJECT_PROPERTY_HASCONTEXTTAILMEASURABLECONTEXTINFORMATION,
                MyMeasurableContextInformation.class);
	}
}
