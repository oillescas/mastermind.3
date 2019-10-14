package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private PlayController proposalController;

	AttemptsView(PlayController proposalController2) {
		this.proposalController = proposalController2;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.proposalController.getAttempts()));
	}

}
