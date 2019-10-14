package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.impl.StartControllerImpl;

public class GetNamesDispatcher extends Dispatcher {

	public GetNamesDispatcher(StartControllerImpl startControllerImpl) {
		super(startControllerImpl);
	}

	@Override
	public void dispatch() {
		String[] names = ((StartControllerImpl) this.controller).getGamesNames();
		this.tcpip.send(names.length);
		for (int i = 0; i < names.length; i++) {
			this.tcpip.send(names[i]);
		}
	}

}
