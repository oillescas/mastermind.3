package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.StartController;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
