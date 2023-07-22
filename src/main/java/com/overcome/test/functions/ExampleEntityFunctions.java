package com.overcome.test.functions;

import java.util.logging.Logger;

import com.overcome.test.ServiceFactory;
import com.overcome.test.service.TicketEntityService;

public class ExampleEntityFunctions {
	private TicketEntityService ticketEntityService = ServiceFactory.getInstance().getTicketEntityService();
	private static final Logger logger = Logger.getLogger(ExampleEntityFunctions.class.getName());
	
	
}
