package com.overcome.test.command;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import com.overcome.test.entity.TicketEntity;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TicketCommand {
  List<TicketEntity> tickets;
  Integer size;
  public TicketCommand(List<TicketEntity> tickets, Integer size) {
    this.tickets = tickets;
    this.size = size;
  }
}
