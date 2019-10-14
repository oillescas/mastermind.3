package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.views.MessageView;

public class RedoCommand extends Command {

	public RedoCommand(PlayController controller) {
		super(MessageView.REDO_COMMAND.getMessage(), controller);
	}

	@Override
	protected void execute() {
		((PlayController)this.acceptorController).redo();
	}

	@Override
	public boolean isActive() {
		return ((PlayController)this.acceptorController).redoable();
	}

}
