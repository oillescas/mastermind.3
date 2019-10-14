package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.StateValue;


public abstract class Controller {

	protected Session session;

	public Controller(Session session) {
		this.session = session;
	}
	
	public int getWidth() {
		return this.session.getWidthConbination();
	}
	
	public StateValue getValueState() {
		return this.session.getValueState();
	}
	
	public String getName() {
		return this.session.getSessionName();
	}
	
	public void setName(String name) {
		this.session.setSessionName(name);
	}

}
