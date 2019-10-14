package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;

public class GetBlacksDispatcher extends Dispatcher {

	public GetBlacksDispatcher(PlayControllerImpl playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImpl)this.controller).getBlacks(position));
	}

}
