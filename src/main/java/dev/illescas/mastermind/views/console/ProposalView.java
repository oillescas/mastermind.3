package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	void interact(PlayController playController) {

		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
