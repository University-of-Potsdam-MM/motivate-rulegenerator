package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import com.hp.hpl.jena.rdf.model.RDFNode;
import org.semanticweb.owlapi.model.OWLOntology;

import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

import javax.annotation.Resource;

public abstract class ActionStatisticsAssembly extends StatisticsAssembly {
	protected Collection<? extends MyLearningUnit> learningUnits;
	protected String action;
	protected RDFNode recTime, user, actTime, recContext, lu, metaDataProp, metaDataValue;

	protected String getFirstQuery() throws Exception {
		if (action == null)
			throw new Exception("Action is not defined.");

		return ""
				+ "PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
				+ "PREFIX rdfs: <"
				+ RDFS.getURI()
				+ "> "
				+ "PREFIX owl: <"
				+ OWL.getURI()
				+ "> "
				+ "SELECT ?user ?actTime (max(?rt) as ?recTime) WHERE {"
				+ "?recContext "
				+ "	a kno:RecordedContextInformation ; "
				+ "	kno:hasTimestamp ?rt ; "
				+ "	kno:isRecordedContextInformationOf ?user . "
				+ "?user "
				+ "	a kno:User ; "
				+ "	kno:hasAction "
				+ action
				+ " . "
				+ action
				+ "	kno:referencesLearningUnit ?lu ;"
				+ "	kno:hasTimestamp ?actTime ."
				+ "?metaDataProp rdfs:subPropertyOf kno:hasMetaData ."
				+ "?lu ?metaDataProp ?metaDataValue ."
				+ "FILTER (?rt <= ?actTime) "
				+ "}"
				+ "GROUP BY ?user ?actTime"
				;
	}

	protected String getSecondQuery() throws Exception {
		if (user == null)
			throw new Exception("User is not defined.");
		if (action == null)
			throw new Exception("Action is not defined.");
		if (recTime == null)
			throw new Exception("RecTime is not defined.");
		if (actTime == null)
			throw new Exception("ActTime is not defined.");

		return ""
				+ "PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
				+ "PREFIX rdfs: <"
				+ RDFS.getURI()
				+ "> "
				+ "PREFIX owl: <"
				+ OWL.getURI()
				+ "> "
				+ "SELECT ?recContext ?lu ?metaDataProp ?metaDataValue WHERE {"
				+ "?recContext "
				+ "	a kno:RecordedContextInformation ; "
				+ "	kno:hasTimestamp "
				+ recTime.asResource().getURI()
				+ "; "
				+ "	kno:isRecordedContextInformationOf "
				+ user.asResource().getURI()
				+ " . "
				+ user.asResource().getURI()
				+ "	a kno:User ; "
				+ "	kno:hasAction "
				+ action
				+ ". "
				+ action
				+ "	kno:referencesLearningUnit ?lu ;"
				+ "	kno:hasTimestamp "
				+ actTime.asResource().toString()
				+ " ."
				+ "?metaDataProp rdfs:subPropertyOf kno:hasMetaData ."
				+ "?lu ?metaDataProp ?metaDataValue ."
				;
	}

	public ActionStatisticsAssembly(OWLOntology ontology) {
		this.ontology = ontology;
		MyFactory factory = new MyFactory(ontology);
		this.learningUnits = factory.getAllLearningUnitInstances();
	}

	public Collection<? extends LearningUnit> getLearningUnits() {
		return learningUnits;
	}

	public void setLearningUnits(
			Collection<? extends MyLearningUnit> learningUnits) {
		this.learningUnits = learningUnits;
	}
}
