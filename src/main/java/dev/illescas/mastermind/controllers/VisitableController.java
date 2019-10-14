package dev.illescas.mastermind.controllers;

public interface VisitableController {
	public void accept(ControllersVisitor controllersVisitor);
}
