package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class SetNameDispatcher extends Dispatcher {

	public SetNameDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		String title = this.tcpip.receiveLine();
		((SaveControllerImpl)this.controller).setName(title);
	}

}
