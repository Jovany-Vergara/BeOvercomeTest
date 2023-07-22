package com.overcome.test;

import com.overcome.test.service.TicketEntityService;

public class ServiceFactory {

	protected static volatile ServiceFactory instance;
	protected ServiceFactory() {}
	
	public static ServiceFactory getInstance() {
		if (instance == null) {
			synchronized (ServiceFactory.class) {
				instance = new ServiceFactory();
			}
		}
		return instance;
	}
	
	private TicketEntityService ticketEntityService;
	
	public void setTicketEntityService(TicketEntityService ticketEntityService) {
		this.ticketEntityService = ticketEntityService;
	}
	public TicketEntityService getTicketEntityService() {
		return ticketEntityService;
	}
}
