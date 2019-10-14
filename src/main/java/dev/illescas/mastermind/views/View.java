package dev.illescas.mastermind.views;

import dev.illescas.mastermind.controllers.ControllersVisitor;
import dev.illescas.mastermind.controllers.VisitableController;

public abstract class View implements ControllersVisitor {
	
	public void interact(VisitableController controller) {
		controller.accept(this);
	}

}
