package dev.illescas.mastermind.controllers.impl;

import dev.illescas.mastermind.controllers.SaveController;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;

public class SaveControllerImpl extends SaveController {

	private SessionImplDAO sessionImplDAO;

	SaveControllerImpl(Session session, SessionImplDAO sessionImplDAO) {
		super(session);
		this.sessionImplDAO = sessionImplDAO;
	}

	@Override
	public void save(String name) {
		this.sessionImplDAO.save(name);
	}

	@Override
	public void save() {
		this.sessionImplDAO.save();
	}

	@Override
	public void next() {
		((SessionImpl) this.session).nextState();
	}

	@Override
	public boolean hasName() {
		return ((SessionImpl) this.session).hasName();
	}

	@Override
	public boolean exists(String name) {
		return this.sessionImplDAO.exists(name);
	}

}
