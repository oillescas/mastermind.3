package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;

public abstract class ResumeController extends Controller implements VisitableController {

	public ResumeController(Session session) {
		super(session);
	}

	public abstract void resume(boolean newGame) ;

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}