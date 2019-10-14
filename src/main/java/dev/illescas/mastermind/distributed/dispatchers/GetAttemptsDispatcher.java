package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class GetAttemptsDispatcher extends Dispatcher {

	public GetAttemptsDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImpl)this.controller).getAttempts());
	}

}
