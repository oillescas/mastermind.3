package dev.illescas.mastermind.controllers;


public interface ControllersVisitor {
	
	void visit(StartController startController);
	void visit(ResumeController continueController);
	void visit(SaveController saveController);
	void visit(PlayController continueController);
}
