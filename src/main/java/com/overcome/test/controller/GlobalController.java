package com.overcome.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.objectify.ObjectifyService;
import com.overcome.test.entity.ExampleEntity;

import com.overcome.test.service.ExampleEntityService;

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

	@RequestMapping("/ticket")
  public ModelAndView ticket() {
		ModelAndView modelAndView = new ModelAndView("page.ticket");
    ExampleEntity e = ObjectifyService.ofy().cache(true).load().type(ExampleEntity.class).id(22323L).now();
		modelAndView.addObject("example", e);
		System.out.println(e.toString());

		return modelAndView;
  }

	@PostMapping("/create")
  public ModelAndView createTicket(@RequestBody MultiValueMap<String, String> formData) {
		System.out.println("*++++++++++++++" +10);
		System.out.println(formData.get("title").toString());
		System.out.println(formData);
		ModelAndView modelAndView = new ModelAndView("page.list");

		return modelAndView;
  }
}
