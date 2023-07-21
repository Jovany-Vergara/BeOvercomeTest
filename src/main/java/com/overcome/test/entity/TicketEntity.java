package com.overcome.test.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class TicketEntity {

	public TicketEntity() {
  }

  public TicketEntity(String title) {
    this.title = title;
  }

  public TicketEntity(String title, String date, String responsableName, String responsibleTeam, String incidentType,
    String incidenceSeverity, String problemDescription) {
    this.title = title;
    this.date = date;
    this.responsableName = responsableName;
    this.responsibleTeam = responsibleTeam;
    this.incidentType = incidentType;
    this.incidenceSeverity = incidenceSeverity;
    this.problemDescription = problemDescription;
  }
  @Id Long id;
  String title;
  String date;
  String responsableName;
  String responsibleTeam;
  String incidentType;
  String incidenceSeverity;
  String problemDescription;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getResponsableName() {
    return responsableName;
  }

  public void setResponsableName(String responsableName) {
    this.responsableName = responsableName;
  }

  public String getResponsibleTeam() {
    return responsibleTeam;
  }

  public void setResponsibleTeam(String responsibleTeam) {
    this.responsibleTeam = responsibleTeam;
  }

  public String getIncidentType() {
    return incidentType;
  }

  public void setIncidentType(String incidentType) {
    this.incidentType = incidentType;
  }

  public String getIncidenceSeverity() {
    return incidenceSeverity;
  }

  public void setIncidenceSeverity(String incidenceSeverity) {
    this.incidenceSeverity = incidenceSeverity;
  }

  public String getProblemDescription() {
    return problemDescription;
  }

  public void setProblemDescription(String problemDescription) {
    this.problemDescription = problemDescription;
  }

  @Override
  public String toString() {
    return "TicketEntity [id=" + id + ", title=" + title + ", date=" + date + ", responsableName=" + responsableName
        + ", responsibleTeam=" + responsibleTeam + ", incidentType=" + incidentType + ", incidenceSeverity="
        + incidenceSeverity + ", problemDescription=" + problemDescription + "]";
  }
}
