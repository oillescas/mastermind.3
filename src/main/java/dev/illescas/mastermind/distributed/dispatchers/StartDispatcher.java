package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.StartControllerImpl;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartControllerImpl startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		((StartControllerImpl) this.controller).start();
	}

}
