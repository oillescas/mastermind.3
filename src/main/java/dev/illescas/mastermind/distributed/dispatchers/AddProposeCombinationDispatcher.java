package dev.illescas.mastermind.distributed.dispatchers;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;
import dev.illescas.mastermind.types.Color;

public class AddProposeCombinationDispatcher extends Dispatcher {

	public AddProposeCombinationDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		List<Color> colors = this.reciveConvination();
		this.tcpip.send(((PlayControllerImpl) this.controller).addProposedCombination(colors));
	}

	private List<Color> reciveConvination() {
		int length = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<length; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		return colors;
	}

}
