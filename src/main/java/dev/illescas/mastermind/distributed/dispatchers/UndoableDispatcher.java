package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class UndoableDispatcher extends Dispatcher {

	public UndoableDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImpl)this.controller).undoable());
	}

}
