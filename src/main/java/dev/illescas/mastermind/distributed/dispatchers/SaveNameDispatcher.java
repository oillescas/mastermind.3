package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class SaveNameDispatcher extends Dispatcher {

	public SaveNameDispatcher(SaveControllerImpl saveController) {
		super(saveController);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		((SaveControllerImpl) this.controller).save(name);
	}

}
