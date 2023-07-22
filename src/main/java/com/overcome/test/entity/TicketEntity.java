package com.overcome.test.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {

  public TicketEntity(String title) {
    this.title = title;
  }

  public TicketEntity(String title, String responsableName, String responsibleTeam, String incidentType,
    String incidenceSeverity, String versionSoftware, String problemDescription, String uploadFile) {
    this.title = title;
    this.createDate = new Date();
    this.responsableName = responsableName;
    this.responsibleTeam = responsibleTeam;
    this.incidentType = incidentType;
    this.incidenceSeverity = incidenceSeverity;
    this.versionSoftware = versionSoftware;
    this.problemDescription = problemDescription;
    this.uploadFile = uploadFile;
    this.status = "created";
  }

  @Id Long id;
  String title;
  Date createDate;
  String responsableName;
  String responsibleTeam;
  String incidentType;
  String incidenceSeverity;
  String versionSoftware;
  String problemDescription;
  String uploadFile;
  String status;

  @Override
  public String toString() {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    return "TicketEntity [id=" + id + ", title=" + title + ", date=" + simpleDateFormat.format(createDate) + ", responsableName=" + responsableName
        + ", responsibleTeam=" + responsibleTeam + ", incidentType=" + incidentType + ", incidenceSeverity="
        + incidenceSeverity + ", versionSoftware=" + versionSoftware + ", problemDescription=" + problemDescription + " uploadFile=" + uploadFile + "]";
  }
}
