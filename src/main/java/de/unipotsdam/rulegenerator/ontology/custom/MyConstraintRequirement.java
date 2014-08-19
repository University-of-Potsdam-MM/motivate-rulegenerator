package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultConstraintRequirement;

public class MyConstraintRequirement extends DefaultConstraintRequirement implements
		ConstraintRequirement {

	public MyConstraintRequirement(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Type

	public String getSpecificTailType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (!iriFragment.equals("ConstraintRequirement")
					&& iriFragment.contains("ConstraintRequirement"))
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

	public Collection<? extends MyMeasurableContextInformation> getContextInformation() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASMEASURABLECONTEXTINFORMATION,
				MyMeasurableContextInformation.class);
	}

	// Starting Time

	public String getStartTime() {
		if (this.hasHasStartingTime()) {
			return getDelegate().getPropertyValues(getOwlIndividual(),
					Vocabulary.DATA_PROPERTY_HASSTARTINGTIME, Object.class).toArray()[0].toString();
		} else {
			return null;
		}
	}
	
	// End Time

	public String getEndTime() {
		if (this.hasHasEndTime()) {
			return getDelegate().getPropertyValues(getOwlIndividual(),
					Vocabulary.DATA_PROPERTY_HASENDTIME, Object.class).toArray()[0].toString();
		} else {
			return null;
		}
	}
}
