package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class RedoableDispatcher extends Dispatcher {

	public RedoableDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImpl)this.controller).redoable());
	}

}
