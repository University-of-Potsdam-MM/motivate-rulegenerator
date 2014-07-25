package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAppointmentDetailContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAudioOutputAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultConstraintTail;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextClass;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextInformationParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentAirPressureMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentAmbientNoiseMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentAppointmentMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentHumidityMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentLearningUnitMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentLuminosityMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentTemperatureMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentTimeMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentlyRainingMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentlySunnyMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDateFormatContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDeviceTypeMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDisplayHorizontalResolutionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDisplayVerticalResolutionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDistanceUnitContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultExpectedTimeNeededForCompletionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultExternalDisplayAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFinishedLearningUnitMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultHasScreenReaderFunctionalityMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultIntervalConstraintTail;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLatitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitIDContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLocationContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLocationContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLongitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMeasurableContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMicrophoneAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMixedContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultNextAppointmentMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultParameterizedContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPersonalContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPersonalContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPhotoCameraAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPhysicalContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPhysicalContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPressureUnitContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPrinterAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultPrintingInkContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRankingConstraintTail;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictAudioPlaybackConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictContentConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictDataCaptureConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictLocationTrackingConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictNavigationTypeConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictRelationsConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictUsageConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultRestrictVideoPlaybackConstraintHead;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultScenarioContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultScenarioContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultSituationalContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultSituationalContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTargetLatitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTargetLongitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTargetTimestampContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTechnicalContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTechnicalContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTemperatureScaleContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultTimeUntilTimestampMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserCurrentLearningStyleInputMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserCurrentLearningStylePerceptionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserCurrentLearningStyleProcessingMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserDestinationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserDidArriveAtLocationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserDidLeaveLocationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserIsAtLocationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationAddressMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationBuildingMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationCountryMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationDistanceMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationLatitudeMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationLongitudeMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserLocationRegionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserMeansOfTransportationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserMovementSpeedMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserRoleMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindAngerMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindBoredomMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindConcentrationMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindConfusionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindCuriosityMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindDistractionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindHappinessMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindOptimismMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindSadnessMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserStateOfMindTirednessMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultVelocityUnitContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultVideoCameraAvailableMeasurableInformation;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: MyFactory<br>
 * @version generated on Fri Jul 25 16:06:55 CEST 2014 by tobias
 */
public class MyFactory implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public MyFactory(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public MyFactory(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#AppointmentDetailContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#AppointmentDetailContextParameter", AppointmentDetailContextParameter.class, DefaultAppointmentDetailContextParameter.class);
    }

    /**
     * Creates an instance of type AppointmentDetailContextParameter.  Modifies the underlying ontology.
     */
    public AppointmentDetailContextParameter createAppointmentDetailContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_APPOINTMENTDETAILCONTEXTPARAMETER, DefaultAppointmentDetailContextParameter.class);
    }

    /**
     * Gets an instance of type AppointmentDetailContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public AppointmentDetailContextParameter getAppointmentDetailContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_APPOINTMENTDETAILCONTEXTPARAMETER, DefaultAppointmentDetailContextParameter.class);
    }

    /**
     * Gets all instances of AppointmentDetailContextParameter from the ontology.
     */
    public Collection<? extends AppointmentDetailContextParameter> getAllAppointmentDetailContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_APPOINTMENTDETAILCONTEXTPARAMETER, DefaultAppointmentDetailContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#AudioOutputAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#AudioOutputAvailableMeasurableInformation", AudioOutputAvailableMeasurableInformation.class, DefaultAudioOutputAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type AudioOutputAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public AudioOutputAvailableMeasurableInformation createAudioOutputAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AUDIOOUTPUTAVAILABLEMEASURABLEINFORMATION, DefaultAudioOutputAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type AudioOutputAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public AudioOutputAvailableMeasurableInformation getAudioOutputAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AUDIOOUTPUTAVAILABLEMEASURABLEINFORMATION, DefaultAudioOutputAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of AudioOutputAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends AudioOutputAvailableMeasurableInformation> getAllAudioOutputAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AUDIOOUTPUTAVAILABLEMEASURABLEINFORMATION, DefaultAudioOutputAvailableMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ConstraintHead", ConstraintHead.class, DefaultConstraintHead.class);
    }

    /**
     * Creates an instance of type ConstraintHead.  Modifies the underlying ontology.
     */
    public ConstraintHead createConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONSTRAINTHEAD, DefaultConstraintHead.class);
    }

    /**
     * Gets an instance of type ConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ConstraintHead getConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONSTRAINTHEAD, DefaultConstraintHead.class);
    }

    /**
     * Gets all instances of ConstraintHead from the ontology.
     */
    public Collection<? extends ConstraintHead> getAllConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONSTRAINTHEAD, DefaultConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ConstraintTail
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ConstraintTail", ConstraintTail.class, DefaultConstraintTail.class);
    }

    /**
     * Creates an instance of type ConstraintTail.  Modifies the underlying ontology.
     */
    public ConstraintTail createConstraintTail(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONSTRAINTTAIL, DefaultConstraintTail.class);
    }

    /**
     * Gets an instance of type ConstraintTail with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ConstraintTail getConstraintTail(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONSTRAINTTAIL, DefaultConstraintTail.class);
    }

    /**
     * Gets all instances of ConstraintTail from the ontology.
     */
    public Collection<? extends ConstraintTail> getAllConstraintTailInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONSTRAINTTAIL, DefaultConstraintTail.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ContextClass
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ContextClass", ContextClass.class, DefaultContextClass.class);
    }

    /**
     * Creates an instance of type ContextClass.  Modifies the underlying ontology.
     */
    public ContextClass createContextClass(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONTEXTCLASS, DefaultContextClass.class);
    }

    /**
     * Gets an instance of type ContextClass with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ContextClass getContextClass(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONTEXTCLASS, DefaultContextClass.class);
    }

    /**
     * Gets all instances of ContextClass from the ontology.
     */
    public Collection<? extends ContextClass> getAllContextClassInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTEXTCLASS, DefaultContextClass.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ContextInformation", ContextInformation.class, DefaultContextInformation.class);
    }

    /**
     * Creates an instance of type ContextInformation.  Modifies the underlying ontology.
     */
    public ContextInformation createContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONTEXTINFORMATION, DefaultContextInformation.class);
    }

    /**
     * Gets an instance of type ContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ContextInformation getContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONTEXTINFORMATION, DefaultContextInformation.class);
    }

    /**
     * Gets all instances of ContextInformation from the ontology.
     */
    public Collection<? extends ContextInformation> getAllContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTEXTINFORMATION, DefaultContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ContextInformationParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ContextInformationParameter", ContextInformationParameter.class, DefaultContextInformationParameter.class);
    }

    /**
     * Creates an instance of type ContextInformationParameter.  Modifies the underlying ontology.
     */
    public ContextInformationParameter createContextInformationParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONTEXTINFORMATIONPARAMETER, DefaultContextInformationParameter.class);
    }

    /**
     * Gets an instance of type ContextInformationParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ContextInformationParameter getContextInformationParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONTEXTINFORMATIONPARAMETER, DefaultContextInformationParameter.class);
    }

    /**
     * Gets all instances of ContextInformationParameter from the ontology.
     */
    public Collection<? extends ContextInformationParameter> getAllContextInformationParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTEXTINFORMATIONPARAMETER, DefaultContextInformationParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentAirPressureMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentAirPressureMeasurableInformation", CurrentAirPressureMeasurableInformation.class, DefaultCurrentAirPressureMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentAirPressureMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentAirPressureMeasurableInformation createCurrentAirPressureMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTAIRPRESSUREMEASURABLEINFORMATION, DefaultCurrentAirPressureMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentAirPressureMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentAirPressureMeasurableInformation getCurrentAirPressureMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTAIRPRESSUREMEASURABLEINFORMATION, DefaultCurrentAirPressureMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentAirPressureMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentAirPressureMeasurableInformation> getAllCurrentAirPressureMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTAIRPRESSUREMEASURABLEINFORMATION, DefaultCurrentAirPressureMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentAmbientNoiseMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentAmbientNoiseMeasurableInformation", CurrentAmbientNoiseMeasurableInformation.class, DefaultCurrentAmbientNoiseMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentAmbientNoiseMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentAmbientNoiseMeasurableInformation createCurrentAmbientNoiseMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTAMBIENTNOISEMEASURABLEINFORMATION, DefaultCurrentAmbientNoiseMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentAmbientNoiseMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentAmbientNoiseMeasurableInformation getCurrentAmbientNoiseMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTAMBIENTNOISEMEASURABLEINFORMATION, DefaultCurrentAmbientNoiseMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentAmbientNoiseMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentAmbientNoiseMeasurableInformation> getAllCurrentAmbientNoiseMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTAMBIENTNOISEMEASURABLEINFORMATION, DefaultCurrentAmbientNoiseMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentAppointmentMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentAppointmentMeasurableInformation", CurrentAppointmentMeasurableInformation.class, DefaultCurrentAppointmentMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentAppointmentMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentAppointmentMeasurableInformation createCurrentAppointmentMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTAPPOINTMENTMEASURABLEINFORMATION, DefaultCurrentAppointmentMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentAppointmentMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentAppointmentMeasurableInformation getCurrentAppointmentMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTAPPOINTMENTMEASURABLEINFORMATION, DefaultCurrentAppointmentMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentAppointmentMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentAppointmentMeasurableInformation> getAllCurrentAppointmentMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTAPPOINTMENTMEASURABLEINFORMATION, DefaultCurrentAppointmentMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentHumidityMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentHumidityMeasurableInformation", CurrentHumidityMeasurableInformation.class, DefaultCurrentHumidityMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentHumidityMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentHumidityMeasurableInformation createCurrentHumidityMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTHUMIDITYMEASURABLEINFORMATION, DefaultCurrentHumidityMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentHumidityMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentHumidityMeasurableInformation getCurrentHumidityMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTHUMIDITYMEASURABLEINFORMATION, DefaultCurrentHumidityMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentHumidityMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentHumidityMeasurableInformation> getAllCurrentHumidityMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTHUMIDITYMEASURABLEINFORMATION, DefaultCurrentHumidityMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentLearningUnitMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentLearningUnitMeasurableInformation", CurrentLearningUnitMeasurableInformation.class, DefaultCurrentLearningUnitMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentLearningUnitMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentLearningUnitMeasurableInformation createCurrentLearningUnitMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTLEARNINGUNITMEASURABLEINFORMATION, DefaultCurrentLearningUnitMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentLearningUnitMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentLearningUnitMeasurableInformation getCurrentLearningUnitMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTLEARNINGUNITMEASURABLEINFORMATION, DefaultCurrentLearningUnitMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentLearningUnitMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentLearningUnitMeasurableInformation> getAllCurrentLearningUnitMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTLEARNINGUNITMEASURABLEINFORMATION, DefaultCurrentLearningUnitMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentLuminosityMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentLuminosityMeasurableInformation", CurrentLuminosityMeasurableInformation.class, DefaultCurrentLuminosityMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentLuminosityMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentLuminosityMeasurableInformation createCurrentLuminosityMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTLUMINOSITYMEASURABLEINFORMATION, DefaultCurrentLuminosityMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentLuminosityMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentLuminosityMeasurableInformation getCurrentLuminosityMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTLUMINOSITYMEASURABLEINFORMATION, DefaultCurrentLuminosityMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentLuminosityMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentLuminosityMeasurableInformation> getAllCurrentLuminosityMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTLUMINOSITYMEASURABLEINFORMATION, DefaultCurrentLuminosityMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentTemperatureMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentTemperatureMeasurableInformation", CurrentTemperatureMeasurableInformation.class, DefaultCurrentTemperatureMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentTemperatureMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentTemperatureMeasurableInformation createCurrentTemperatureMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTTEMPERATUREMEASURABLEINFORMATION, DefaultCurrentTemperatureMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentTemperatureMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentTemperatureMeasurableInformation getCurrentTemperatureMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTTEMPERATUREMEASURABLEINFORMATION, DefaultCurrentTemperatureMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentTemperatureMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentTemperatureMeasurableInformation> getAllCurrentTemperatureMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTTEMPERATUREMEASURABLEINFORMATION, DefaultCurrentTemperatureMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentTimeMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentTimeMeasurableInformation", CurrentTimeMeasurableInformation.class, DefaultCurrentTimeMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentTimeMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentTimeMeasurableInformation createCurrentTimeMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTTIMEMEASURABLEINFORMATION, DefaultCurrentTimeMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentTimeMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentTimeMeasurableInformation getCurrentTimeMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTTIMEMEASURABLEINFORMATION, DefaultCurrentTimeMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentTimeMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentTimeMeasurableInformation> getAllCurrentTimeMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTTIMEMEASURABLEINFORMATION, DefaultCurrentTimeMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentlyRainingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentlyRainingMeasurableInformation", CurrentlyRainingMeasurableInformation.class, DefaultCurrentlyRainingMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentlyRainingMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentlyRainingMeasurableInformation createCurrentlyRainingMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTLYRAININGMEASURABLEINFORMATION, DefaultCurrentlyRainingMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentlyRainingMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentlyRainingMeasurableInformation getCurrentlyRainingMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTLYRAININGMEASURABLEINFORMATION, DefaultCurrentlyRainingMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentlyRainingMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentlyRainingMeasurableInformation> getAllCurrentlyRainingMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTLYRAININGMEASURABLEINFORMATION, DefaultCurrentlyRainingMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#CurrentlySunnyMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#CurrentlySunnyMeasurableInformation", CurrentlySunnyMeasurableInformation.class, DefaultCurrentlySunnyMeasurableInformation.class);
    }

    /**
     * Creates an instance of type CurrentlySunnyMeasurableInformation.  Modifies the underlying ontology.
     */
    public CurrentlySunnyMeasurableInformation createCurrentlySunnyMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CURRENTLYSUNNYMEASURABLEINFORMATION, DefaultCurrentlySunnyMeasurableInformation.class);
    }

    /**
     * Gets an instance of type CurrentlySunnyMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CurrentlySunnyMeasurableInformation getCurrentlySunnyMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CURRENTLYSUNNYMEASURABLEINFORMATION, DefaultCurrentlySunnyMeasurableInformation.class);
    }

    /**
     * Gets all instances of CurrentlySunnyMeasurableInformation from the ontology.
     */
    public Collection<? extends CurrentlySunnyMeasurableInformation> getAllCurrentlySunnyMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CURRENTLYSUNNYMEASURABLEINFORMATION, DefaultCurrentlySunnyMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#DateFormatContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#DateFormatContextParameter", DateFormatContextParameter.class, DefaultDateFormatContextParameter.class);
    }

    /**
     * Creates an instance of type DateFormatContextParameter.  Modifies the underlying ontology.
     */
    public DateFormatContextParameter createDateFormatContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DATEFORMATCONTEXTPARAMETER, DefaultDateFormatContextParameter.class);
    }

    /**
     * Gets an instance of type DateFormatContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DateFormatContextParameter getDateFormatContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DATEFORMATCONTEXTPARAMETER, DefaultDateFormatContextParameter.class);
    }

    /**
     * Gets all instances of DateFormatContextParameter from the ontology.
     */
    public Collection<? extends DateFormatContextParameter> getAllDateFormatContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DATEFORMATCONTEXTPARAMETER, DefaultDateFormatContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#DeviceTypeMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#DeviceTypeMeasurableInformation", DeviceTypeMeasurableInformation.class, DefaultDeviceTypeMeasurableInformation.class);
    }

    /**
     * Creates an instance of type DeviceTypeMeasurableInformation.  Modifies the underlying ontology.
     */
    public DeviceTypeMeasurableInformation createDeviceTypeMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DEVICETYPEMEASURABLEINFORMATION, DefaultDeviceTypeMeasurableInformation.class);
    }

    /**
     * Gets an instance of type DeviceTypeMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DeviceTypeMeasurableInformation getDeviceTypeMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DEVICETYPEMEASURABLEINFORMATION, DefaultDeviceTypeMeasurableInformation.class);
    }

    /**
     * Gets all instances of DeviceTypeMeasurableInformation from the ontology.
     */
    public Collection<? extends DeviceTypeMeasurableInformation> getAllDeviceTypeMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DEVICETYPEMEASURABLEINFORMATION, DefaultDeviceTypeMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#DisplayHorizontalResolutionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#DisplayHorizontalResolutionMeasurableInformation", DisplayHorizontalResolutionMeasurableInformation.class, DefaultDisplayHorizontalResolutionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type DisplayHorizontalResolutionMeasurableInformation.  Modifies the underlying ontology.
     */
    public DisplayHorizontalResolutionMeasurableInformation createDisplayHorizontalResolutionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DISPLAYHORIZONTALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayHorizontalResolutionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type DisplayHorizontalResolutionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DisplayHorizontalResolutionMeasurableInformation getDisplayHorizontalResolutionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DISPLAYHORIZONTALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayHorizontalResolutionMeasurableInformation.class);
    }

    /**
     * Gets all instances of DisplayHorizontalResolutionMeasurableInformation from the ontology.
     */
    public Collection<? extends DisplayHorizontalResolutionMeasurableInformation> getAllDisplayHorizontalResolutionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DISPLAYHORIZONTALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayHorizontalResolutionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#DisplayVerticalResolutionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#DisplayVerticalResolutionMeasurableInformation", DisplayVerticalResolutionMeasurableInformation.class, DefaultDisplayVerticalResolutionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type DisplayVerticalResolutionMeasurableInformation.  Modifies the underlying ontology.
     */
    public DisplayVerticalResolutionMeasurableInformation createDisplayVerticalResolutionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DISPLAYVERTICALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayVerticalResolutionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type DisplayVerticalResolutionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DisplayVerticalResolutionMeasurableInformation getDisplayVerticalResolutionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DISPLAYVERTICALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayVerticalResolutionMeasurableInformation.class);
    }

    /**
     * Gets all instances of DisplayVerticalResolutionMeasurableInformation from the ontology.
     */
    public Collection<? extends DisplayVerticalResolutionMeasurableInformation> getAllDisplayVerticalResolutionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DISPLAYVERTICALRESOLUTIONMEASURABLEINFORMATION, DefaultDisplayVerticalResolutionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#DistanceUnitContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#DistanceUnitContextParameter", DistanceUnitContextParameter.class, DefaultDistanceUnitContextParameter.class);
    }

    /**
     * Creates an instance of type DistanceUnitContextParameter.  Modifies the underlying ontology.
     */
    public DistanceUnitContextParameter createDistanceUnitContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DISTANCEUNITCONTEXTPARAMETER, DefaultDistanceUnitContextParameter.class);
    }

    /**
     * Gets an instance of type DistanceUnitContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DistanceUnitContextParameter getDistanceUnitContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DISTANCEUNITCONTEXTPARAMETER, DefaultDistanceUnitContextParameter.class);
    }

    /**
     * Gets all instances of DistanceUnitContextParameter from the ontology.
     */
    public Collection<? extends DistanceUnitContextParameter> getAllDistanceUnitContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DISTANCEUNITCONTEXTPARAMETER, DefaultDistanceUnitContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ExpectedTimeNeededForCompletionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ExpectedTimeNeededForCompletionMeasurableInformation", ExpectedTimeNeededForCompletionMeasurableInformation.class, DefaultExpectedTimeNeededForCompletionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type ExpectedTimeNeededForCompletionMeasurableInformation.  Modifies the underlying ontology.
     */
    public ExpectedTimeNeededForCompletionMeasurableInformation createExpectedTimeNeededForCompletionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_EXPECTEDTIMENEEDEDFORCOMPLETIONMEASURABLEINFORMATION, DefaultExpectedTimeNeededForCompletionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type ExpectedTimeNeededForCompletionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ExpectedTimeNeededForCompletionMeasurableInformation getExpectedTimeNeededForCompletionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_EXPECTEDTIMENEEDEDFORCOMPLETIONMEASURABLEINFORMATION, DefaultExpectedTimeNeededForCompletionMeasurableInformation.class);
    }

    /**
     * Gets all instances of ExpectedTimeNeededForCompletionMeasurableInformation from the ontology.
     */
    public Collection<? extends ExpectedTimeNeededForCompletionMeasurableInformation> getAllExpectedTimeNeededForCompletionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_EXPECTEDTIMENEEDEDFORCOMPLETIONMEASURABLEINFORMATION, DefaultExpectedTimeNeededForCompletionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ExternalDisplayAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ExternalDisplayAvailableMeasurableInformation", ExternalDisplayAvailableMeasurableInformation.class, DefaultExternalDisplayAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type ExternalDisplayAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public ExternalDisplayAvailableMeasurableInformation createExternalDisplayAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_EXTERNALDISPLAYAVAILABLEMEASURABLEINFORMATION, DefaultExternalDisplayAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type ExternalDisplayAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ExternalDisplayAvailableMeasurableInformation getExternalDisplayAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_EXTERNALDISPLAYAVAILABLEMEASURABLEINFORMATION, DefaultExternalDisplayAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of ExternalDisplayAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends ExternalDisplayAvailableMeasurableInformation> getAllExternalDisplayAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_EXTERNALDISPLAYAVAILABLEMEASURABLEINFORMATION, DefaultExternalDisplayAvailableMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#FinishedLearningUnitMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#FinishedLearningUnitMeasurableInformation", FinishedLearningUnitMeasurableInformation.class, DefaultFinishedLearningUnitMeasurableInformation.class);
    }

    /**
     * Creates an instance of type FinishedLearningUnitMeasurableInformation.  Modifies the underlying ontology.
     */
    public FinishedLearningUnitMeasurableInformation createFinishedLearningUnitMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_FINISHEDLEARNINGUNITMEASURABLEINFORMATION, DefaultFinishedLearningUnitMeasurableInformation.class);
    }

    /**
     * Gets an instance of type FinishedLearningUnitMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public FinishedLearningUnitMeasurableInformation getFinishedLearningUnitMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_FINISHEDLEARNINGUNITMEASURABLEINFORMATION, DefaultFinishedLearningUnitMeasurableInformation.class);
    }

    /**
     * Gets all instances of FinishedLearningUnitMeasurableInformation from the ontology.
     */
    public Collection<? extends FinishedLearningUnitMeasurableInformation> getAllFinishedLearningUnitMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_FINISHEDLEARNINGUNITMEASURABLEINFORMATION, DefaultFinishedLearningUnitMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#HasScreenReaderFunctionalityMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#HasScreenReaderFunctionalityMeasurableInformation", HasScreenReaderFunctionalityMeasurableInformation.class, DefaultHasScreenReaderFunctionalityMeasurableInformation.class);
    }

    /**
     * Creates an instance of type HasScreenReaderFunctionalityMeasurableInformation.  Modifies the underlying ontology.
     */
    public HasScreenReaderFunctionalityMeasurableInformation createHasScreenReaderFunctionalityMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_HASSCREENREADERFUNCTIONALITYMEASURABLEINFORMATION, DefaultHasScreenReaderFunctionalityMeasurableInformation.class);
    }

    /**
     * Gets an instance of type HasScreenReaderFunctionalityMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public HasScreenReaderFunctionalityMeasurableInformation getHasScreenReaderFunctionalityMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_HASSCREENREADERFUNCTIONALITYMEASURABLEINFORMATION, DefaultHasScreenReaderFunctionalityMeasurableInformation.class);
    }

    /**
     * Gets all instances of HasScreenReaderFunctionalityMeasurableInformation from the ontology.
     */
    public Collection<? extends HasScreenReaderFunctionalityMeasurableInformation> getAllHasScreenReaderFunctionalityMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_HASSCREENREADERFUNCTIONALITYMEASURABLEINFORMATION, DefaultHasScreenReaderFunctionalityMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#IntervalConstraintTail
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#IntervalConstraintTail", IntervalConstraintTail.class, DefaultIntervalConstraintTail.class);
    }

    /**
     * Creates an instance of type IntervalConstraintTail.  Modifies the underlying ontology.
     */
    public IntervalConstraintTail createIntervalConstraintTail(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_INTERVALCONSTRAINTTAIL, DefaultIntervalConstraintTail.class);
    }

    /**
     * Gets an instance of type IntervalConstraintTail with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public IntervalConstraintTail getIntervalConstraintTail(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_INTERVALCONSTRAINTTAIL, DefaultIntervalConstraintTail.class);
    }

    /**
     * Gets all instances of IntervalConstraintTail from the ontology.
     */
    public Collection<? extends IntervalConstraintTail> getAllIntervalConstraintTailInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_INTERVALCONSTRAINTTAIL, DefaultIntervalConstraintTail.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LatitudeContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LatitudeContextParameter", LatitudeContextParameter.class, DefaultLatitudeContextParameter.class);
    }

    /**
     * Creates an instance of type LatitudeContextParameter.  Modifies the underlying ontology.
     */
    public LatitudeContextParameter createLatitudeContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LATITUDECONTEXTPARAMETER, DefaultLatitudeContextParameter.class);
    }

    /**
     * Gets an instance of type LatitudeContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LatitudeContextParameter getLatitudeContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LATITUDECONTEXTPARAMETER, DefaultLatitudeContextParameter.class);
    }

    /**
     * Gets all instances of LatitudeContextParameter from the ontology.
     */
    public Collection<? extends LatitudeContextParameter> getAllLatitudeContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LATITUDECONTEXTPARAMETER, DefaultLatitudeContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LearningUnit
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LearningUnit", LearningUnit.class, DefaultLearningUnit.class);
    }

    /**
     * Creates an instance of type LearningUnit.  Modifies the underlying ontology.
     */
    public LearningUnit createLearningUnit(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LEARNINGUNIT, DefaultLearningUnit.class);
    }

    /**
     * Gets an instance of type LearningUnit with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LearningUnit getLearningUnit(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LEARNINGUNIT, DefaultLearningUnit.class);
    }

    /**
     * Gets all instances of LearningUnit from the ontology.
     */
    public Collection<? extends LearningUnit> getAllLearningUnitInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LEARNINGUNIT, MyLearningUnit.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LearningUnitIDContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LearningUnitIDContextParameter", LearningUnitIDContextParameter.class, DefaultLearningUnitIDContextParameter.class);
    }

    /**
     * Creates an instance of type LearningUnitIDContextParameter.  Modifies the underlying ontology.
     */
    public LearningUnitIDContextParameter createLearningUnitIDContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LEARNINGUNITIDCONTEXTPARAMETER, DefaultLearningUnitIDContextParameter.class);
    }

    /**
     * Gets an instance of type LearningUnitIDContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LearningUnitIDContextParameter getLearningUnitIDContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LEARNINGUNITIDCONTEXTPARAMETER, DefaultLearningUnitIDContextParameter.class);
    }

    /**
     * Gets all instances of LearningUnitIDContextParameter from the ontology.
     */
    public Collection<? extends LearningUnitIDContextParameter> getAllLearningUnitIDContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LEARNINGUNITIDCONTEXTPARAMETER, DefaultLearningUnitIDContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LocationContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LocationContext", LocationContext.class, DefaultLocationContext.class);
    }

    /**
     * Creates an instance of type LocationContext.  Modifies the underlying ontology.
     */
    public LocationContext createLocationContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LOCATIONCONTEXT, DefaultLocationContext.class);
    }

    /**
     * Gets an instance of type LocationContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LocationContext getLocationContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LOCATIONCONTEXT, DefaultLocationContext.class);
    }

    /**
     * Gets all instances of LocationContext from the ontology.
     */
    public Collection<? extends LocationContext> getAllLocationContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LOCATIONCONTEXT, DefaultLocationContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LocationContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LocationContextInformation", LocationContextInformation.class, DefaultLocationContextInformation.class);
    }

    /**
     * Creates an instance of type LocationContextInformation.  Modifies the underlying ontology.
     */
    public LocationContextInformation createLocationContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LOCATIONCONTEXTINFORMATION, DefaultLocationContextInformation.class);
    }

    /**
     * Gets an instance of type LocationContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LocationContextInformation getLocationContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LOCATIONCONTEXTINFORMATION, DefaultLocationContextInformation.class);
    }

    /**
     * Gets all instances of LocationContextInformation from the ontology.
     */
    public Collection<? extends LocationContextInformation> getAllLocationContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LOCATIONCONTEXTINFORMATION, DefaultLocationContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#LongitudeContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#LongitudeContextParameter", LongitudeContextParameter.class, DefaultLongitudeContextParameter.class);
    }

    /**
     * Creates an instance of type LongitudeContextParameter.  Modifies the underlying ontology.
     */
    public LongitudeContextParameter createLongitudeContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LONGITUDECONTEXTPARAMETER, DefaultLongitudeContextParameter.class);
    }

    /**
     * Gets an instance of type LongitudeContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public LongitudeContextParameter getLongitudeContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LONGITUDECONTEXTPARAMETER, DefaultLongitudeContextParameter.class);
    }

    /**
     * Gets all instances of LongitudeContextParameter from the ontology.
     */
    public Collection<? extends LongitudeContextParameter> getAllLongitudeContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LONGITUDECONTEXTPARAMETER, DefaultLongitudeContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#MeasurableContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#MeasurableContextInformation", MeasurableContextInformation.class, DefaultMeasurableContextInformation.class);
    }

    /**
     * Creates an instance of type MeasurableContextInformation.  Modifies the underlying ontology.
     */
    public MeasurableContextInformation createMeasurableContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_MEASURABLECONTEXTINFORMATION, DefaultMeasurableContextInformation.class);
    }

    /**
     * Gets an instance of type MeasurableContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public MeasurableContextInformation getMeasurableContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_MEASURABLECONTEXTINFORMATION, DefaultMeasurableContextInformation.class);
    }

    /**
     * Gets all instances of MeasurableContextInformation from the ontology.
     */
    public Collection<? extends MeasurableContextInformation> getAllMeasurableContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_MEASURABLECONTEXTINFORMATION, DefaultMeasurableContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#MicrophoneAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#MicrophoneAvailableMeasurableInformation", MicrophoneAvailableMeasurableInformation.class, DefaultMicrophoneAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type MicrophoneAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public MicrophoneAvailableMeasurableInformation createMicrophoneAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_MICROPHONEAVAILABLEMEASURABLEINFORMATION, DefaultMicrophoneAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type MicrophoneAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public MicrophoneAvailableMeasurableInformation getMicrophoneAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_MICROPHONEAVAILABLEMEASURABLEINFORMATION, DefaultMicrophoneAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of MicrophoneAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends MicrophoneAvailableMeasurableInformation> getAllMicrophoneAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_MICROPHONEAVAILABLEMEASURABLEINFORMATION, DefaultMicrophoneAvailableMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#MixedContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#MixedContextInformation", MixedContextInformation.class, DefaultMixedContextInformation.class);
    }

    /**
     * Creates an instance of type MixedContextInformation.  Modifies the underlying ontology.
     */
    public MixedContextInformation createMixedContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_MIXEDCONTEXTINFORMATION, DefaultMixedContextInformation.class);
    }

    /**
     * Gets an instance of type MixedContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public MixedContextInformation getMixedContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_MIXEDCONTEXTINFORMATION, DefaultMixedContextInformation.class);
    }

    /**
     * Gets all instances of MixedContextInformation from the ontology.
     */
    public Collection<? extends MixedContextInformation> getAllMixedContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_MIXEDCONTEXTINFORMATION, DefaultMixedContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#NextAppointmentMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#NextAppointmentMeasurableInformation", NextAppointmentMeasurableInformation.class, DefaultNextAppointmentMeasurableInformation.class);
    }

    /**
     * Creates an instance of type NextAppointmentMeasurableInformation.  Modifies the underlying ontology.
     */
    public NextAppointmentMeasurableInformation createNextAppointmentMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_NEXTAPPOINTMENTMEASURABLEINFORMATION, DefaultNextAppointmentMeasurableInformation.class);
    }

    /**
     * Gets an instance of type NextAppointmentMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public NextAppointmentMeasurableInformation getNextAppointmentMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_NEXTAPPOINTMENTMEASURABLEINFORMATION, DefaultNextAppointmentMeasurableInformation.class);
    }

    /**
     * Gets all instances of NextAppointmentMeasurableInformation from the ontology.
     */
    public Collection<? extends NextAppointmentMeasurableInformation> getAllNextAppointmentMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_NEXTAPPOINTMENTMEASURABLEINFORMATION, DefaultNextAppointmentMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ParameterizedContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ParameterizedContextInformation", ParameterizedContextInformation.class, DefaultParameterizedContextInformation.class);
    }

    /**
     * Creates an instance of type ParameterizedContextInformation.  Modifies the underlying ontology.
     */
    public ParameterizedContextInformation createParameterizedContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PARAMETERIZEDCONTEXTINFORMATION, DefaultParameterizedContextInformation.class);
    }

    /**
     * Gets an instance of type ParameterizedContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ParameterizedContextInformation getParameterizedContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PARAMETERIZEDCONTEXTINFORMATION, DefaultParameterizedContextInformation.class);
    }

    /**
     * Gets all instances of ParameterizedContextInformation from the ontology.
     */
    public Collection<? extends ParameterizedContextInformation> getAllParameterizedContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PARAMETERIZEDCONTEXTINFORMATION, DefaultParameterizedContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PersonalContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PersonalContext", PersonalContext.class, DefaultPersonalContext.class);
    }

    /**
     * Creates an instance of type PersonalContext.  Modifies the underlying ontology.
     */
    public PersonalContext createPersonalContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PERSONALCONTEXT, DefaultPersonalContext.class);
    }

    /**
     * Gets an instance of type PersonalContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PersonalContext getPersonalContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PERSONALCONTEXT, DefaultPersonalContext.class);
    }

    /**
     * Gets all instances of PersonalContext from the ontology.
     */
    public Collection<? extends PersonalContext> getAllPersonalContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PERSONALCONTEXT, DefaultPersonalContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PersonalContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PersonalContextInformation", PersonalContextInformation.class, DefaultPersonalContextInformation.class);
    }

    /**
     * Creates an instance of type PersonalContextInformation.  Modifies the underlying ontology.
     */
    public PersonalContextInformation createPersonalContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PERSONALCONTEXTINFORMATION, DefaultPersonalContextInformation.class);
    }

    /**
     * Gets an instance of type PersonalContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PersonalContextInformation getPersonalContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PERSONALCONTEXTINFORMATION, DefaultPersonalContextInformation.class);
    }

    /**
     * Gets all instances of PersonalContextInformation from the ontology.
     */
    public Collection<? extends PersonalContextInformation> getAllPersonalContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PERSONALCONTEXTINFORMATION, DefaultPersonalContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PhotoCameraAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PhotoCameraAvailableMeasurableInformation", PhotoCameraAvailableMeasurableInformation.class, DefaultPhotoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type PhotoCameraAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public PhotoCameraAvailableMeasurableInformation createPhotoCameraAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PHOTOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultPhotoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type PhotoCameraAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PhotoCameraAvailableMeasurableInformation getPhotoCameraAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PHOTOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultPhotoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of PhotoCameraAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends PhotoCameraAvailableMeasurableInformation> getAllPhotoCameraAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PHOTOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultPhotoCameraAvailableMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PhysicalContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PhysicalContext", PhysicalContext.class, DefaultPhysicalContext.class);
    }

    /**
     * Creates an instance of type PhysicalContext.  Modifies the underlying ontology.
     */
    public PhysicalContext createPhysicalContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PHYSICALCONTEXT, DefaultPhysicalContext.class);
    }

    /**
     * Gets an instance of type PhysicalContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PhysicalContext getPhysicalContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PHYSICALCONTEXT, DefaultPhysicalContext.class);
    }

    /**
     * Gets all instances of PhysicalContext from the ontology.
     */
    public Collection<? extends PhysicalContext> getAllPhysicalContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PHYSICALCONTEXT, DefaultPhysicalContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PhysicalContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PhysicalContextInformation", PhysicalContextInformation.class, DefaultPhysicalContextInformation.class);
    }

    /**
     * Creates an instance of type PhysicalContextInformation.  Modifies the underlying ontology.
     */
    public PhysicalContextInformation createPhysicalContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PHYSICALCONTEXTINFORMATION, DefaultPhysicalContextInformation.class);
    }

    /**
     * Gets an instance of type PhysicalContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PhysicalContextInformation getPhysicalContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PHYSICALCONTEXTINFORMATION, DefaultPhysicalContextInformation.class);
    }

    /**
     * Gets all instances of PhysicalContextInformation from the ontology.
     */
    public Collection<? extends PhysicalContextInformation> getAllPhysicalContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PHYSICALCONTEXTINFORMATION, DefaultPhysicalContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PressureUnitContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PressureUnitContextParameter", PressureUnitContextParameter.class, DefaultPressureUnitContextParameter.class);
    }

    /**
     * Creates an instance of type PressureUnitContextParameter.  Modifies the underlying ontology.
     */
    public PressureUnitContextParameter createPressureUnitContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PRESSUREUNITCONTEXTPARAMETER, DefaultPressureUnitContextParameter.class);
    }

    /**
     * Gets an instance of type PressureUnitContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PressureUnitContextParameter getPressureUnitContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PRESSUREUNITCONTEXTPARAMETER, DefaultPressureUnitContextParameter.class);
    }

    /**
     * Gets all instances of PressureUnitContextParameter from the ontology.
     */
    public Collection<? extends PressureUnitContextParameter> getAllPressureUnitContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PRESSUREUNITCONTEXTPARAMETER, DefaultPressureUnitContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PrinterAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PrinterAvailableMeasurableInformation", PrinterAvailableMeasurableInformation.class, DefaultPrinterAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type PrinterAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public PrinterAvailableMeasurableInformation createPrinterAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PRINTERAVAILABLEMEASURABLEINFORMATION, DefaultPrinterAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type PrinterAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PrinterAvailableMeasurableInformation getPrinterAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PRINTERAVAILABLEMEASURABLEINFORMATION, DefaultPrinterAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of PrinterAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends PrinterAvailableMeasurableInformation> getAllPrinterAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PRINTERAVAILABLEMEASURABLEINFORMATION, DefaultPrinterAvailableMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#PrintingInkContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#PrintingInkContextParameter", PrintingInkContextParameter.class, DefaultPrintingInkContextParameter.class);
    }

    /**
     * Creates an instance of type PrintingInkContextParameter.  Modifies the underlying ontology.
     */
    public PrintingInkContextParameter createPrintingInkContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PRINTINGINKCONTEXTPARAMETER, DefaultPrintingInkContextParameter.class);
    }

    /**
     * Gets an instance of type PrintingInkContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public PrintingInkContextParameter getPrintingInkContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PRINTINGINKCONTEXTPARAMETER, DefaultPrintingInkContextParameter.class);
    }

    /**
     * Gets all instances of PrintingInkContextParameter from the ontology.
     */
    public Collection<? extends PrintingInkContextParameter> getAllPrintingInkContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PRINTINGINKCONTEXTPARAMETER, DefaultPrintingInkContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RankingConstraintTail
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RankingConstraintTail", RankingConstraintTail.class, DefaultRankingConstraintTail.class);
    }

    /**
     * Creates an instance of type RankingConstraintTail.  Modifies the underlying ontology.
     */
    public RankingConstraintTail createRankingConstraintTail(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RANKINGCONSTRAINTTAIL, DefaultRankingConstraintTail.class);
    }

    /**
     * Gets an instance of type RankingConstraintTail with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RankingConstraintTail getRankingConstraintTail(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RANKINGCONSTRAINTTAIL, DefaultRankingConstraintTail.class);
    }

    /**
     * Gets all instances of RankingConstraintTail from the ontology.
     */
    public Collection<? extends RankingConstraintTail> getAllRankingConstraintTailInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RANKINGCONSTRAINTTAIL, DefaultRankingConstraintTail.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictAudioPlaybackConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictAudioPlaybackConstraintHead", RestrictAudioPlaybackConstraintHead.class, DefaultRestrictAudioPlaybackConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictAudioPlaybackConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictAudioPlaybackConstraintHead createRestrictAudioPlaybackConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTAUDIOPLAYBACKCONSTRAINTHEAD, DefaultRestrictAudioPlaybackConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictAudioPlaybackConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictAudioPlaybackConstraintHead getRestrictAudioPlaybackConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTAUDIOPLAYBACKCONSTRAINTHEAD, DefaultRestrictAudioPlaybackConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictAudioPlaybackConstraintHead from the ontology.
     */
    public Collection<? extends RestrictAudioPlaybackConstraintHead> getAllRestrictAudioPlaybackConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTAUDIOPLAYBACKCONSTRAINTHEAD, DefaultRestrictAudioPlaybackConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictContentConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictContentConstraintHead", RestrictContentConstraintHead.class, DefaultRestrictContentConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictContentConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictContentConstraintHead createRestrictContentConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTCONTENTCONSTRAINTHEAD, DefaultRestrictContentConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictContentConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictContentConstraintHead getRestrictContentConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTCONTENTCONSTRAINTHEAD, DefaultRestrictContentConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictContentConstraintHead from the ontology.
     */
    public Collection<? extends RestrictContentConstraintHead> getAllRestrictContentConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTCONTENTCONSTRAINTHEAD, DefaultRestrictContentConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictDataCaptureConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictDataCaptureConstraintHead", RestrictDataCaptureConstraintHead.class, DefaultRestrictDataCaptureConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictDataCaptureConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictDataCaptureConstraintHead createRestrictDataCaptureConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTDATACAPTURECONSTRAINTHEAD, DefaultRestrictDataCaptureConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictDataCaptureConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictDataCaptureConstraintHead getRestrictDataCaptureConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTDATACAPTURECONSTRAINTHEAD, DefaultRestrictDataCaptureConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictDataCaptureConstraintHead from the ontology.
     */
    public Collection<? extends RestrictDataCaptureConstraintHead> getAllRestrictDataCaptureConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTDATACAPTURECONSTRAINTHEAD, DefaultRestrictDataCaptureConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictLocationTrackingConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictLocationTrackingConstraintHead", RestrictLocationTrackingConstraintHead.class, DefaultRestrictLocationTrackingConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictLocationTrackingConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictLocationTrackingConstraintHead createRestrictLocationTrackingConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTLOCATIONTRACKINGCONSTRAINTHEAD, DefaultRestrictLocationTrackingConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictLocationTrackingConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictLocationTrackingConstraintHead getRestrictLocationTrackingConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTLOCATIONTRACKINGCONSTRAINTHEAD, DefaultRestrictLocationTrackingConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictLocationTrackingConstraintHead from the ontology.
     */
    public Collection<? extends RestrictLocationTrackingConstraintHead> getAllRestrictLocationTrackingConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTLOCATIONTRACKINGCONSTRAINTHEAD, DefaultRestrictLocationTrackingConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictNavigationTypeConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictNavigationTypeConstraintHead", RestrictNavigationTypeConstraintHead.class, DefaultRestrictNavigationTypeConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictNavigationTypeConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictNavigationTypeConstraintHead createRestrictNavigationTypeConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTNAVIGATIONTYPECONSTRAINTHEAD, DefaultRestrictNavigationTypeConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictNavigationTypeConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictNavigationTypeConstraintHead getRestrictNavigationTypeConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTNAVIGATIONTYPECONSTRAINTHEAD, DefaultRestrictNavigationTypeConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictNavigationTypeConstraintHead from the ontology.
     */
    public Collection<? extends RestrictNavigationTypeConstraintHead> getAllRestrictNavigationTypeConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTNAVIGATIONTYPECONSTRAINTHEAD, DefaultRestrictNavigationTypeConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictRelationsConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictRelationsConstraintHead", RestrictRelationsConstraintHead.class, DefaultRestrictRelationsConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictRelationsConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictRelationsConstraintHead createRestrictRelationsConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTRELATIONSCONSTRAINTHEAD, DefaultRestrictRelationsConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictRelationsConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictRelationsConstraintHead getRestrictRelationsConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTRELATIONSCONSTRAINTHEAD, DefaultRestrictRelationsConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictRelationsConstraintHead from the ontology.
     */
    public Collection<? extends RestrictRelationsConstraintHead> getAllRestrictRelationsConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTRELATIONSCONSTRAINTHEAD, DefaultRestrictRelationsConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictUsageConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictUsageConstraintHead", RestrictUsageConstraintHead.class, DefaultRestrictUsageConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictUsageConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictUsageConstraintHead createRestrictUsageConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTUSAGECONSTRAINTHEAD, DefaultRestrictUsageConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictUsageConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictUsageConstraintHead getRestrictUsageConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTUSAGECONSTRAINTHEAD, DefaultRestrictUsageConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictUsageConstraintHead from the ontology.
     */
    public Collection<? extends RestrictUsageConstraintHead> getAllRestrictUsageConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTUSAGECONSTRAINTHEAD, DefaultRestrictUsageConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#RestrictVideoPlaybackConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#RestrictVideoPlaybackConstraintHead", RestrictVideoPlaybackConstraintHead.class, DefaultRestrictVideoPlaybackConstraintHead.class);
    }

    /**
     * Creates an instance of type RestrictVideoPlaybackConstraintHead.  Modifies the underlying ontology.
     */
    public RestrictVideoPlaybackConstraintHead createRestrictVideoPlaybackConstraintHead(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESTRICTVIDEOPLAYBACKCONSTRAINTHEAD, DefaultRestrictVideoPlaybackConstraintHead.class);
    }

    /**
     * Gets an instance of type RestrictVideoPlaybackConstraintHead with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RestrictVideoPlaybackConstraintHead getRestrictVideoPlaybackConstraintHead(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESTRICTVIDEOPLAYBACKCONSTRAINTHEAD, DefaultRestrictVideoPlaybackConstraintHead.class);
    }

    /**
     * Gets all instances of RestrictVideoPlaybackConstraintHead from the ontology.
     */
    public Collection<? extends RestrictVideoPlaybackConstraintHead> getAllRestrictVideoPlaybackConstraintHeadInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTVIDEOPLAYBACKCONSTRAINTHEAD, DefaultRestrictVideoPlaybackConstraintHead.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ScenarioContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ScenarioContext", ScenarioContext.class, DefaultScenarioContext.class);
    }

    /**
     * Creates an instance of type ScenarioContext.  Modifies the underlying ontology.
     */
    public ScenarioContext createScenarioContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SCENARIOCONTEXT, DefaultScenarioContext.class);
    }

    /**
     * Gets an instance of type ScenarioContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ScenarioContext getScenarioContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SCENARIOCONTEXT, DefaultScenarioContext.class);
    }

    /**
     * Gets all instances of ScenarioContext from the ontology.
     */
    public Collection<? extends ScenarioContext> getAllScenarioContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SCENARIOCONTEXT, DefaultScenarioContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#ScenarioContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#ScenarioContextInformation", ScenarioContextInformation.class, DefaultScenarioContextInformation.class);
    }

    /**
     * Creates an instance of type ScenarioContextInformation.  Modifies the underlying ontology.
     */
    public ScenarioContextInformation createScenarioContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SCENARIOCONTEXTINFORMATION, DefaultScenarioContextInformation.class);
    }

    /**
     * Gets an instance of type ScenarioContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ScenarioContextInformation getScenarioContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SCENARIOCONTEXTINFORMATION, DefaultScenarioContextInformation.class);
    }

    /**
     * Gets all instances of ScenarioContextInformation from the ontology.
     */
    public Collection<? extends ScenarioContextInformation> getAllScenarioContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SCENARIOCONTEXTINFORMATION, DefaultScenarioContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#SituationalContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#SituationalContext", SituationalContext.class, DefaultSituationalContext.class);
    }

    /**
     * Creates an instance of type SituationalContext.  Modifies the underlying ontology.
     */
    public SituationalContext createSituationalContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SITUATIONALCONTEXT, DefaultSituationalContext.class);
    }

    /**
     * Gets an instance of type SituationalContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public SituationalContext getSituationalContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SITUATIONALCONTEXT, DefaultSituationalContext.class);
    }

    /**
     * Gets all instances of SituationalContext from the ontology.
     */
    public Collection<? extends SituationalContext> getAllSituationalContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SITUATIONALCONTEXT, DefaultSituationalContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#SituationalContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#SituationalContextInformation", SituationalContextInformation.class, DefaultSituationalContextInformation.class);
    }

    /**
     * Creates an instance of type SituationalContextInformation.  Modifies the underlying ontology.
     */
    public SituationalContextInformation createSituationalContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SITUATIONALCONTEXTINFORMATION, DefaultSituationalContextInformation.class);
    }

    /**
     * Gets an instance of type SituationalContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public SituationalContextInformation getSituationalContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SITUATIONALCONTEXTINFORMATION, DefaultSituationalContextInformation.class);
    }

    /**
     * Gets all instances of SituationalContextInformation from the ontology.
     */
    public Collection<? extends SituationalContextInformation> getAllSituationalContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SITUATIONALCONTEXTINFORMATION, DefaultSituationalContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TargetLatitudeContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TargetLatitudeContextParameter", TargetLatitudeContextParameter.class, DefaultTargetLatitudeContextParameter.class);
    }

    /**
     * Creates an instance of type TargetLatitudeContextParameter.  Modifies the underlying ontology.
     */
    public TargetLatitudeContextParameter createTargetLatitudeContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TARGETLATITUDECONTEXTPARAMETER, DefaultTargetLatitudeContextParameter.class);
    }

    /**
     * Gets an instance of type TargetLatitudeContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TargetLatitudeContextParameter getTargetLatitudeContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TARGETLATITUDECONTEXTPARAMETER, DefaultTargetLatitudeContextParameter.class);
    }

    /**
     * Gets all instances of TargetLatitudeContextParameter from the ontology.
     */
    public Collection<? extends TargetLatitudeContextParameter> getAllTargetLatitudeContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TARGETLATITUDECONTEXTPARAMETER, DefaultTargetLatitudeContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TargetLongitudeContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TargetLongitudeContextParameter", TargetLongitudeContextParameter.class, DefaultTargetLongitudeContextParameter.class);
    }

    /**
     * Creates an instance of type TargetLongitudeContextParameter.  Modifies the underlying ontology.
     */
    public TargetLongitudeContextParameter createTargetLongitudeContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TARGETLONGITUDECONTEXTPARAMETER, DefaultTargetLongitudeContextParameter.class);
    }

    /**
     * Gets an instance of type TargetLongitudeContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TargetLongitudeContextParameter getTargetLongitudeContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TARGETLONGITUDECONTEXTPARAMETER, DefaultTargetLongitudeContextParameter.class);
    }

    /**
     * Gets all instances of TargetLongitudeContextParameter from the ontology.
     */
    public Collection<? extends TargetLongitudeContextParameter> getAllTargetLongitudeContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TARGETLONGITUDECONTEXTPARAMETER, DefaultTargetLongitudeContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TargetTimestampContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TargetTimestampContextParameter", TargetTimestampContextParameter.class, DefaultTargetTimestampContextParameter.class);
    }

    /**
     * Creates an instance of type TargetTimestampContextParameter.  Modifies the underlying ontology.
     */
    public TargetTimestampContextParameter createTargetTimestampContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TARGETTIMESTAMPCONTEXTPARAMETER, DefaultTargetTimestampContextParameter.class);
    }

    /**
     * Gets an instance of type TargetTimestampContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TargetTimestampContextParameter getTargetTimestampContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TARGETTIMESTAMPCONTEXTPARAMETER, DefaultTargetTimestampContextParameter.class);
    }

    /**
     * Gets all instances of TargetTimestampContextParameter from the ontology.
     */
    public Collection<? extends TargetTimestampContextParameter> getAllTargetTimestampContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TARGETTIMESTAMPCONTEXTPARAMETER, DefaultTargetTimestampContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TechnicalContext
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TechnicalContext", TechnicalContext.class, DefaultTechnicalContext.class);
    }

    /**
     * Creates an instance of type TechnicalContext.  Modifies the underlying ontology.
     */
    public TechnicalContext createTechnicalContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TECHNICALCONTEXT, DefaultTechnicalContext.class);
    }

    /**
     * Gets an instance of type TechnicalContext with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TechnicalContext getTechnicalContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TECHNICALCONTEXT, DefaultTechnicalContext.class);
    }

    /**
     * Gets all instances of TechnicalContext from the ontology.
     */
    public Collection<? extends TechnicalContext> getAllTechnicalContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TECHNICALCONTEXT, DefaultTechnicalContext.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TechnicalContextInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TechnicalContextInformation", TechnicalContextInformation.class, DefaultTechnicalContextInformation.class);
    }

    /**
     * Creates an instance of type TechnicalContextInformation.  Modifies the underlying ontology.
     */
    public TechnicalContextInformation createTechnicalContextInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TECHNICALCONTEXTINFORMATION, DefaultTechnicalContextInformation.class);
    }

    /**
     * Gets an instance of type TechnicalContextInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TechnicalContextInformation getTechnicalContextInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TECHNICALCONTEXTINFORMATION, DefaultTechnicalContextInformation.class);
    }

    /**
     * Gets all instances of TechnicalContextInformation from the ontology.
     */
    public Collection<? extends TechnicalContextInformation> getAllTechnicalContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TECHNICALCONTEXTINFORMATION, DefaultTechnicalContextInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TemperatureScaleContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TemperatureScaleContextParameter", TemperatureScaleContextParameter.class, DefaultTemperatureScaleContextParameter.class);
    }

    /**
     * Creates an instance of type TemperatureScaleContextParameter.  Modifies the underlying ontology.
     */
    public TemperatureScaleContextParameter createTemperatureScaleContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TEMPERATURESCALECONTEXTPARAMETER, DefaultTemperatureScaleContextParameter.class);
    }

    /**
     * Gets an instance of type TemperatureScaleContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TemperatureScaleContextParameter getTemperatureScaleContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TEMPERATURESCALECONTEXTPARAMETER, DefaultTemperatureScaleContextParameter.class);
    }

    /**
     * Gets all instances of TemperatureScaleContextParameter from the ontology.
     */
    public Collection<? extends TemperatureScaleContextParameter> getAllTemperatureScaleContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TEMPERATURESCALECONTEXTPARAMETER, DefaultTemperatureScaleContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#TimeUntilTimestampMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#TimeUntilTimestampMeasurableInformation", TimeUntilTimestampMeasurableInformation.class, DefaultTimeUntilTimestampMeasurableInformation.class);
    }

    /**
     * Creates an instance of type TimeUntilTimestampMeasurableInformation.  Modifies the underlying ontology.
     */
    public TimeUntilTimestampMeasurableInformation createTimeUntilTimestampMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TIMEUNTILTIMESTAMPMEASURABLEINFORMATION, DefaultTimeUntilTimestampMeasurableInformation.class);
    }

    /**
     * Gets an instance of type TimeUntilTimestampMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TimeUntilTimestampMeasurableInformation getTimeUntilTimestampMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TIMEUNTILTIMESTAMPMEASURABLEINFORMATION, DefaultTimeUntilTimestampMeasurableInformation.class);
    }

    /**
     * Gets all instances of TimeUntilTimestampMeasurableInformation from the ontology.
     */
    public Collection<? extends TimeUntilTimestampMeasurableInformation> getAllTimeUntilTimestampMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TIMEUNTILTIMESTAMPMEASURABLEINFORMATION, DefaultTimeUntilTimestampMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleInputMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleInputMeasurableInformation", UserCurrentLearningStyleInputMeasurableInformation.class, DefaultUserCurrentLearningStyleInputMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserCurrentLearningStyleInputMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserCurrentLearningStyleInputMeasurableInformation createUserCurrentLearningStyleInputMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEINPUTMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleInputMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserCurrentLearningStyleInputMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserCurrentLearningStyleInputMeasurableInformation getUserCurrentLearningStyleInputMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEINPUTMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleInputMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserCurrentLearningStyleInputMeasurableInformation from the ontology.
     */
    public Collection<? extends UserCurrentLearningStyleInputMeasurableInformation> getAllUserCurrentLearningStyleInputMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEINPUTMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleInputMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStylePerceptionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStylePerceptionMeasurableInformation", UserCurrentLearningStylePerceptionMeasurableInformation.class, DefaultUserCurrentLearningStylePerceptionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserCurrentLearningStylePerceptionMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserCurrentLearningStylePerceptionMeasurableInformation createUserCurrentLearningStylePerceptionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPERCEPTIONMEASURABLEINFORMATION, DefaultUserCurrentLearningStylePerceptionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserCurrentLearningStylePerceptionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserCurrentLearningStylePerceptionMeasurableInformation getUserCurrentLearningStylePerceptionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPERCEPTIONMEASURABLEINFORMATION, DefaultUserCurrentLearningStylePerceptionMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserCurrentLearningStylePerceptionMeasurableInformation from the ontology.
     */
    public Collection<? extends UserCurrentLearningStylePerceptionMeasurableInformation> getAllUserCurrentLearningStylePerceptionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPERCEPTIONMEASURABLEINFORMATION, DefaultUserCurrentLearningStylePerceptionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleProcessingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleProcessingMeasurableInformation", UserCurrentLearningStyleProcessingMeasurableInformation.class, DefaultUserCurrentLearningStyleProcessingMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserCurrentLearningStyleProcessingMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserCurrentLearningStyleProcessingMeasurableInformation createUserCurrentLearningStyleProcessingMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPROCESSINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleProcessingMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserCurrentLearningStyleProcessingMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserCurrentLearningStyleProcessingMeasurableInformation getUserCurrentLearningStyleProcessingMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPROCESSINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleProcessingMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserCurrentLearningStyleProcessingMeasurableInformation from the ontology.
     */
    public Collection<? extends UserCurrentLearningStyleProcessingMeasurableInformation> getAllUserCurrentLearningStyleProcessingMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEPROCESSINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleProcessingMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleUnderstandingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserCurrentLearningStyleUnderstandingMeasurableInformation", UserCurrentLearningStyleUnderstandingMeasurableInformation.class, DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserCurrentLearningStyleUnderstandingMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserCurrentLearningStyleUnderstandingMeasurableInformation createUserCurrentLearningStyleUnderstandingMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEUNDERSTANDINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserCurrentLearningStyleUnderstandingMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserCurrentLearningStyleUnderstandingMeasurableInformation getUserCurrentLearningStyleUnderstandingMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEUNDERSTANDINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserCurrentLearningStyleUnderstandingMeasurableInformation from the ontology.
     */
    public Collection<? extends UserCurrentLearningStyleUnderstandingMeasurableInformation> getAllUserCurrentLearningStyleUnderstandingMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERCURRENTLEARNINGSTYLEUNDERSTANDINGMEASURABLEINFORMATION, DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserDestinationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserDestinationMeasurableInformation", UserDestinationMeasurableInformation.class, DefaultUserDestinationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserDestinationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserDestinationMeasurableInformation createUserDestinationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERDESTINATIONMEASURABLEINFORMATION, DefaultUserDestinationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserDestinationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserDestinationMeasurableInformation getUserDestinationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERDESTINATIONMEASURABLEINFORMATION, DefaultUserDestinationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserDestinationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserDestinationMeasurableInformation> getAllUserDestinationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERDESTINATIONMEASURABLEINFORMATION, DefaultUserDestinationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserDidArriveAtLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserDidArriveAtLocationMeasurableInformation", UserDidArriveAtLocationMeasurableInformation.class, DefaultUserDidArriveAtLocationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserDidArriveAtLocationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserDidArriveAtLocationMeasurableInformation createUserDidArriveAtLocationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERDIDARRIVEATLOCATIONMEASURABLEINFORMATION, DefaultUserDidArriveAtLocationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserDidArriveAtLocationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserDidArriveAtLocationMeasurableInformation getUserDidArriveAtLocationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERDIDARRIVEATLOCATIONMEASURABLEINFORMATION, DefaultUserDidArriveAtLocationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserDidArriveAtLocationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserDidArriveAtLocationMeasurableInformation> getAllUserDidArriveAtLocationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERDIDARRIVEATLOCATIONMEASURABLEINFORMATION, DefaultUserDidArriveAtLocationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserDidLeaveLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserDidLeaveLocationMeasurableInformation", UserDidLeaveLocationMeasurableInformation.class, DefaultUserDidLeaveLocationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserDidLeaveLocationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserDidLeaveLocationMeasurableInformation createUserDidLeaveLocationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERDIDLEAVELOCATIONMEASURABLEINFORMATION, DefaultUserDidLeaveLocationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserDidLeaveLocationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserDidLeaveLocationMeasurableInformation getUserDidLeaveLocationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERDIDLEAVELOCATIONMEASURABLEINFORMATION, DefaultUserDidLeaveLocationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserDidLeaveLocationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserDidLeaveLocationMeasurableInformation> getAllUserDidLeaveLocationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERDIDLEAVELOCATIONMEASURABLEINFORMATION, DefaultUserDidLeaveLocationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserIsAtLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserIsAtLocationMeasurableInformation", UserIsAtLocationMeasurableInformation.class, DefaultUserIsAtLocationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserIsAtLocationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserIsAtLocationMeasurableInformation createUserIsAtLocationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERISATLOCATIONMEASURABLEINFORMATION, DefaultUserIsAtLocationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserIsAtLocationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserIsAtLocationMeasurableInformation getUserIsAtLocationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERISATLOCATIONMEASURABLEINFORMATION, DefaultUserIsAtLocationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserIsAtLocationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserIsAtLocationMeasurableInformation> getAllUserIsAtLocationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERISATLOCATIONMEASURABLEINFORMATION, DefaultUserIsAtLocationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationAddressMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationAddressMeasurableInformation", UserLocationAddressMeasurableInformation.class, DefaultUserLocationAddressMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationAddressMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationAddressMeasurableInformation createUserLocationAddressMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONADDRESSMEASURABLEINFORMATION, DefaultUserLocationAddressMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationAddressMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationAddressMeasurableInformation getUserLocationAddressMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONADDRESSMEASURABLEINFORMATION, DefaultUserLocationAddressMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationAddressMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationAddressMeasurableInformation> getAllUserLocationAddressMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONADDRESSMEASURABLEINFORMATION, DefaultUserLocationAddressMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationBuildingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationBuildingMeasurableInformation", UserLocationBuildingMeasurableInformation.class, DefaultUserLocationBuildingMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationBuildingMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationBuildingMeasurableInformation createUserLocationBuildingMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONBUILDINGMEASURABLEINFORMATION, DefaultUserLocationBuildingMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationBuildingMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationBuildingMeasurableInformation getUserLocationBuildingMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONBUILDINGMEASURABLEINFORMATION, DefaultUserLocationBuildingMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationBuildingMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationBuildingMeasurableInformation> getAllUserLocationBuildingMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONBUILDINGMEASURABLEINFORMATION, DefaultUserLocationBuildingMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationCountryMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationCountryMeasurableInformation", UserLocationCountryMeasurableInformation.class, DefaultUserLocationCountryMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationCountryMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationCountryMeasurableInformation createUserLocationCountryMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONCOUNTRYMEASURABLEINFORMATION, DefaultUserLocationCountryMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationCountryMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationCountryMeasurableInformation getUserLocationCountryMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONCOUNTRYMEASURABLEINFORMATION, DefaultUserLocationCountryMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationCountryMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationCountryMeasurableInformation> getAllUserLocationCountryMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONCOUNTRYMEASURABLEINFORMATION, DefaultUserLocationCountryMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationDistanceMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationDistanceMeasurableInformation", UserLocationDistanceMeasurableInformation.class, DefaultUserLocationDistanceMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationDistanceMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationDistanceMeasurableInformation createUserLocationDistanceMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONDISTANCEMEASURABLEINFORMATION, DefaultUserLocationDistanceMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationDistanceMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationDistanceMeasurableInformation getUserLocationDistanceMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONDISTANCEMEASURABLEINFORMATION, DefaultUserLocationDistanceMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationDistanceMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationDistanceMeasurableInformation> getAllUserLocationDistanceMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONDISTANCEMEASURABLEINFORMATION, DefaultUserLocationDistanceMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationLatitudeMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationLatitudeMeasurableInformation", UserLocationLatitudeMeasurableInformation.class, DefaultUserLocationLatitudeMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationLatitudeMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationLatitudeMeasurableInformation createUserLocationLatitudeMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONLATITUDEMEASURABLEINFORMATION, DefaultUserLocationLatitudeMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationLatitudeMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationLatitudeMeasurableInformation getUserLocationLatitudeMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONLATITUDEMEASURABLEINFORMATION, DefaultUserLocationLatitudeMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationLatitudeMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationLatitudeMeasurableInformation> getAllUserLocationLatitudeMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONLATITUDEMEASURABLEINFORMATION, DefaultUserLocationLatitudeMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationLongitudeMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationLongitudeMeasurableInformation", UserLocationLongitudeMeasurableInformation.class, DefaultUserLocationLongitudeMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationLongitudeMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationLongitudeMeasurableInformation createUserLocationLongitudeMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONLONGITUDEMEASURABLEINFORMATION, DefaultUserLocationLongitudeMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationLongitudeMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationLongitudeMeasurableInformation getUserLocationLongitudeMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONLONGITUDEMEASURABLEINFORMATION, DefaultUserLocationLongitudeMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationLongitudeMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationLongitudeMeasurableInformation> getAllUserLocationLongitudeMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONLONGITUDEMEASURABLEINFORMATION, DefaultUserLocationLongitudeMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserLocationRegionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserLocationRegionMeasurableInformation", UserLocationRegionMeasurableInformation.class, DefaultUserLocationRegionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserLocationRegionMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserLocationRegionMeasurableInformation createUserLocationRegionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONREGIONMEASURABLEINFORMATION, DefaultUserLocationRegionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserLocationRegionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserLocationRegionMeasurableInformation getUserLocationRegionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERLOCATIONREGIONMEASURABLEINFORMATION, DefaultUserLocationRegionMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserLocationRegionMeasurableInformation from the ontology.
     */
    public Collection<? extends UserLocationRegionMeasurableInformation> getAllUserLocationRegionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERLOCATIONREGIONMEASURABLEINFORMATION, DefaultUserLocationRegionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserMeansOfTransportationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserMeansOfTransportationMeasurableInformation", UserMeansOfTransportationMeasurableInformation.class, DefaultUserMeansOfTransportationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserMeansOfTransportationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserMeansOfTransportationMeasurableInformation createUserMeansOfTransportationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERMEANSOFTRANSPORTATIONMEASURABLEINFORMATION, DefaultUserMeansOfTransportationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserMeansOfTransportationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserMeansOfTransportationMeasurableInformation getUserMeansOfTransportationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERMEANSOFTRANSPORTATIONMEASURABLEINFORMATION, DefaultUserMeansOfTransportationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserMeansOfTransportationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserMeansOfTransportationMeasurableInformation> getAllUserMeansOfTransportationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERMEANSOFTRANSPORTATIONMEASURABLEINFORMATION, DefaultUserMeansOfTransportationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserMovementSpeedMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserMovementSpeedMeasurableInformation", UserMovementSpeedMeasurableInformation.class, DefaultUserMovementSpeedMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserMovementSpeedMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserMovementSpeedMeasurableInformation createUserMovementSpeedMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERMOVEMENTSPEEDMEASURABLEINFORMATION, DefaultUserMovementSpeedMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserMovementSpeedMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserMovementSpeedMeasurableInformation getUserMovementSpeedMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERMOVEMENTSPEEDMEASURABLEINFORMATION, DefaultUserMovementSpeedMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserMovementSpeedMeasurableInformation from the ontology.
     */
    public Collection<? extends UserMovementSpeedMeasurableInformation> getAllUserMovementSpeedMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERMOVEMENTSPEEDMEASURABLEINFORMATION, DefaultUserMovementSpeedMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserRoleMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserRoleMeasurableInformation", UserRoleMeasurableInformation.class, DefaultUserRoleMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserRoleMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserRoleMeasurableInformation createUserRoleMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERROLEMEASURABLEINFORMATION, DefaultUserRoleMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserRoleMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserRoleMeasurableInformation getUserRoleMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERROLEMEASURABLEINFORMATION, DefaultUserRoleMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserRoleMeasurableInformation from the ontology.
     */
    public Collection<? extends UserRoleMeasurableInformation> getAllUserRoleMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERROLEMEASURABLEINFORMATION, DefaultUserRoleMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindAngerMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindAngerMeasurableInformation", UserStateOfMindAngerMeasurableInformation.class, DefaultUserStateOfMindAngerMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindAngerMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindAngerMeasurableInformation createUserStateOfMindAngerMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDANGERMEASURABLEINFORMATION, DefaultUserStateOfMindAngerMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindAngerMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindAngerMeasurableInformation getUserStateOfMindAngerMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDANGERMEASURABLEINFORMATION, DefaultUserStateOfMindAngerMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindAngerMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindAngerMeasurableInformation> getAllUserStateOfMindAngerMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDANGERMEASURABLEINFORMATION, DefaultUserStateOfMindAngerMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindBoredomMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindBoredomMeasurableInformation", UserStateOfMindBoredomMeasurableInformation.class, DefaultUserStateOfMindBoredomMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindBoredomMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindBoredomMeasurableInformation createUserStateOfMindBoredomMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDBOREDOMMEASURABLEINFORMATION, DefaultUserStateOfMindBoredomMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindBoredomMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindBoredomMeasurableInformation getUserStateOfMindBoredomMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDBOREDOMMEASURABLEINFORMATION, DefaultUserStateOfMindBoredomMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindBoredomMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindBoredomMeasurableInformation> getAllUserStateOfMindBoredomMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDBOREDOMMEASURABLEINFORMATION, DefaultUserStateOfMindBoredomMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindConcentrationMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindConcentrationMeasurableInformation", UserStateOfMindConcentrationMeasurableInformation.class, DefaultUserStateOfMindConcentrationMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindConcentrationMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindConcentrationMeasurableInformation createUserStateOfMindConcentrationMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCONCENTRATIONMEASURABLEINFORMATION, DefaultUserStateOfMindConcentrationMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindConcentrationMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindConcentrationMeasurableInformation getUserStateOfMindConcentrationMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCONCENTRATIONMEASURABLEINFORMATION, DefaultUserStateOfMindConcentrationMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindConcentrationMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindConcentrationMeasurableInformation> getAllUserStateOfMindConcentrationMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDCONCENTRATIONMEASURABLEINFORMATION, DefaultUserStateOfMindConcentrationMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindConfusionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindConfusionMeasurableInformation", UserStateOfMindConfusionMeasurableInformation.class, DefaultUserStateOfMindConfusionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindConfusionMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindConfusionMeasurableInformation createUserStateOfMindConfusionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCONFUSIONMEASURABLEINFORMATION, DefaultUserStateOfMindConfusionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindConfusionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindConfusionMeasurableInformation getUserStateOfMindConfusionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCONFUSIONMEASURABLEINFORMATION, DefaultUserStateOfMindConfusionMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindConfusionMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindConfusionMeasurableInformation> getAllUserStateOfMindConfusionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDCONFUSIONMEASURABLEINFORMATION, DefaultUserStateOfMindConfusionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindCuriosityMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindCuriosityMeasurableInformation", UserStateOfMindCuriosityMeasurableInformation.class, DefaultUserStateOfMindCuriosityMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindCuriosityMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindCuriosityMeasurableInformation createUserStateOfMindCuriosityMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCURIOSITYMEASURABLEINFORMATION, DefaultUserStateOfMindCuriosityMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindCuriosityMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindCuriosityMeasurableInformation getUserStateOfMindCuriosityMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDCURIOSITYMEASURABLEINFORMATION, DefaultUserStateOfMindCuriosityMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindCuriosityMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindCuriosityMeasurableInformation> getAllUserStateOfMindCuriosityMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDCURIOSITYMEASURABLEINFORMATION, DefaultUserStateOfMindCuriosityMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindDistractionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindDistractionMeasurableInformation", UserStateOfMindDistractionMeasurableInformation.class, DefaultUserStateOfMindDistractionMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindDistractionMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindDistractionMeasurableInformation createUserStateOfMindDistractionMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDDISTRACTIONMEASURABLEINFORMATION, DefaultUserStateOfMindDistractionMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindDistractionMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindDistractionMeasurableInformation getUserStateOfMindDistractionMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDDISTRACTIONMEASURABLEINFORMATION, DefaultUserStateOfMindDistractionMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindDistractionMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindDistractionMeasurableInformation> getAllUserStateOfMindDistractionMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDDISTRACTIONMEASURABLEINFORMATION, DefaultUserStateOfMindDistractionMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindHappinessMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindHappinessMeasurableInformation", UserStateOfMindHappinessMeasurableInformation.class, DefaultUserStateOfMindHappinessMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindHappinessMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindHappinessMeasurableInformation createUserStateOfMindHappinessMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDHAPPINESSMEASURABLEINFORMATION, DefaultUserStateOfMindHappinessMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindHappinessMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindHappinessMeasurableInformation getUserStateOfMindHappinessMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDHAPPINESSMEASURABLEINFORMATION, DefaultUserStateOfMindHappinessMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindHappinessMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindHappinessMeasurableInformation> getAllUserStateOfMindHappinessMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDHAPPINESSMEASURABLEINFORMATION, DefaultUserStateOfMindHappinessMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindOptimismMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindOptimismMeasurableInformation", UserStateOfMindOptimismMeasurableInformation.class, DefaultUserStateOfMindOptimismMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindOptimismMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindOptimismMeasurableInformation createUserStateOfMindOptimismMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDOPTIMISMMEASURABLEINFORMATION, DefaultUserStateOfMindOptimismMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindOptimismMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindOptimismMeasurableInformation getUserStateOfMindOptimismMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDOPTIMISMMEASURABLEINFORMATION, DefaultUserStateOfMindOptimismMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindOptimismMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindOptimismMeasurableInformation> getAllUserStateOfMindOptimismMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDOPTIMISMMEASURABLEINFORMATION, DefaultUserStateOfMindOptimismMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindSadnessMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindSadnessMeasurableInformation", UserStateOfMindSadnessMeasurableInformation.class, DefaultUserStateOfMindSadnessMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindSadnessMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindSadnessMeasurableInformation createUserStateOfMindSadnessMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDSADNESSMEASURABLEINFORMATION, DefaultUserStateOfMindSadnessMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindSadnessMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindSadnessMeasurableInformation getUserStateOfMindSadnessMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDSADNESSMEASURABLEINFORMATION, DefaultUserStateOfMindSadnessMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindSadnessMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindSadnessMeasurableInformation> getAllUserStateOfMindSadnessMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDSADNESSMEASURABLEINFORMATION, DefaultUserStateOfMindSadnessMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindTirednessMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#UserStateOfMindTirednessMeasurableInformation", UserStateOfMindTirednessMeasurableInformation.class, DefaultUserStateOfMindTirednessMeasurableInformation.class);
    }

    /**
     * Creates an instance of type UserStateOfMindTirednessMeasurableInformation.  Modifies the underlying ontology.
     */
    public UserStateOfMindTirednessMeasurableInformation createUserStateOfMindTirednessMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDTIREDNESSMEASURABLEINFORMATION, DefaultUserStateOfMindTirednessMeasurableInformation.class);
    }

    /**
     * Gets an instance of type UserStateOfMindTirednessMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public UserStateOfMindTirednessMeasurableInformation getUserStateOfMindTirednessMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_USERSTATEOFMINDTIREDNESSMEASURABLEINFORMATION, DefaultUserStateOfMindTirednessMeasurableInformation.class);
    }

    /**
     * Gets all instances of UserStateOfMindTirednessMeasurableInformation from the ontology.
     */
    public Collection<? extends UserStateOfMindTirednessMeasurableInformation> getAllUserStateOfMindTirednessMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_USERSTATEOFMINDTIREDNESSMEASURABLEINFORMATION, DefaultUserStateOfMindTirednessMeasurableInformation.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#VelocityUnitContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#VelocityUnitContextParameter", VelocityUnitContextParameter.class, DefaultVelocityUnitContextParameter.class);
    }

    /**
     * Creates an instance of type VelocityUnitContextParameter.  Modifies the underlying ontology.
     */
    public VelocityUnitContextParameter createVelocityUnitContextParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_VELOCITYUNITCONTEXTPARAMETER, DefaultVelocityUnitContextParameter.class);
    }

    /**
     * Gets an instance of type VelocityUnitContextParameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public VelocityUnitContextParameter getVelocityUnitContextParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_VELOCITYUNITCONTEXTPARAMETER, DefaultVelocityUnitContextParameter.class);
    }

    /**
     * Gets all instances of VelocityUnitContextParameter from the ontology.
     */
    public Collection<? extends VelocityUnitContextParameter> getAllVelocityUnitContextParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_VELOCITYUNITCONTEXTPARAMETER, DefaultVelocityUnitContextParameter.class);
    }


    /* ***************************************************
     * Class http://www.motivate-project.de/ontologies/knowledge#VideoCameraAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/knowledge#VideoCameraAvailableMeasurableInformation", VideoCameraAvailableMeasurableInformation.class, DefaultVideoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Creates an instance of type VideoCameraAvailableMeasurableInformation.  Modifies the underlying ontology.
     */
    public VideoCameraAvailableMeasurableInformation createVideoCameraAvailableMeasurableInformation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_VIDEOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultVideoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Gets an instance of type VideoCameraAvailableMeasurableInformation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public VideoCameraAvailableMeasurableInformation getVideoCameraAvailableMeasurableInformation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_VIDEOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultVideoCameraAvailableMeasurableInformation.class);
    }

    /**
     * Gets all instances of VideoCameraAvailableMeasurableInformation from the ontology.
     */
    public Collection<? extends VideoCameraAvailableMeasurableInformation> getAllVideoCameraAvailableMeasurableInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_VIDEOCAMERAAVAILABLEMEASURABLEINFORMATION, DefaultVideoCameraAvailableMeasurableInformation.class);
    }


}
