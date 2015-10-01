package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import de.unipotsdam.rulegenerator.statistics.Reason;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;

import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

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

		String queryString = null;

		try {
			queryString = getQueryString();

			//"select * where {"+action+" ?x ?z. ?a ?b "+action+". }"
			Query query = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, model);
			ResultSet results = qe.execSelect();
			//ResultSetFormatter.out(System.out, results, query);

			while(results.hasNext()) {
				QuerySolution row = results.next();
				user = row.get("user");
				actTime = row.getLiteral("actTime");
				recTime = row.getLiteral("recTime");
				lu = row.get("lu");
				recContext = row.get("recContext");
				metaDataProp = row.get("metaDataProp");
				metaDataValue = row.getLiteral("metaDataValue");

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
			qe.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


/*** QUERY STRING FACTORY ***/

	protected String getQueryString() throws Exception {
		if (action == null)
			throw new Exception("Action is not defined.");
		return ""
				+ namespace
				+ "SELECT ?user ?actTime ?recTime ?recContext ?lu ?metaDataProp ?metaDataValue WHERE {"
				+ "?recContext "
				+ "	a kno:RecordedContextInformation ; "
				+ "	kno:hasTimestamp ?recTime ; "
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
				+ "FILTER (?recTime <= ?actTime) "
				+ "}"
				;
	}
}