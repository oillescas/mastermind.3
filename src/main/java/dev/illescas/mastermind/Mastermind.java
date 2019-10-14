package dev.illescas.mastermind;

import dev.illescas.mastermind.controllers.Logic;
import dev.illescas.mastermind.controllers.VisitableController;
import dev.illescas.mastermind.views.View;

public abstract class Mastermind {
	
	private Logic logic;
	
	private View view;
	
	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = this.createView();
	}
	
	protected abstract View createView();
	protected abstract Logic createLogic();

	protected void play() {
		VisitableController controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.view.interact(controller);
			}
		} while (controller != null); 
	}
	
}

