package com.overcome.test.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

  @Override
  public String toString() {
    return "TicketEntity [id=" + id + ", title=" + title + ", date=" + date + ", responsableName=" + responsableName
        + ", responsibleTeam=" + responsibleTeam + ", incidentType=" + incidentType + ", incidenceSeverity="
        + incidenceSeverity + ", problemDescription=" + problemDescription + "]";
  }
}
