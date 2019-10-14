package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
