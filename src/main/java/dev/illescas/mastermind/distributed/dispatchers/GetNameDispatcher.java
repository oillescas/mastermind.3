package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class GetNameDispatcher extends Dispatcher {

	public GetNameDispatcher(SaveControllerImpl saveController) {
		super(saveController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImpl)this.controller).getName());
	}

}
