package dev.illescas.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.StateValue;

public class Logic {
	
	protected Session session;
	
	protected Map<StateValue, VisitableController> controllers;
		
	public Logic() {
		this.controllers = new HashMap<StateValue, VisitableController>();
	}
	
	public VisitableController getController() {
		return this.controllers.get(this.session.getValueState());
	}
	
}
