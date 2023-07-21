package com.overcome.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.googlecode.objectify.ObjectifyService;
import com.overcome.test.entity.TicketEntity;
import com.overcome.test.service.ExampleEntityService;
import com.overcome.test.command.TicketCommand;

@Controller 
public class GlobalController {

	@Autowired
	ExampleEntityService exampleEntityService;

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("page.login");
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		//ObjectifyService.ofy().save().entity(new ExampleEntity(22323L, "Diego"));
		return new ModelAndView("page.create");
	}

	@RequestMapping("/ticket/{id}")
  public ModelAndView ticket(@PathVariable Long id) {
		System.out.println("*++++++++++++++***************");
		System.out.println(id);
		ModelAndView modelAndView = new ModelAndView("page.ticket");
    TicketEntity ticket = ObjectifyService.ofy().cache(true).load().type(TicketEntity.class).id(id).now();
		modelAndView.addObject("ticket", ticket);

		return modelAndView;
  }

	@PostMapping("/create")
  public RedirectView createTicket(@RequestBody MultiValueMap<String, String> formData) {
		System.out.println("*++++++++++++++***************");
		System.out.println(formData.get("title").toString());
		System.out.println(formData);
		TicketEntity ticketEntity = new TicketEntity(
			formData.get("title").toString(),
			formData.get("responsableName").toString(),
			formData.get("responsibleTeam").toString(),
			formData.get("incidentType").toString(),
			formData.get("incidenceSeverity").toString(),
			formData.get("versionSoftware").toString(),
			formData.get("problemDescription").toString(),
			formData.get("uploadFile").toString()
			);
		//TicketEntity ticketEntity = new TicketEntity("title");
		ObjectifyService.ofy().save().entity(ticketEntity);

		System.out.println(ticketEntity.toString());
		System.out.println("****************");
		//TicketEntity ticketEntity = new TicketEntity(
		//	formData.get("description").toString()
		//	);
		//System.out.println(ticketEntity.toString());

		return new RedirectView("tickets");
  }

	@RequestMapping("/tickets")
  public ModelAndView tickets() {
		ModelAndView modelAndView = new ModelAndView("page.list");
		List<TicketEntity> tickets = ObjectifyService.ofy().load().type(TicketEntity.class).list();
		System.out.println("****************");
		System.out.println(tickets.size());
		//Map<String, List<TicketEntity>> rightHereMap = new HashMap<String, List<TicketEntity>>();
		//rightHereMap.put("tickets", tickets);
		TicketCommand command = new TicketCommand(tickets, tickets.size());
		//ObjectifyService.ofy().delete().entities(tickets);
		modelAndView.addObject("listTickets", tickets);
		modelAndView.addObject("size", tickets.size());
		modelAndView.addObject("command", command);

		return modelAndView;
  }
}
