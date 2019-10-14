package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class UndoDispatcher extends Dispatcher {

	public UndoDispatcher( PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		((PlayControllerImpl)this.controller).undo();
	}

}
