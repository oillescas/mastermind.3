package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		((PlayControllerImpl)this.controller).redo();
	}

}
