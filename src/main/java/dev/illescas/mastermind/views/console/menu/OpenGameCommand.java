package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.views.MessageView;

public class OpenGameCommand extends Command {

	public OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), startController);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

}
