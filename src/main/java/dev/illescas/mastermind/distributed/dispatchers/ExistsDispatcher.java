package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class ExistsDispatcher extends Dispatcher {

	public ExistsDispatcher(SaveControllerImpl saveController) {
		super(saveController);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		this.tcpip.send(((SaveControllerImpl) this.controller).exists(name));
	}

}
