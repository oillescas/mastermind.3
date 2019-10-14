package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.controllers.UndoController;
import dev.illescas.mastermind.views.MessageView;

public class UndoCommand extends Command {

	public UndoCommand(PlayController controller) {
		super(MessageView.UNDO_COMMAND.getMessage(), controller);
	}

	@Override
	protected void execute() {
		((UndoController)this.acceptorController).undo();
	}

	@Override
	public boolean isActive() {
		return ((PlayController)this.acceptorController).undoable();
	}
	
}
