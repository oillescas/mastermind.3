package dev.illescas.mastermind.controllers.impl;

import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;

public class StartControllerImpl extends StartController {
	
	private SessionImplDAO sessionImplDAO;

	public StartControllerImpl(Session session, SessionImplDAO sessionImplDAO) {
		super(session);
		this.sessionImplDAO = sessionImplDAO;
	}
	
	@Override
	public void start() { //TODO por que ??
		((SessionImpl)this.session).clear();
		((SessionImpl)this.session).registry();
		this.sessionImplDAO.associate((SessionImpl)this.session);
		((SessionImpl) this.session).getState().next(); //Habría que encapsular el metodo en la session. 
	}

	@Override
	public void start(String name) {
		this.sessionImplDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplDAO.getGamesNames();
	}
}
