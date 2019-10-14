package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.Controller;
import santaTecla.utils.WithConsoleView;

public abstract class Command extends WithConsoleView {

	protected String title;

	protected Controller acceptorController;

	public Command(String title, Controller acceptorController) {
		this.acceptorController = acceptorController;
		this.title = title;
	}

	public abstract boolean isActive();


	public String getTitle() {
		return this.title;
	}
	
	protected abstract void execute();

}

