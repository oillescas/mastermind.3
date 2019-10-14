package dev.illescas.mastermind.distributed.dispatchers;

import dev.illescas.mastermind.controllers.VisitableController;
import dev.illescas.mastermind.distributed.dispatchers.TCPIP;

public abstract class Dispatcher {
	
	protected VisitableController controller;
	
	protected TCPIP tcpip;
	
	public Dispatcher (VisitableController controller) {
		this.controller = controller;
	}

	public abstract void dispatch();
	
	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
