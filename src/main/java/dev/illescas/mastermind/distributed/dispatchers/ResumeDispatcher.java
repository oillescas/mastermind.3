package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.ResumeController;
import dev.illescas.mastermind.controllers.impl.ResumeControllerImpl;

public class ResumeDispatcher extends Dispatcher {

	public ResumeDispatcher(ResumeControllerImpl resumeControllerImpl) {
		super(resumeControllerImpl);
	}

	@Override
	public void dispatch() {
		boolean newGame = this.tcpip.receiveBoolean();
		((ResumeController)this.controller).resume(newGame);
	}

}
