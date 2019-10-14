package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class GetWhitesDispatcher extends Dispatcher {

	public GetWhitesDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImpl)this.controller).getWhites(position));
	}

}
