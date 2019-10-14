package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;

public abstract class SaveController extends Controller implements VisitableController {

	public SaveController(Session session) {
		super(session);
	}

	public abstract void save(String name);

	public abstract void save();

	public abstract void next();

	public abstract boolean hasName();

	public abstract boolean exists(String readString);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
