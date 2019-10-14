package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.Controller;
import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.views.MessageView;

public class NewGameCommand extends Command {


	public NewGameCommand(Controller acceptorController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), acceptorController);
	}


	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void execute() {
		((StartController) this.acceptorController).start();
	}

}
