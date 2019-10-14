package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.SaveControllerImpl;

public class SaveDispatcher extends Dispatcher {

	public SaveDispatcher(SaveControllerImpl saveControllerImpl) {
		super(saveControllerImpl);
	}

	@Override
	public void dispatch() {
		((SaveControllerImpl) this.controller).save();
	}
}