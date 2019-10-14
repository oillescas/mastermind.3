package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImpl saveController) {
		super(saveController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImpl) this.controller).hasName());
	}

}
