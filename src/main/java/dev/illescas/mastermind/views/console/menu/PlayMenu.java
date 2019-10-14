package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.PlayController;

public class PlayMenu extends Menu {

	public PlayMenu(PlayController controller) {
		super();
		this.addCommand(new ProposeCommand(controller));
		this.addCommand(new UndoCommand(controller));
		this.addCommand(new RedoCommand(controller));
		this.addCommand(new ExitCommand(controller));
	}

}

