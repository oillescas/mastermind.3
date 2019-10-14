package dev.illescas.mastermind.controllers.impl;

import dev.illescas.mastermind.controllers.ResumeController;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;

public class ResumeControllerImpl extends ResumeController {

	public ResumeControllerImpl(Session session) {
		super(session);
	}
	
	public void resume(boolean newGame) {
		if (newGame) {
			((SessionImpl) this.session).clear();
		} else {
			((SessionImpl) this.session).getState().next();
		}
	}

}
