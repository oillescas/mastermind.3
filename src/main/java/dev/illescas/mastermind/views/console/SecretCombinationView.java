package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.Controller;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private Controller controller;
	
	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
