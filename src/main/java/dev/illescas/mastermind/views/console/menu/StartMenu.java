package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.StartController;

public class StartMenu extends Menu {

	public StartMenu(StartController controller) {
		this.addCommand(new NewGameCommand(controller));
		this.addCommand(new OpenGameCommand(controller));
	}
}
