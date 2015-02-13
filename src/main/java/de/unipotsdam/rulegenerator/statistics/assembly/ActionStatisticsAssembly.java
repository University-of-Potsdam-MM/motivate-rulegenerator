package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public abstract class ActionStatisticsAssembly extends StatisticsAssembly {
	protected Collection<? extends MyLearningUnit> learningUnits;
	protected String action, recTime, user, actTime;
	protected final String queryFirst = ""
			+ "PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
			+ "PREFIX rdfs: <"
			+ RDFS.getURI()
			+ "> "
			+ "PREFIX owl: <"
			+ OWL.getURI()
			+ "> "
			+ "SELECT ?user ?actTime (max(?rt) as ?recTime) WHERE {"
			+ "?recContext "
			+ "		a kno:RecordedContextInformation ; "
			+ "		kno:hasTimestamp ?rt ; "
			+ "		kno:isRecordedContextInformationOf ?user . "
			+ "?user "
			+ "		a kno:User ; "
			+ "		kno:hasAction"
			+ action
			+ " . "
			+ action
			+ "		kno:referencesLearningUnit ?lu ;"
			+ "		kno:hasTimestamp ?actTime ."
			+ "?metaDataProp rdfs:subPropertyOf kno:hasMetaData ."
			+ "?lu ?metaDataProp ?metaDataValue ."
			+ "FILTER (?rt <= ?actTime) "
			+ "}"
			+ "GROUP BY ?user ?actTime"
			;

	protected final String querySecond = ""
			+ "PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
			+ "PREFIX rdfs: <"
			+ RDFS.getURI()
			+ "> "
			+ "PREFIX owl: <"
			+ OWL.getURI()
			+ "> "
			+ "SELECT ?recContext ?lu ?metaDataProp ?metaDataValue WHERE {"
			+ "?recContext "
			+ "		a kno:RecordedContextInformation ; "
			+ "		kno:hasTimestamp "
			+ recTime
			+ "; "
			+ "		kno:isRecordedContextInformationOf "
			+ user
			+ " . "
			+ user
			+ "		a kno:User ; "
			+ "		kno:hasAction "
			+ action
			+ ". "
			+ action
			+ "		kno:referencesLearningUnit ?lu ;"
			+ "		kno:hasTimestamp "
			+ actTime
			+ " ."
			+ "?metaDataProp rdfs:subPropertyOf kno:hasMetaData ."
			+ "?lu ?metaDataProp ?metaDataValue ."
			;

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
