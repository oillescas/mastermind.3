package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class GetValueStateDispatcher extends Dispatcher {

	public GetValueStateDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImpl)this.controller).getValueState().ordinal());
	}

}
