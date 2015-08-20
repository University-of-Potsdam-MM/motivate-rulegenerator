package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import de.unipotsdam.rulegenerator.ontology.CancelAction;
import de.unipotsdam.rulegenerator.statistics.Reason;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
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
	protected RDFNode user, recContext, lu, metaDataProp;
	protected Literal recTime, actTime, metaDataValue;
	protected InfModel model;
	private final String namespace = "" +
			"PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
			+ "PREFIX rdfs: <"
			+ RDFS.getURI()
			+ "> "
			+ "PREFIX owl: <"
			+ OWL.getURI()
			+ "> ";

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

	// avoid doing this work for every individual action x learning unit
	protected void createModel() {
		PelletReasoner reasoner = PelletReasonerFactory.getInstance()
				.createNonBufferingReasoner(ontology);
		// Get the KB from the reasoner
		KnowledgeBase kb = reasoner.getKB();
		// Create a Pellet graph using the KB from OWLAPI
		PelletInfGraph graph = new org.mindswap.pellet.jena.PelletReasoner()
				.bind(kb);
		// Wrap the graph in a model
		model = ModelFactory.createInfModel(graph);
	}

	// do the actual querying and gather context information for each action
	protected void collectReasonsForGivenAction() {

		String firstQuery = null;
		String secondQuery = null;

		try {
			firstQuery = getFirstQuery();

			//"select * where {"+action+" ?x ?z. ?a ?b "+action+". }"
			Query fquery = QueryFactory.create(firstQuery);
			QueryExecution fqe = QueryExecutionFactory.create(fquery, model);
			ResultSet results = fqe.execSelect();
			//ResultSetFormatter.out(System.out, results, fquery);

			while(results.hasNext()) {
				QuerySolution row = results.next();
				user = row.get("user");
				actTime = row.getLiteral("actTime");
				recTime = row.getLiteral("recTime");

				secondQuery = getSecondQuery();
				Query squery = QueryFactory.create(secondQuery);
				QueryExecution sqe = QueryExecutionFactory.create(squery, model);
				ResultSet finalResults = sqe.execSelect();
				//ResultSetFormatter.out(System.out, finalResults, squery);

				while (finalResults.hasNext()) {
					QuerySolution srow = finalResults.next();
					lu = srow.get("lu");
					recContext = srow.get("recContext");
					metaDataProp = srow.get("metaDataProp");
					metaDataValue = srow.getLiteral("metaDataValue");

					Reason reason = new Reason();
					reason.setAction(action);
					reason.setActionTime(actTime);
					reason.setUser(user);
					reason.setRecordedTime(recTime);
					reason.setLearningUnit(lu);
					reason.setRecordedContextInformation(recContext);
					reason.setMetaDataProperty(metaDataProp);
					reason.setMetaDataValue(metaDataValue);

					reasons.addReason(reason);
				}
				sqe.close();
			}
			fqe.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


/*** QUERY STRING FACTORY ***/

	protected String getFirstQuery() throws Exception {
		if (action == null)
			throw new Exception("Action is not defined.");
		return ""
				+ namespace
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
				+ namespace
				+ "SELECT ?recContext ?lu ?metaDataProp ?metaDataValue WHERE {"
				+ "?recContext "
				+ "	a kno:RecordedContextInformation ; "
				+ "	kno:hasTimestamp "
				+ recTime.getLexicalForm()
				+ "; "
				+ "	kno:isRecordedContextInformationOf <"
				+ user.toString()
				+ "> . <"
				+ user.toString()
				+ "> a kno:User ; "
				+ "	kno:hasAction "
				+ action
				+ ". "
				+ action
				+ "	kno:referencesLearningUnit ?lu ;"
				+ "	kno:hasTimestamp "
				+ actTime.getLexicalForm()
				+ " ."
				+ "?metaDataProp rdfs:subPropertyOf kno:hasMetaData ."
				+ "?lu ?metaDataProp ?metaDataValue ."
				+ "}"
				;
	}
}