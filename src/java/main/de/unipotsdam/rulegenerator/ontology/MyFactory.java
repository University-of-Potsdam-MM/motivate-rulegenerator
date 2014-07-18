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
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAbgeschlossene_Lerneinheit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAktuelle_Adresse_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAktuelle_Position_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAktuelle_Temperatur;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAktueller_Breitengrad_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAktueller_Längengrad_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAppointmentDetailContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultAudioOutputAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultBenutzer_befindet_sich_an_Position;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultBenutzer_hat_Position_verlassen;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultBenutzer_ist_an_Position_angekommen;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultBietet_Screenreader_Funktionalität;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultBreitengrad_des_Zielortes;
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
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentTimeMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentlyRainingMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultCurrentlySunnyMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDateFormatContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDisplayHorizontalResolutionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDisplayVerticalResolutionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultDistanceUnitContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultEntfernung_des_Benutzers_zu_einer_Position;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultExpectedTimeNeededForCompletionMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultExternalDisplayAvailableMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFortbewegungsgeschwindigkeit_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFortbewegungsmittel_des_Benutzers;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultGebäude_in_dem_sich_der_Benutzer_befindet;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultGeräte_Typ;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultIntervalConstraintTail;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLand_in_dem_sich_der_Benutzer_befindet;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLatitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnit;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitIDContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLocationContext;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLocationContextInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLongitudeContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLängengrad_des_Zielortes;
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
import de.unipotsdam.rulegenerator.ontology.impl.DefaultUserRoleMeasurableInformation;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultVelocityUnitContextParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultVideoCameraAvailableMeasurableInformation;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: MyFactory<br>
 * @version generated on Wed Jul 16 14:45:16 CEST 2014 by tobias
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#AudioOutputAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#AudioOutputAvailableMeasurableInformation", AudioOutputAvailableMeasurableInformation.class, DefaultAudioOutputAvailableMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#CurrentLearningUnitMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#CurrentLearningUnitMeasurableInformation", CurrentLearningUnitMeasurableInformation.class, DefaultCurrentLearningUnitMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#DisplayHorizontalResolutionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#DisplayHorizontalResolutionMeasurableInformation", DisplayHorizontalResolutionMeasurableInformation.class, DefaultDisplayHorizontalResolutionMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#DisplayVerticalResolutionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#DisplayVerticalResolutionMeasurableInformation", DisplayVerticalResolutionMeasurableInformation.class, DefaultDisplayVerticalResolutionMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#ExpectedTimeNeededForCompletionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#ExpectedTimeNeededForCompletionMeasurableInformation", ExpectedTimeNeededForCompletionMeasurableInformation.class, DefaultExpectedTimeNeededForCompletionMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#ExternalDisplayAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#ExternalDisplayAvailableMeasurableInformation", ExternalDisplayAvailableMeasurableInformation.class, DefaultExternalDisplayAvailableMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#MicrophoneAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#MicrophoneAvailableMeasurableInformation", MicrophoneAvailableMeasurableInformation.class, DefaultMicrophoneAvailableMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#PhotoCameraAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#PhotoCameraAvailableMeasurableInformation", PhotoCameraAvailableMeasurableInformation.class, DefaultPhotoCameraAvailableMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#PrinterAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#PrinterAvailableMeasurableInformation", PrinterAvailableMeasurableInformation.class, DefaultPrinterAvailableMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#PrintingInkContextParameter
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#PrintingInkContextParameter", PrintingInkContextParameter.class, DefaultPrintingInkContextParameter.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#RestrictLocationTrackingConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#RestrictLocationTrackingConstraintHead", RestrictLocationTrackingConstraintHead.class, DefaultRestrictLocationTrackingConstraintHead.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#RestrictNavigationTypeConstraintHead
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#RestrictNavigationTypeConstraintHead", RestrictNavigationTypeConstraintHead.class, DefaultRestrictNavigationTypeConstraintHead.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleInputMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleInputMeasurableInformation", UserCurrentLearningStyleInputMeasurableInformation.class, DefaultUserCurrentLearningStyleInputMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStylePerceptionMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStylePerceptionMeasurableInformation", UserCurrentLearningStylePerceptionMeasurableInformation.class, DefaultUserCurrentLearningStylePerceptionMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleProcessingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleProcessingMeasurableInformation", UserCurrentLearningStyleProcessingMeasurableInformation.class, DefaultUserCurrentLearningStyleProcessingMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleUnderstandingMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#UserCurrentLearningStyleUnderstandingMeasurableInformation", UserCurrentLearningStyleUnderstandingMeasurableInformation.class, DefaultUserCurrentLearningStyleUnderstandingMeasurableInformation.class);
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
     * Class http://www.motivate-project.de/ontologies/motivate.owl#VideoCameraAvailableMeasurableInformation
     */

    {
        javaMapping.add("http://www.motivate-project.de/ontologies/motivate.owl#VideoCameraAvailableMeasurableInformation", VideoCameraAvailableMeasurableInformation.class, DefaultVideoCameraAvailableMeasurableInformation.class);
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


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#AppointmentDetailContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#AppointmentDetailContextParameter", AppointmentDetailContextParameter.class, DefaultAppointmentDetailContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ConstraintHead", ConstraintHead.class, DefaultConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ConstraintTail
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ConstraintTail", ConstraintTail.class, DefaultConstraintTail.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextClass
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextClass", ContextClass.class, DefaultContextClass.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextInformation", ContextInformation.class, DefaultContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextInformationParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ContextInformationParameter", ContextInformationParameter.class, DefaultContextInformationParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAirPressureMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAirPressureMeasurableInformation", CurrentAirPressureMeasurableInformation.class, DefaultCurrentAirPressureMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAmbientNoiseMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAmbientNoiseMeasurableInformation", CurrentAmbientNoiseMeasurableInformation.class, DefaultCurrentAmbientNoiseMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAppointmentMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentAppointmentMeasurableInformation", CurrentAppointmentMeasurableInformation.class, DefaultCurrentAppointmentMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentHumidityMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentHumidityMeasurableInformation", CurrentHumidityMeasurableInformation.class, DefaultCurrentHumidityMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentLuminosityMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentLuminosityMeasurableInformation", CurrentLuminosityMeasurableInformation.class, DefaultCurrentLuminosityMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentTemperatureMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentTemperatureMeasurableInformation", Aktuelle_Temperatur.class, DefaultAktuelle_Temperatur.class);
    }

    /**
     * Creates an instance of type Aktuelle_Temperatur.  Modifies the underlying ontology.
     */
    public Aktuelle_Temperatur createAktuelle_Temperatur(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_TEMPERATUR, DefaultAktuelle_Temperatur.class);
    }

    /**
     * Gets an instance of type Aktuelle_Temperatur with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Aktuelle_Temperatur getAktuelle_Temperatur(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_TEMPERATUR, DefaultAktuelle_Temperatur.class);
    }

    /**
     * Gets all instances of Aktuelle_Temperatur from the ontology.
     */
    public Collection<? extends Aktuelle_Temperatur> getAllAktuelle_TemperaturInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AKTUELLE_TEMPERATUR, DefaultAktuelle_Temperatur.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentTimeMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentTimeMeasurableInformation", CurrentTimeMeasurableInformation.class, DefaultCurrentTimeMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentlyRainingMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentlyRainingMeasurableInformation", CurrentlyRainingMeasurableInformation.class, DefaultCurrentlyRainingMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentlySunnyMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#CurrentlySunnyMeasurableInformation", CurrentlySunnyMeasurableInformation.class, DefaultCurrentlySunnyMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DateFormatContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DateFormatContextParameter", DateFormatContextParameter.class, DefaultDateFormatContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DeviceTypeMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DeviceTypeMeasurableInformation", Geräte_Typ.class, DefaultGeräte_Typ.class);
    }

    /**
     * Creates an instance of type Geräte_Typ.  Modifies the underlying ontology.
     */
    public Geräte_Typ createGeräte_Typ(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_GERÄTE_TYP, DefaultGeräte_Typ.class);
    }

    /**
     * Gets an instance of type Geräte_Typ with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Geräte_Typ getGeräte_Typ(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_GERÄTE_TYP, DefaultGeräte_Typ.class);
    }

    /**
     * Gets all instances of Geräte_Typ from the ontology.
     */
    public Collection<? extends Geräte_Typ> getAllGeräte_TypInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_GERÄTE_TYP, DefaultGeräte_Typ.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DistanceUnitContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#DistanceUnitContextParameter", DistanceUnitContextParameter.class, DefaultDistanceUnitContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#FinishedLearningUnitMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#FinishedLearningUnitMeasurableInformation", Abgeschlossene_Lerneinheit.class, DefaultAbgeschlossene_Lerneinheit.class);
    }

    /**
     * Creates an instance of type Abgeschlossene_Lerneinheit.  Modifies the underlying ontology.
     */
    public Abgeschlossene_Lerneinheit createAbgeschlossene_Lerneinheit(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_ABGESCHLOSSENE_LERNEINHEIT, DefaultAbgeschlossene_Lerneinheit.class);
    }

    /**
     * Gets an instance of type Abgeschlossene_Lerneinheit with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Abgeschlossene_Lerneinheit getAbgeschlossene_Lerneinheit(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_ABGESCHLOSSENE_LERNEINHEIT, DefaultAbgeschlossene_Lerneinheit.class);
    }

    /**
     * Gets all instances of Abgeschlossene_Lerneinheit from the ontology.
     */
    public Collection<? extends Abgeschlossene_Lerneinheit> getAllAbgeschlossene_LerneinheitInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_ABGESCHLOSSENE_LERNEINHEIT, DefaultAbgeschlossene_Lerneinheit.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#HasScreenReaderFunctionalityMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#HasScreenReaderFunctionalityMeasurableInformation", Bietet_Screenreader_Funktionalität.class, DefaultBietet_Screenreader_Funktionalität.class);
    }

    /**
     * Creates an instance of type Bietet_Screenreader_Funktionalität.  Modifies the underlying ontology.
     */
    public Bietet_Screenreader_Funktionalität createBietet_Screenreader_Funktionalität(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BIETET_SCREENREADER_FUNKTIONALITÄT, DefaultBietet_Screenreader_Funktionalität.class);
    }

    /**
     * Gets an instance of type Bietet_Screenreader_Funktionalität with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Bietet_Screenreader_Funktionalität getBietet_Screenreader_Funktionalität(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BIETET_SCREENREADER_FUNKTIONALITÄT, DefaultBietet_Screenreader_Funktionalität.class);
    }

    /**
     * Gets all instances of Bietet_Screenreader_Funktionalität from the ontology.
     */
    public Collection<? extends Bietet_Screenreader_Funktionalität> getAllBietet_Screenreader_FunktionalitätInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BIETET_SCREENREADER_FUNKTIONALITÄT, DefaultBietet_Screenreader_Funktionalität.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#IntervalConstraintTail
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#IntervalConstraintTail", IntervalConstraintTail.class, DefaultIntervalConstraintTail.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LatitudeContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LatitudeContextParameter", LatitudeContextParameter.class, DefaultLatitudeContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LearningUnitIDContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LearningUnitIDContextParameter", LearningUnitIDContextParameter.class, DefaultLearningUnitIDContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LocationContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LocationContext", LocationContext.class, DefaultLocationContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LocationContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LocationContextInformation", LocationContextInformation.class, DefaultLocationContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LongitudeContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#LongitudeContextParameter", LongitudeContextParameter.class, DefaultLongitudeContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#MeasurableContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#MeasurableContextInformation", MeasurableContextInformation.class, DefaultMeasurableContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#MixedContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#MixedContextInformation", MixedContextInformation.class, DefaultMixedContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#NextAppointmentMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#NextAppointmentMeasurableInformation", NextAppointmentMeasurableInformation.class, DefaultNextAppointmentMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ParameterizedContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ParameterizedContextInformation", ParameterizedContextInformation.class, DefaultParameterizedContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PersonalContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PersonalContext", PersonalContext.class, DefaultPersonalContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PersonalContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PersonalContextInformation", PersonalContextInformation.class, DefaultPersonalContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PhysicalContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PhysicalContext", PhysicalContext.class, DefaultPhysicalContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PhysicalContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PhysicalContextInformation", PhysicalContextInformation.class, DefaultPhysicalContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PressureUnitContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#PressureUnitContextParameter", PressureUnitContextParameter.class, DefaultPressureUnitContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RankingConstraintTail
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RankingConstraintTail", RankingConstraintTail.class, DefaultRankingConstraintTail.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictAudioPlaybackConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictAudioPlaybackConstraintHead", RestrictAudioPlaybackConstraintHead.class, DefaultRestrictAudioPlaybackConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictContentConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictContentConstraintHead", RestrictContentConstraintHead.class, DefaultRestrictContentConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictDataCaptureConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictDataCaptureConstraintHead", RestrictDataCaptureConstraintHead.class, DefaultRestrictDataCaptureConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictRelationsConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictRelationsConstraintHead", RestrictRelationsConstraintHead.class, DefaultRestrictRelationsConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictUsageConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictUsageConstraintHead", RestrictUsageConstraintHead.class, DefaultRestrictUsageConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictVideoPlaybackConstraintHead
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#RestrictVideoPlaybackConstraintHead", RestrictVideoPlaybackConstraintHead.class, DefaultRestrictVideoPlaybackConstraintHead.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ScenarioContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ScenarioContext", ScenarioContext.class, DefaultScenarioContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ScenarioContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#ScenarioContextInformation", ScenarioContextInformation.class, DefaultScenarioContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#SituationalContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#SituationalContext", SituationalContext.class, DefaultSituationalContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#SituationalContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#SituationalContextInformation", SituationalContextInformation.class, DefaultSituationalContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetLatitudeContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetLatitudeContextParameter", Breitengrad_des_Zielortes.class, DefaultBreitengrad_des_Zielortes.class);
    }

    /**
     * Creates an instance of type Breitengrad_des_Zielortes.  Modifies the underlying ontology.
     */
    public Breitengrad_des_Zielortes createBreitengrad_des_Zielortes(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BREITENGRAD_DES_ZIELORTES, DefaultBreitengrad_des_Zielortes.class);
    }

    /**
     * Gets an instance of type Breitengrad_des_Zielortes with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Breitengrad_des_Zielortes getBreitengrad_des_Zielortes(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BREITENGRAD_DES_ZIELORTES, DefaultBreitengrad_des_Zielortes.class);
    }

    /**
     * Gets all instances of Breitengrad_des_Zielortes from the ontology.
     */
    public Collection<? extends Breitengrad_des_Zielortes> getAllBreitengrad_des_ZielortesInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BREITENGRAD_DES_ZIELORTES, DefaultBreitengrad_des_Zielortes.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetLongitudeContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetLongitudeContextParameter", Längengrad_des_Zielortes.class, DefaultLängengrad_des_Zielortes.class);
    }

    /**
     * Creates an instance of type Längengrad_des_Zielortes.  Modifies the underlying ontology.
     */
    public Längengrad_des_Zielortes createLängengrad_des_Zielortes(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LÄNGENGRAD_DES_ZIELORTES, DefaultLängengrad_des_Zielortes.class);
    }

    /**
     * Gets an instance of type Längengrad_des_Zielortes with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Längengrad_des_Zielortes getLängengrad_des_Zielortes(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LÄNGENGRAD_DES_ZIELORTES, DefaultLängengrad_des_Zielortes.class);
    }

    /**
     * Gets all instances of Längengrad_des_Zielortes from the ontology.
     */
    public Collection<? extends Längengrad_des_Zielortes> getAllLängengrad_des_ZielortesInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LÄNGENGRAD_DES_ZIELORTES, DefaultLängengrad_des_Zielortes.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetTimestampContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TargetTimestampContextParameter", TargetTimestampContextParameter.class, DefaultTargetTimestampContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TechnicalContext
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TechnicalContext", TechnicalContext.class, DefaultTechnicalContext.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TechnicalContextInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TechnicalContextInformation", TechnicalContextInformation.class, DefaultTechnicalContextInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TemperatureScaleContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TemperatureScaleContextParameter", TemperatureScaleContextParameter.class, DefaultTemperatureScaleContextParameter.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TimeUntilTimestampMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#TimeUntilTimestampMeasurableInformation", TimeUntilTimestampMeasurableInformation.class, DefaultTimeUntilTimestampMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDestinationMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDestinationMeasurableInformation", UserDestinationMeasurableInformation.class, DefaultUserDestinationMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDidArriveAtLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDidArriveAtLocationMeasurableInformation", Benutzer_ist_an_Position_angekommen.class, DefaultBenutzer_ist_an_Position_angekommen.class);
    }

    /**
     * Creates an instance of type Benutzer_ist_an_Position_angekommen.  Modifies the underlying ontology.
     */
    public Benutzer_ist_an_Position_angekommen createBenutzer_ist_an_Position_angekommen(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_IST_AN_POSITION_ANGEKOMMEN, DefaultBenutzer_ist_an_Position_angekommen.class);
    }

    /**
     * Gets an instance of type Benutzer_ist_an_Position_angekommen with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Benutzer_ist_an_Position_angekommen getBenutzer_ist_an_Position_angekommen(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_IST_AN_POSITION_ANGEKOMMEN, DefaultBenutzer_ist_an_Position_angekommen.class);
    }

    /**
     * Gets all instances of Benutzer_ist_an_Position_angekommen from the ontology.
     */
    public Collection<? extends Benutzer_ist_an_Position_angekommen> getAllBenutzer_ist_an_Position_angekommenInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BENUTZER_IST_AN_POSITION_ANGEKOMMEN, DefaultBenutzer_ist_an_Position_angekommen.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDidLeaveLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserDidLeaveLocationMeasurableInformation", Benutzer_hat_Position_verlassen.class, DefaultBenutzer_hat_Position_verlassen.class);
    }

    /**
     * Creates an instance of type Benutzer_hat_Position_verlassen.  Modifies the underlying ontology.
     */
    public Benutzer_hat_Position_verlassen createBenutzer_hat_Position_verlassen(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_HAT_POSITION_VERLASSEN, DefaultBenutzer_hat_Position_verlassen.class);
    }

    /**
     * Gets an instance of type Benutzer_hat_Position_verlassen with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Benutzer_hat_Position_verlassen getBenutzer_hat_Position_verlassen(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_HAT_POSITION_VERLASSEN, DefaultBenutzer_hat_Position_verlassen.class);
    }

    /**
     * Gets all instances of Benutzer_hat_Position_verlassen from the ontology.
     */
    public Collection<? extends Benutzer_hat_Position_verlassen> getAllBenutzer_hat_Position_verlassenInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BENUTZER_HAT_POSITION_VERLASSEN, DefaultBenutzer_hat_Position_verlassen.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserIsAtLocationMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserIsAtLocationMeasurableInformation", Benutzer_befindet_sich_an_Position.class, DefaultBenutzer_befindet_sich_an_Position.class);
    }

    /**
     * Creates an instance of type Benutzer_befindet_sich_an_Position.  Modifies the underlying ontology.
     */
    public Benutzer_befindet_sich_an_Position createBenutzer_befindet_sich_an_Position(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_BEFINDET_SICH_AN_POSITION, DefaultBenutzer_befindet_sich_an_Position.class);
    }

    /**
     * Gets an instance of type Benutzer_befindet_sich_an_Position with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Benutzer_befindet_sich_an_Position getBenutzer_befindet_sich_an_Position(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BENUTZER_BEFINDET_SICH_AN_POSITION, DefaultBenutzer_befindet_sich_an_Position.class);
    }

    /**
     * Gets all instances of Benutzer_befindet_sich_an_Position from the ontology.
     */
    public Collection<? extends Benutzer_befindet_sich_an_Position> getAllBenutzer_befindet_sich_an_PositionInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BENUTZER_BEFINDET_SICH_AN_POSITION, DefaultBenutzer_befindet_sich_an_Position.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationAddressMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationAddressMeasurableInformation", Aktuelle_Adresse_des_Benutzers.class, DefaultAktuelle_Adresse_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Aktuelle_Adresse_des_Benutzers.  Modifies the underlying ontology.
     */
    public Aktuelle_Adresse_des_Benutzers createAktuelle_Adresse_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_ADRESSE_DES_BENUTZERS, DefaultAktuelle_Adresse_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Aktuelle_Adresse_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Aktuelle_Adresse_des_Benutzers getAktuelle_Adresse_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_ADRESSE_DES_BENUTZERS, DefaultAktuelle_Adresse_des_Benutzers.class);
    }

    /**
     * Gets all instances of Aktuelle_Adresse_des_Benutzers from the ontology.
     */
    public Collection<? extends Aktuelle_Adresse_des_Benutzers> getAllAktuelle_Adresse_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AKTUELLE_ADRESSE_DES_BENUTZERS, DefaultAktuelle_Adresse_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationBuildingMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationBuildingMeasurableInformation", Gebäude_in_dem_sich_der_Benutzer_befindet.class, DefaultGebäude_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Creates an instance of type Gebäude_in_dem_sich_der_Benutzer_befindet.  Modifies the underlying ontology.
     */
    public Gebäude_in_dem_sich_der_Benutzer_befindet createGebäude_in_dem_sich_der_Benutzer_befindet(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_GEBÄUDE_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultGebäude_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Gets an instance of type Gebäude_in_dem_sich_der_Benutzer_befindet with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Gebäude_in_dem_sich_der_Benutzer_befindet getGebäude_in_dem_sich_der_Benutzer_befindet(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_GEBÄUDE_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultGebäude_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Gets all instances of Gebäude_in_dem_sich_der_Benutzer_befindet from the ontology.
     */
    public Collection<? extends Gebäude_in_dem_sich_der_Benutzer_befindet> getAllGebäude_in_dem_sich_der_Benutzer_befindetInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_GEBÄUDE_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultGebäude_in_dem_sich_der_Benutzer_befindet.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationCountryMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationCountryMeasurableInformation", Land_in_dem_sich_der_Benutzer_befindet.class, DefaultLand_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Creates an instance of type Land_in_dem_sich_der_Benutzer_befindet.  Modifies the underlying ontology.
     */
    public Land_in_dem_sich_der_Benutzer_befindet createLand_in_dem_sich_der_Benutzer_befindet(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LAND_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultLand_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Gets an instance of type Land_in_dem_sich_der_Benutzer_befindet with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Land_in_dem_sich_der_Benutzer_befindet getLand_in_dem_sich_der_Benutzer_befindet(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LAND_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultLand_in_dem_sich_der_Benutzer_befindet.class);
    }

    /**
     * Gets all instances of Land_in_dem_sich_der_Benutzer_befindet from the ontology.
     */
    public Collection<? extends Land_in_dem_sich_der_Benutzer_befindet> getAllLand_in_dem_sich_der_Benutzer_befindetInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LAND_IN_DEM_SICH_DER_BENUTZER_BEFINDET, DefaultLand_in_dem_sich_der_Benutzer_befindet.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationDistanceMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationDistanceMeasurableInformation", Entfernung_des_Benutzers_zu_einer_Position.class, DefaultEntfernung_des_Benutzers_zu_einer_Position.class);
    }

    /**
     * Creates an instance of type Entfernung_des_Benutzers_zu_einer_Position.  Modifies the underlying ontology.
     */
    public Entfernung_des_Benutzers_zu_einer_Position createEntfernung_des_Benutzers_zu_einer_Position(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_ENTFERNUNG_DES_BENUTZERS_ZU_EINER_POSITION, DefaultEntfernung_des_Benutzers_zu_einer_Position.class);
    }

    /**
     * Gets an instance of type Entfernung_des_Benutzers_zu_einer_Position with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Entfernung_des_Benutzers_zu_einer_Position getEntfernung_des_Benutzers_zu_einer_Position(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_ENTFERNUNG_DES_BENUTZERS_ZU_EINER_POSITION, DefaultEntfernung_des_Benutzers_zu_einer_Position.class);
    }

    /**
     * Gets all instances of Entfernung_des_Benutzers_zu_einer_Position from the ontology.
     */
    public Collection<? extends Entfernung_des_Benutzers_zu_einer_Position> getAllEntfernung_des_Benutzers_zu_einer_PositionInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_ENTFERNUNG_DES_BENUTZERS_ZU_EINER_POSITION, DefaultEntfernung_des_Benutzers_zu_einer_Position.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationLatitudeMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationLatitudeMeasurableInformation", Aktueller_Breitengrad_des_Benutzers.class, DefaultAktueller_Breitengrad_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Aktueller_Breitengrad_des_Benutzers.  Modifies the underlying ontology.
     */
    public Aktueller_Breitengrad_des_Benutzers createAktueller_Breitengrad_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AKTUELLER_BREITENGRAD_DES_BENUTZERS, DefaultAktueller_Breitengrad_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Aktueller_Breitengrad_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Aktueller_Breitengrad_des_Benutzers getAktueller_Breitengrad_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AKTUELLER_BREITENGRAD_DES_BENUTZERS, DefaultAktueller_Breitengrad_des_Benutzers.class);
    }

    /**
     * Gets all instances of Aktueller_Breitengrad_des_Benutzers from the ontology.
     */
    public Collection<? extends Aktueller_Breitengrad_des_Benutzers> getAllAktueller_Breitengrad_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AKTUELLER_BREITENGRAD_DES_BENUTZERS, DefaultAktueller_Breitengrad_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationLongitudeMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationLongitudeMeasurableInformation", Aktueller_Längengrad_des_Benutzers.class, DefaultAktueller_Längengrad_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Aktueller_Längengrad_des_Benutzers.  Modifies the underlying ontology.
     */
    public Aktueller_Längengrad_des_Benutzers createAktueller_Längengrad_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AKTUELLER_LÄNGENGRAD_DES_BENUTZERS, DefaultAktueller_Längengrad_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Aktueller_Längengrad_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Aktueller_Längengrad_des_Benutzers getAktueller_Längengrad_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AKTUELLER_LÄNGENGRAD_DES_BENUTZERS, DefaultAktueller_Längengrad_des_Benutzers.class);
    }

    /**
     * Gets all instances of Aktueller_Längengrad_des_Benutzers from the ontology.
     */
    public Collection<? extends Aktueller_Längengrad_des_Benutzers> getAllAktueller_Längengrad_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AKTUELLER_LÄNGENGRAD_DES_BENUTZERS, DefaultAktueller_Längengrad_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationRegionMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserLocationRegionMeasurableInformation", Aktuelle_Position_des_Benutzers.class, DefaultAktuelle_Position_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Aktuelle_Position_des_Benutzers.  Modifies the underlying ontology.
     */
    public Aktuelle_Position_des_Benutzers createAktuelle_Position_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_POSITION_DES_BENUTZERS, DefaultAktuelle_Position_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Aktuelle_Position_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Aktuelle_Position_des_Benutzers getAktuelle_Position_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_AKTUELLE_POSITION_DES_BENUTZERS, DefaultAktuelle_Position_des_Benutzers.class);
    }

    /**
     * Gets all instances of Aktuelle_Position_des_Benutzers from the ontology.
     */
    public Collection<? extends Aktuelle_Position_des_Benutzers> getAllAktuelle_Position_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_AKTUELLE_POSITION_DES_BENUTZERS, DefaultAktuelle_Position_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserMeansOfTransportationMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserMeansOfTransportationMeasurableInformation", Fortbewegungsmittel_des_Benutzers.class, DefaultFortbewegungsmittel_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Fortbewegungsmittel_des_Benutzers.  Modifies the underlying ontology.
     */
    public Fortbewegungsmittel_des_Benutzers createFortbewegungsmittel_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_FORTBEWEGUNGSMITTEL_DES_BENUTZERS, DefaultFortbewegungsmittel_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Fortbewegungsmittel_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Fortbewegungsmittel_des_Benutzers getFortbewegungsmittel_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_FORTBEWEGUNGSMITTEL_DES_BENUTZERS, DefaultFortbewegungsmittel_des_Benutzers.class);
    }

    /**
     * Gets all instances of Fortbewegungsmittel_des_Benutzers from the ontology.
     */
    public Collection<? extends Fortbewegungsmittel_des_Benutzers> getAllFortbewegungsmittel_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_FORTBEWEGUNGSMITTEL_DES_BENUTZERS, DefaultFortbewegungsmittel_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserMovementSpeedMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserMovementSpeedMeasurableInformation", Fortbewegungsgeschwindigkeit_des_Benutzers.class, DefaultFortbewegungsgeschwindigkeit_des_Benutzers.class);
    }

    /**
     * Creates an instance of type Fortbewegungsgeschwindigkeit_des_Benutzers.  Modifies the underlying ontology.
     */
    public Fortbewegungsgeschwindigkeit_des_Benutzers createFortbewegungsgeschwindigkeit_des_Benutzers(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_FORTBEWEGUNGSGESCHWINDIGKEIT_DES_BENUTZERS, DefaultFortbewegungsgeschwindigkeit_des_Benutzers.class);
    }

    /**
     * Gets an instance of type Fortbewegungsgeschwindigkeit_des_Benutzers with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Fortbewegungsgeschwindigkeit_des_Benutzers getFortbewegungsgeschwindigkeit_des_Benutzers(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_FORTBEWEGUNGSGESCHWINDIGKEIT_DES_BENUTZERS, DefaultFortbewegungsgeschwindigkeit_des_Benutzers.class);
    }

    /**
     * Gets all instances of Fortbewegungsgeschwindigkeit_des_Benutzers from the ontology.
     */
    public Collection<? extends Fortbewegungsgeschwindigkeit_des_Benutzers> getAllFortbewegungsgeschwindigkeit_des_BenutzersInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_FORTBEWEGUNGSGESCHWINDIGKEIT_DES_BENUTZERS, DefaultFortbewegungsgeschwindigkeit_des_Benutzers.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserRoleMeasurableInformation
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#UserRoleMeasurableInformation", UserRoleMeasurableInformation.class, DefaultUserRoleMeasurableInformation.class);
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
     * Class http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#VelocityUnitContextParameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#VelocityUnitContextParameter", VelocityUnitContextParameter.class, DefaultVelocityUnitContextParameter.class);
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


}
