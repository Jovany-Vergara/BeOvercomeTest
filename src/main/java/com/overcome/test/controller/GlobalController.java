package com.overcome.test.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.googlecode.objectify.ObjectifyService;
import com.overcome.test.entity.TicketEntity;
import com.overcome.test.service.TicketEntityService;
import com.overcome.test.command.TicketCommand;
import com.overcome.test.ServiceFactory;
import java.util.stream.Collectors;

@Controller
public class GlobalController {

	TicketEntityService ticketEntityService = ServiceFactory.getInstance().getTicketEntityService();

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("page.login");
	}

	@RequestMapping("/")
	public ModelAndView home(){
		return new ModelAndView("page.create");
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		return new ModelAndView("page.create");
	}

	@RequestMapping("/ticket/{id}")
  public ModelAndView ticket(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("page.ticket");
    TicketEntity ticket = ObjectifyService.ofy().cache(true).load().type(TicketEntity.class).id(id).now();
		modelAndView.addObject("ticket", ticket);

		return modelAndView;
  }

	@PostMapping("/create")
  public RedirectView createTicket(@RequestBody MultiValueMap<String, String> formData) {
		TicketEntity ticketEntity = new TicketEntity(
			formData.get("title").get(0).toString(),
			formData.get("responsableName").get(0).toString(),
			formData.get("responsibleTeam").get(0).toString(),
			formData.get("incidentType").get(0).toString(),
			formData.get("incidenceSeverity").get(0).toString(),
			formData.get("versionSoftware").get(0).toString(),
			formData.get("problemDescription").get(0).toString(),
			formData.get("uploadFile").get(0).toString()
			);
		ticketEntityService.save(ticketEntity);

		return new RedirectView("tickets");
  }

	@RequestMapping("/tickets")
  public ModelAndView tickets() {
		List<String> statusIn = new ArrayList<String>();
		statusIn.add("created");
		statusIn.add("process");
		statusIn.add("attend");
		ModelAndView modelAndView = new ModelAndView("page.list");
    List<TicketEntity> tickets = ObjectifyService.ofy().load().type(TicketEntity.class).filter("status in", statusIn).list();
		TicketCommand command = new TicketCommand(tickets, tickets.size());
		modelAndView.addObject("listTickets", tickets);
		modelAndView.addObject("size", tickets.size());
		modelAndView.addObject("command", command);

		return modelAndView;
  }

	@PostMapping("/archived")
	public RedirectView archived(@RequestParam Long id) {
    TicketEntity ticket = ObjectifyService.ofy().load().type(TicketEntity.class).id(id).now();
		ticket.setStatus("archived");
		ticketEntityService.save(ticket);
		return new RedirectView("tickets");
	}

	@RequestMapping ("/archived")
  public ModelAndView archived() {
      ModelAndView modelAndView = new ModelAndView("page.list");
			// Not working
    	List<TicketEntity> tickets = ObjectifyService.ofy().load().type(TicketEntity.class).filter("status =", "archived").list();
      TicketCommand command = new TicketCommand(tickets, tickets.size());
      modelAndView.addObject("listTickets", tickets);
      modelAndView.addObject("size", tickets.size());
      modelAndView.addObject("command", command);

      return modelAndView;
    }

	@PostMapping("/updateStatus")
	public RedirectView updateStatus(@RequestBody MultiValueMap<String, String> formData) {
		Long idTicket = Long.parseLong(formData.get("id").get(0));
    TicketEntity ticket = ObjectifyService.ofy().load().type(TicketEntity.class).id(idTicket).now();
		ticket.setStatus(formData.get("status").get(0).toString());
		ticketEntityService.save(ticket);
		return new RedirectView("tickets");
	}
}
