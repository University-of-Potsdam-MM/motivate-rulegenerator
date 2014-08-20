package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnit;
import de.unipotsdam.rulegenerator.rules.Fact;
import de.unipotsdam.rulegenerator.rules.FactSet;

public class MyLearningUnit extends DefaultLearningUnit implements LearningUnit {
	public MyLearningUnit(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	public void description() {
		this.description(0, true);
	}

	public void description(Integer indent) {
		this.description(indent, true);
	}

	public void description(Integer indent, Boolean deep) {
		System.out.println(this.getIndentSpace(indent + 1) + "<IRI>"
				+ this.getIRIShort() + "</IRI>");
		System.out.println(this.getIndentSpace(indent + 1) + "<LID>"
				+ this.getID() + "</LID>");
		if (deep) {
			System.out.println(this.getIndentSpace(indent + 1)
					+ "<LogicalOperator>" + this.getLogicalOperator()
					+ "</LogicalOperator>");
			if (this.hasContextInformation()) {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<ContextInformation>");
				for (MyMeasurableContextInformation contextInformation : this
						.getContextInformation()) {
					contextInformation.description(indent + 2);
				}
				System.out.println(this.getIndentSpace(indent + 1)
						+ "</ContextInformation>");
			} else {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<ContextInformation/>");
			}
			if (this.hasRelations()) {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<Relations>");
				if (this.hasAlternatives()) {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Alternatives>");
					for (WrappedIndividual alternative : this.getAlternatives()) {
						MyLearningUnit learningUnit = (MyLearningUnit) alternative;
						learningUnit.description(indent + 3, false);
					}
					System.out.println(this.getIndentSpace(indent + 2)
							+ "</Alternatives>");
				} else {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Alternatives/>");
				}
				if (this.hasPrerequisites()) {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Prerequisites>");
					for (WrappedIndividual prerequisite : this
							.getPrerequisites()) {
						MyLearningUnit learningUnit = (MyLearningUnit) prerequisite;
						learningUnit.description(indent + 3, false);
					}
					System.out.println(this.getIndentSpace(indent + 2)
							+ "</Prerequisites>");
				} else {
					System.out.println(this.getIndentSpace(indent + 2)
							+ "<Prerequisites/>");
				}
				System.out.println(this.getIndentSpace(indent + 1)
						+ "</Relations>");
			} else {
				System.out.println(this.getIndentSpace(indent + 1)
						+ "<Relations/>");
			}
		}
	}

	// ID

	public String getID() {
		Object[] ids = this.getHasLID().toArray();
		if (ids.length > 0)
			return (String) ids[0];
		else
			return "NO_VALUE";
	}

	// Logical Operator

	public LogicalOperator getLogicalOperator() {
		if (this.getLogicalOperators().toArray().length > 0)
			return LogicalOperator.valueOf(getLogicalOperators().toArray()[0]
					.toString());
		else
			return LogicalOperator.NO_VALUE;
	}

	public Collection<? extends Object> getLogicalOperators() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASLOGICALOPERATOR, Object.class);
	}

	// Context Information

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

	// Relations

	public Boolean hasRelations() {
		return this.hasAlternatives() || this.hasPrerequisites()
				|| this.hasHelp() || this.hasVersions() || this.hasBases()
				|| this.hasReferences() || this.hasExtensions();
	}

	// Alternatives

	public Boolean hasAlternatives() {
		return this.getAlternativesCount() > 0;
	}

	public Integer getAlternativesCount() {
		return this.getAlternatives().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getAlternatives() {
		return getDelegate()
				.getPropertyValues(getOwlIndividual(),
						Vocabulary.OBJECT_PROPERTY_HASALTERNATIVE,
						MyLearningUnit.class);
	}

	// Prerequisite

	public Boolean hasPrerequisites() {
		return this.getPrerequisiteCount() > 0;
	}

	public Integer getPrerequisiteCount() {
		return this.getPrerequisites().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getPrerequisites() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASPREREQUISITE,
				MyLearningUnit.class);
	}

	// Help

	public boolean hasHelp() {
		return this.getHelpCount() > 0;
	}

	public Integer getHelpCount() {
		return this.getHelp().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getHelp() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASHELP, MyLearningUnit.class);
	}

	// Version

	public boolean hasVersions() {
		return this.getVersionsCount() > 0;
	}

	public Integer getVersionsCount() {
		return this.getVersions().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getVersions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASVERSION, MyLearningUnit.class);
	}

	// Bases

	public boolean hasBases() {
		return this.getBasesCount() > 0;
	}

	public Integer getBasesCount() {
		return this.getBases().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getBases() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASBASIS, MyLearningUnit.class);
	}

	// References

	public boolean hasReferences() {
		return this.getReferencesCount() > 0;
	}

	public Integer getReferencesCount() {
		return this.getReferences().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getReferences() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASREFERENCE, MyLearningUnit.class);
	}

	// Extensions

	public boolean hasExtensions() {
		return this.getExtensionsCount() > 0;
	}

	public Integer getExtensionsCount() {
		return this.getExtensions().toArray().length;
	}

	public Collection<? extends WrappedIndividual> getExtensions() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASEXTENSION, MyLearningUnit.class);
	}

	// Facts

	public FactSet getFacts() throws Exception {
		FactSet learningUnitFacts = new FactSet();
		// create facts for the context information associated to the learning
		// unit
		int i = 0;
		for (MyMeasurableContextInformation contextInformation : this
				.getContextInformation()) {
			Fact learningUnitFact = Fact.FactFromContextInformation(contextInformation);
			learningUnitFacts.addFact(learningUnitFact);
			if (i < this.getContextInformationCount() - 1)
				learningUnitFacts.addLogicalOperator(this.getLogicalOperator());
			i++;
		}
		return learningUnitFacts;
	}

	// Learning Unit Class

	public Boolean hasLearningUnitClass() {
		return this.getLearningUnitClasses().toArray().length > 0;
	}

	public MyLearningUnitClass getLearningUnitClass() {
		if (this.hasLearningUnitClass())
			return (MyLearningUnitClass) getLearningUnitClasses().toArray()[0];
		else
			return null;
	}

	public Collection<? extends MyLearningUnitClass> getLearningUnitClasses() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASLEARNINGUNITCLASS,
				MyLearningUnitClass.class);
	}
}