package dev.illescas.mastermind.views.console.menu;

import dev.illescas.mastermind.controllers.StartController;

class GameSelectCommand extends Command {

	protected GameSelectCommand(String title, StartController startController) {
		super(title, startController);
	}

	@Override
	protected void execute() {
		System.out.println(this.title);
		((StartController) this.acceptorController).start(this.title);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}