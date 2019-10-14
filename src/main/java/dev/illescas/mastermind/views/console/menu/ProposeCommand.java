package dev.illescas.mastermind.views.console.menu;

import java.util.List;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.types.Error;
import dev.illescas.mastermind.views.MessageView;
import dev.illescas.mastermind.views.console.ErrorView;
import dev.illescas.mastermind.views.console.ProposedCombinationView;

public class ProposeCommand extends Command {

	public ProposeCommand(PlayController controller) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), controller);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(((PlayController)this.acceptorController)).read();
			error = ((PlayController)this.acceptorController).addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
