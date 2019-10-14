package dev.illescas.mastermind.distributed;

import dev.illescas.mastermind.distributed.dispatchers.FrameType;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.StateValue;
import santaTecla.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	@Override
	public StateValue getValueState() {
		this.tcpip.send(FrameType.GET_STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	@Override
	public int getWidthConbination() {
		this.tcpip.send(FrameType.GET_WIDTH.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public String getSessionName() {
		this.tcpip.send(FrameType.GET_SESSION_NAME.name());
		return this.tcpip.receiveLine();
	}

	@Override
	public void setSessionName(String name) {
		this.tcpip.send(FrameType.SET_SESSION_NAME.name());
		this.tcpip.send(name);
		
	}

}
