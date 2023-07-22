package com.overcome.test.command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketCommandCreate {

  String title;
  String responsableName;
  String responsibleTeam;
  String incidentType;
  String incidenceSeverity;
  String versionSoftware;
  String problemDescription;
  String uploadFile;
}
