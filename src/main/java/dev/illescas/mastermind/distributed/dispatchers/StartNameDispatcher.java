package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.StartControllerImpl;

public class StartNameDispatcher extends Dispatcher {

	public StartNameDispatcher(StartControllerImpl StartControllerImpl) {
		super(StartControllerImpl);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		((StartControllerImpl) this.controller).start(name);
	}

}
