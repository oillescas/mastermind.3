package dev.illescas.mastermind;

import dev.illescas.mastermind.controllers.Logic;
import dev.illescas.mastermind.controllers.impl.LogicImpl;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;
import dev.illescas.mastermind.views.View;
import dev.illescas.mastermind.views.console.ConsoleView;

public class MastermindStandalone extends Mastermind {

	@Override
	protected Logic createLogic() {
		return new LogicImpl(new SessionImplDAO());
	}

	@Override
	protected View createView() {
		return new ConsoleView();
	}
	

	public static void main(String[] args) {
		new MastermindStandalone().play();
	}
}
