package dev.illescas.mastermind.controllers;


import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void exit() {
		((SessionImpl) this.session).nextState();
	}

}
