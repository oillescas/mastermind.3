package dev.illescas.mastermind;

import dev.illescas.mastermind.distributed.LogicImpServer;
import dev.illescas.mastermind.distributed.dispatchers.DispatcherPrototype;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;

public class MastermindServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImpServer logic;

	private MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImpServer(new SessionImplDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new MastermindServer().serve();
	}

}
