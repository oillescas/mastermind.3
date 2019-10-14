package dev.illescas.mastermind.distributed;

import dev.illescas.mastermind.controllers.ResumeController;
import dev.illescas.mastermind.distributed.dispatchers.FrameType;
import dev.illescas.mastermind.models.Session;
import santaTecla.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.RESUME.name());
		this.tcpip.send(newGame);	
	}

}
