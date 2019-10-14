package dev.illescas.mastermind.distributed;

import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.distributed.dispatchers.FrameType;
import dev.illescas.mastermind.models.Session;
import santaTecla.utils.TCPIP;

public class StartControllerProxy extends StartController{
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

	@Override
	public void start(String title) {
		this.tcpip.send(FrameType.START_NAME.name());
		this.tcpip.send(title);
	}

	@Override
	public String[] getGamesNames() {
		this.tcpip.send(FrameType.GET_NAMES.name());
		int length = this.tcpip.receiveInt();
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = this.tcpip.receiveLine();
		}
		return names;
	}
}
