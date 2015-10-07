package de.unipotsdam.rulegenerator.statistics;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class Reason {

    private String action;
    private RDFNode user;
    private RDFNode actionTime;
    private RDFNode recordedContextInformation;
    private RDFNode recordedTime;
    private RDFNode recordedCID;
    private RDFNode recordedValue;
    private RDFNode learningUnit;
    private RDFNode metaDataProperty;
    private RDFNode metaDataValue;

    public String getAction() { return action; }

    public void setAction(String action) {
        this.action = action;
    }

    public RDFNode getUser() {
        return user;
    }

    public void setUser(RDFNode user) {
        this.user = user;
    }

    public RDFNode getActionTime() {
        return actionTime;
    }

    public void setActionTime(RDFNode actionTime) {
        this.actionTime = actionTime;
    }

    public RDFNode getRecordedContextInformation() {
        return recordedContextInformation;
    }

    public void setRecordedContextInformation(RDFNode recordedContextInformation) {
        this.recordedContextInformation = recordedContextInformation;
    }

    public RDFNode getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(RDFNode recordedTime) {
        this.recordedTime = recordedTime;
    }


    public RDFNode getRecordedCID() {
        return recordedCID;
    }

    public void setRecordedCID(RDFNode recordedCID) {
        this.recordedCID = recordedCID;
    }

    public RDFNode getRecordedValue() {
        return recordedValue;
    }

    public void setRecordedValue(RDFNode recordedValue) {
        this.recordedValue = recordedValue;
    }

    public RDFNode getLearningUnit() {
        return learningUnit;
    }

    public void setLearningUnit(RDFNode learningUnit) {
        this.learningUnit = learningUnit;
    }

    public RDFNode getMetaDataProperty() {
        return metaDataProperty;
    }

    public void setMetaDataProperty(RDFNode metaDataProperty) {
        this.metaDataProperty = metaDataProperty;
    }

    public RDFNode getMetaDataValue() {
        return metaDataValue;
    }

    public void setMetaDataValue(RDFNode metaDataValue) {
        this.metaDataValue = metaDataValue;
    }

}