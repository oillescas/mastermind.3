package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;

public abstract class StartController extends Controller implements VisitableController {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public abstract String[] getGamesNames();

	public abstract void start(String title);


}