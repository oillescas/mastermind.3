package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.views.MessageView;

class ExitCommand extends Command {

	protected ExitCommand(PlayController playController) {
		super(MessageView.EXIT_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).exit();	
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
