package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ConstraintHead;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultConstraintHead;

public class MyConstraintHead extends DefaultConstraintHead implements
		ConstraintHead {

	public MyConstraintHead(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// IRI

	public String getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}

	// Type

	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	public String getSpecificConstraintType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (!iriFragment.equals("ConstraintHead")
					&& iriFragment.contains("ConstraintHead"))
				return iriFragment;
		}

		return "NO_VALUE";
	}

	// Tails

	public Boolean hasConstraintTail() {
		return this.getConstraintTailCount() > 0;
	}

	public Integer getConstraintTailCount() {
		return this.getConstraintTails().toArray().length;
	}

	public Collection<MyConstraintTail> getConstraintTails() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASCONSTRAINTTAIL,
				MyConstraintTail.class);
	}
}
